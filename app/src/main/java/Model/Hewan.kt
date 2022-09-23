package Model

import android.os.Parcel
import android.os.Parcelable

open class Hewan (
    var nama:String?,
    var jenis:String?,
    var usia:String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString().toString()
    ) {
    }

    var imageUri:String=""

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(jenis)
        parcel.writeString(usia)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hewan> {
        override fun createFromParcel(parcel: Parcel): Hewan {
            return Hewan(parcel)
        }

        override fun newArray(size: Int): Array<Hewan?> {
            return arrayOfNulls(size)
        }
    }
    open fun animalSound():String{
        return ""
    }
    fun feedAnimal(seed: String?):String{
        return "Kamu memberi makan hewan dengan biji bijian!"
    }
    fun feedAnimal(grass: Int):String{
        return "Kamu memberi makan hewan dengan rerumputan!"
    }
}