package Model

import android.widget.Toast

class Kambing(nama:String?,jenis:String?,usia:String) : Hewan(nama,jenis,usia) {

    override fun animalSound():String {
       return "Mbek mbek mbek..."
    }


}