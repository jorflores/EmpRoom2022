package com.example.emproom2022

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.emproom2022.database.Empleado
import com.example.emproom2022.database.EmpleadoDao

class EmpleadoRepository (private val empleadoDao: EmpleadoDao) {


    // Sin anotaciones

    fun getAllEmpleados() : LiveData<List<Empleado>> {
        return empleadoDao.getAllEmpleados()
    }


    suspend  fun addEmpleado(empleado: Empleado) {
        empleadoDao.addEmpleado(empleado)
    }


    suspend fun updateEmpleado(empleado: Empleado) {
        empleadoDao.updateEmpleado(empleado)
    }


    suspend fun deleteEmpleado(empleado: Empleado) {
        empleadoDao.deleteEmpleado(empleado)
    }



}