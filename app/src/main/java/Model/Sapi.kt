package Model

import android.widget.Toast

class Sapi(nama:String?,jenis:String?,usia:String) : Hewan(nama,jenis,usia) {

    override fun animalSound():String {
        return "Moo moo moo..."
    }


}