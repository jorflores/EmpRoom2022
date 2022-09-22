package com.example.emproom2022.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EmpleadoDao  {

    @Query("SELECT * FROM Empleado order by nombre ASC")
    fun getAllEmpleados() : LiveData<List<Empleado>>

    @Insert
    suspend  fun addEmpleado(empleado: Empleado)

    @Update
    suspend fun updateEmpleado(empleado: Empleado)

    @Delete
    suspend fun deleteEmpleado(empleado: Empleado)

}