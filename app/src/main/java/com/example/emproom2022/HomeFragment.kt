package com.example.emproom2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emproom2022.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val evm: EmpleadoViewModel by viewModels {
        EmpleadoViewModelFactory((activity?.application as EmpleadoApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAlta.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_altaFragment)
        }



        evm.getAllEmpleados().observe(viewLifecycleOwner) {

            val num_empleados = it.size
            binding.textView.text = "Número de Empleados: ${it.size}"

        val adapter = EmpleadoAdapter(requireContext(),it) {
            val bundle = Bundle()
            bundle.putParcelable("empleado",it)
            findNavController().navigate(R.id.action_homeFragment_to_detallesFragment,bundle)

        }
            binding.rvEmpleados.adapter = adapter
            binding.rvEmpleados.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)

        }




    }
}