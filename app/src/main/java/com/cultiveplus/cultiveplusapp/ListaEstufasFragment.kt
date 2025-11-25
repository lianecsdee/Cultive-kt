package com.cultiveplus.cultiveplusapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cultiveplus.cultiveplusapp.databinding.FragmentListaEstufasBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.cultiveplus.cultiveplusapp.model.EstufaAdapter
import com.cultiveplus.cultiveplusapp.viewmodel.EstufaViewModel

class ListaEstufasFragment : Fragment() {

    private val viewModel: EstufaViewModel by viewModels()

    // ViewBinding é tratado com 'nullable' e 'backing property'
    private var _binding: FragmentListaEstufasBinding? = null
    private val binding get() = _binding!! // Acesso seguro ao binding

    private lateinit var estufaAdapter: EstufaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaEstufasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
    }

    // Limpeza do Binding (Crítico para Fragmentos!)
    override fun onDestroyView() {
        super.onDestroyView()
        // Devemos limpar a referência ao binding para evitar vazamentos de memória (memory leaks)
        // O binding só é válido entre onCreateView e onDestroyView.
        _binding = null
    }

    private fun setupObservers(){
        viewModel.estufas.observe(viewLifecycleOwner){ estufaList ->
            // Se houver dados, atualiza o adapter e a visibilidade
            if(!estufaList.isNullOrEmpty()){
                binding.recyclerView.visibility = View.VISIBLE
                estufaAdapter.submitList(estufaList)
            }
            else{
                binding.emptyStateView.visibility = View.VISIBLE
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner){ isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.errorMessage.observe(viewLifecycleOwner){ message ->
            showError(message)
        }
    }

    private fun showError(message: String){
        binding.recyclerView.visibility = View.GONE
        binding.emptyStateView.visibility = View.VISIBLE
        binding.tvErrorMessage.text = message
    }

    private fun setupRecyclerView() {
        estufaAdapter = EstufaAdapter{ estufa -> }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = estufaAdapter
        }
    }
}