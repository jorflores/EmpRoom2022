package com.example.emproom2022

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.emproom2022.database.Empleado
import kotlinx.coroutines.launch

class EmpleadoViewModel(private val repository: EmpleadoRepository) : ViewModel() {


    // sin el suspend
    fun getAllEmpleados(): LiveData<List<Empleado>> {
        return repository.getAllEmpleados()
    }
    fun addEmpleado(empleado: Empleado) {

        viewModelScope.launch {
            repository.addEmpleado(empleado)
        }
    }

    fun updateEmpleado(empleado: Empleado) {
        viewModelScope.launch {
            repository.updateEmpleado(empleado)
        }
    }

    fun deleteEmpleado(empleado: Empleado) {
        viewModelScope.launch {
            repository.deleteEmpleado(empleado)
        }
    }
}


class EmpleadoViewModelFactory (private val repository: EmpleadoRepository) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmpleadoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EmpleadoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}