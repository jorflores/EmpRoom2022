package com.example.emproom2022

import android.app.Application
import com.example.emproom2022.database.EmpleadoDatabase

class EmpleadoApp : Application() {


    val database : EmpleadoDatabase by lazy {EmpleadoDatabase.getDatabase(this)}

    val repository : EmpleadoRepository by lazy {EmpleadoRepository(database.empleadoDao())}


}