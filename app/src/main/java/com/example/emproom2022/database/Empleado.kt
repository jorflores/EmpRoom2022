package com.example.emproom2022.database

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Empleado @Ignore constructor  (
    @PrimaryKey(autoGenerate = true) var id: Int,
    @NonNull @ColumnInfo(name ="nombre") var nombre: String,
    @NonNull @ColumnInfo(name ="departamento") var departamento: String,
    @NonNull @ColumnInfo(name ="email") var email: String
) : Parcelable {

    constructor (nombre: String, departamento: String, email: String) : this(0,nombre,departamento,email) {

    }


}