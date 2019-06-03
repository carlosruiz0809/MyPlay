package com.example.myplay

import android.os.Parcel
import android.os.Parcelable
import java.sql.Date

class PlayDTO (
    val equipoA:String = "N/A",
    val equipoB:String = "N/A",
    val puntosEquipoA:Int = 0,
    val puntosEquipoB:Int = 0,
    val fecha:String = "01/01/2010",
    val hora:String = "0:00"
): Parcelable {
    constructor(parcel: Parcel):this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()) {}

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(equipoA)
        parcel.writeString(equipoB)
        parcel.writeInt(puntosEquipoA)
        parcel.writeInt(puntosEquipoB)
        parcel.writeString(fecha)
        parcel.writeString(hora)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlayDTO> {
        override fun createFromParcel(parcel: Parcel): PlayDTO {
            return PlayDTO(parcel)
        }

        override fun newArray(size: Int): Array<PlayDTO?> {
            return arrayOfNulls(size)
        }
    }
}