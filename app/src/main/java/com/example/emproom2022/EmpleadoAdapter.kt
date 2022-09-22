package com.example.emproom2022

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emproom2022.database.Empleado
import com.example.emproom2022.databinding.ListaEmpleadosBinding
import java.util.*

class EmpleadoAdapter (val context: Context, var empleados: List<Empleado>,
                       private val funcionX : (Empleado) ->Unit ) :
                       RecyclerView.Adapter<EmpleadoAdapter.ViewHolder>()

{
    class ViewHolder(val binding: ListaEmpleadosBinding, funcionZ: (Int) -> Unit  ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener{
                funcionZ(adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListaEmpleadosBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view) {
            funcionX(empleados[it])
        }


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {


            textViewNombre.text = empleados[position].nombre
            textViewDepartamento.text = empleados[position].departamento
            textViewEmail.text = empleados[position].email

        }

    }

    override fun getItemCount(): Int {
        return empleados.size
    }
}