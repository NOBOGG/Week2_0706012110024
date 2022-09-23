package Model

import android.widget.Toast

class Ayam(nama:String,jenis:String,usia:String) : Hewan(nama,jenis,usia) {

    override fun animalSound():String {

        return "Bock bock bock ..."

    }

}