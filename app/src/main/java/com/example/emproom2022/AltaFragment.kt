package com.example.emproom2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.emproom2022.database.Empleado
import com.example.emproom2022.databinding.FragmentAltaBinding
import com.example.emproom2022.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AltaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AltaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentAltaBinding? = null
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
        // Inflate the layout for this fragment
        _binding = FragmentAltaBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAltaEmpleado.setOnClickListener{


            val nombre =binding.editTextNombre.text.toString()
            val departamento = binding.editTextDepartamento.text.toString()
            val email = binding.editTextEmail.text.toString()



            val empleado = Empleado(nombre,departamento,email)

            evm.addEmpleado(empleado)
            findNavController().navigate(R.id.action_altaFragment_to_homeFragment)


        }


    }
}