package com.example.emproom2022.database

import android.content.Context
import android.content.res.Resources
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Empleado::class],version=1)
abstract class EmpleadoDatabase : RoomDatabase() {

    abstract  fun empleadoDao(): EmpleadoDao


    companion object {

        @Volatile
        private var INSTANCE: EmpleadoDatabase? = null

        fun getDatabase(context: Context) : EmpleadoDatabase {

            return  INSTANCE ?: synchronized(this) {

                val instance = Room
                    .databaseBuilder(context, EmpleadoDatabase::class.java, "empleados_db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }


}