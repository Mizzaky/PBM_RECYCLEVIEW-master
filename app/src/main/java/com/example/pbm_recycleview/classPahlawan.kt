package com.example.pbm_recycleview
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//berisi properti yg ditampilkan recycleview
@Parcelize
data class classPahlawan(
    val nama :String,
    val desk : String,
    val img : Int
):Parcelable

