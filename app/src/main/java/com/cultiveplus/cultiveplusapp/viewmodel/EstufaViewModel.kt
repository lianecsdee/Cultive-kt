package com.cultiveplus.cultiveplusapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cultiveplus.cultiveplusapp.model.Estufa
import com.cultiveplus.cultiveplusapp.repository.EstufaRepository
import kotlinx.coroutines.launch

class EstufaViewModel: ViewModel() {

    // Instância do Repository
    private val repository = EstufaRepository()

    // LiveData que a Activity irá observar (estado de sucesso)
    private val _estufas = MutableLiveData<List<Estufa>>()
    val estufas: LiveData<List<Estufa>> = _estufas

    // LiveData para tratar erros (estado de falha)
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    // LiveData para o estado de carregamento (loading)
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        // Chamada inicial para carregar os dados
        loadEstufas()
    }

    fun loadEstufas(){
        _isLoading.value = true

        // viewModelScope garante que a Coroutine será cancelada quando o ViewModel morrer
        viewModelScope.launch {
            try {
                val response = repository.getEstufas()

                if (response.isSuccessful){
                    _estufas.value = response.body() //Sucesso: atualiza o LiveData
                }
                else{
                    _errorMessage.value = "Erro ao buscar dados: Código ${response.code()}"
                }
            }
            catch (e: Exception){
                _errorMessage.value = "Falha de rede: ${e.message}"
            }
            finally {
                _isLoading.value = false // Finaliza o loading
            }
        }
    }
}