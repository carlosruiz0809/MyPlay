package com.example.myplay.DataBasePlay.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Play")
data class Play(
    @ColumnInfo(name = "EquipoA")
    val EquipoA: String,
    @ColumnInfo(name = "EquipoB")
    val EquipoB: String,
    @ColumnInfo(name = "PuntosA")
    val PuntosEquipoA: Int,
    @ColumnInfo(name = "PuntosB")
    val PuntosEquipoB: Int,
    @ColumnInfo(name = "Fecha")
    val Fecha: String,
    @ColumnInfo(name = "Hora")
    val Hora: String
){
    @PrimaryKey(autoGenerate = true)
    var Id_Play: Int = 0
}