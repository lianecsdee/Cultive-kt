package com.cultiveplus.cultiveplusapp.repository

import com.cultiveplus.cultiveplusapp.api.ApiCliente
import com.cultiveplus.cultiveplusapp.api.EstufaApiService
import com.cultiveplus.cultiveplusapp.model.Estufa
import retrofit2.Response

class EstufaRepository {


    // Cria ou obtém instância do ApiClient (singleton)
    private  val apiService: EstufaApiService =
        ApiCliente.createService(EstufaApiService::class.java)

    suspend fun getEstufas(): Response<List<Estufa>> {
        return apiService.getEstufas()
    }

//    suspend fun getUser(id: Int): Response<User>{
//        return apiService.getUser(id)
//    }

//    suspend fun store(user: User): Response<User>{
//        return apiService.store(user)
//    }
}