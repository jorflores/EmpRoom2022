package com.example.emproom2022

import android.os.Bundle
import android.system.Os.accept
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.emproom2022.database.Empleado
import com.example.emproom2022.databinding.FragmentDetallesBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetallesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetallesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentDetallesBinding ? = null
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
        _binding = FragmentDetallesBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {

            var empleado = it.get("empleado") as Empleado

            binding.editTextNombre.setText(empleado.nombre)
            binding.editTextDepartamento.setText(empleado.departamento)
            binding.editTextEmail.setText(empleado.email)


            binding.imageButtonEdit.setOnClickListener {
                binding.editTextNombre.isEnabled  = true
                binding.editTextDepartamento.isEnabled  = true
                binding.editTextEmail.isEnabled  = true
            }

            binding.buttonEdit.setOnClickListener{
                var nombre =binding.editTextNombre.text.toString()
                val departamento = binding.editTextDepartamento.text.toString()
                val email = binding.editTextEmail.text.toString()

                empleado.nombre = nombre
                empleado.departamento = departamento
                empleado.email = email

                evm.updateEmpleado(empleado)

                binding.editTextNombre.isEnabled  = false
                binding.editTextDepartamento.isEnabled  = false
                binding.editTextEmail.isEnabled  = false
            }

            binding.buttonEliminar.setOnClickListener {

                MaterialAlertDialogBuilder(requireActivity())
                    .setTitle("Eliminar Empleado")
                    .setMessage("Estas seguro que desea eliminar este empleado?")
                    .setNegativeButton("No") { dialog, which ->
                          dialog.dismiss()
                    }
                    .setPositiveButton("Si") { dialog, which ->
                        evm.deleteEmpleado(empleado)
                        findNavController().navigate(R.id.action_detallesFragment_to_homeFragment)
                    }
                    .show()
            }
        }

    }

}