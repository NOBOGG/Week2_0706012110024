package Adapter

import Database.GlobalVar
import Database.GlobalVar.Companion.listDataHewan
import Model.Ayam
import Model.Hewan
import Model.Kambing
import Model.Sapi
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.week2.InputActivity
import com.example.week2.R
import com.example.week2.databinding.CardviewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListHewanRvAdapter(val listHewan:ArrayList<Hewan>):
    RecyclerView.Adapter<ListHewanRvAdapter.viewHolder>() {

    class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = CardviewBinding.bind(itemView)

        fun setdata(data:Hewan){
            binding.nameTextview.text=data.nama
            binding.typeCard.text=data.jenis
            binding.ageCard.text=data.usia
            if (data.imageUri.isNotEmpty()){
                binding.imageViewHewan.setImageURI(Uri.parse(data.imageUri))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.cardview, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.setdata(listHewan[position])
        holder.binding.deleteButton.setOnClickListener {
            val alertDialog = AlertDialog.Builder(it.context)
            alertDialog.apply {
                setTitle("Konfirmasi")
                setMessage("Apakah anda yakin untuk mendelete hewan ini?")
                setNegativeButton("No", { dialogInterface, i -> dialogInterface.dismiss() })
                setPositiveButton("Yes", { dialogInterface, i -> dialogInterface.dismiss()
                    GlobalVar.listDataHewan.removeAt(position)
                    notifyDataSetChanged()
                    Toast.makeText(it.context, "Hewan Berhasil Di Hapus", Toast.LENGTH_SHORT).show()
                })
                alertDialog.show()
            }
        }
        holder.binding.editButton.setOnClickListener {
            val intent = Intent(it.context, InputActivity::class.java).putExtra("position",position)
            it.context.startActivity(intent)
        }
        holder.binding.soundImgbutton.setOnClickListener {
            Toast.makeText(it.context, listDataHewan.get(position).animalSound(), Toast.LENGTH_SHORT).show()
        }
        holder.binding.foodImgbutton.setOnClickListener {
            if(listDataHewan.get(position) is Ayam){
                Toast.makeText(it.context, listDataHewan.get(position).feedAnimal(listDataHewan.get(position).feedAnimal(seed = String())), Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(it.context, listDataHewan.get(position).feedAnimal(grass = 0), Toast.LENGTH_SHORT).show()
            }


        }
    }

    override fun getItemCount(): Int {
        return listHewan.size
    }

}