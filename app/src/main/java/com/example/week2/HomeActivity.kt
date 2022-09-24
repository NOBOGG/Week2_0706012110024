package com.example.week2

import Adapter.ListHewanRvAdapter
import Database.GlobalVar
import Database.GlobalVar.Companion.listDataHewan
import Database.GlobalVar.Companion.filter
import Model.Ayam
import Model.Hewan
import Model.Kambing
import Model.Sapi
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private var adapter= ListHewanRvAdapter(listDataHewan)
    private var adapter2 = ListHewanRvAdapter(filter)

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        setupRecyclerView()
        hidetext()
        listener()
    }

    fun listener(){
        binding.addHewanFAB.setOnClickListener {
            val myIntent = Intent(this,InputActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        hidetext()
        filter.clear()
        binding.ayamFilterbutton.setOnClickListener {
            filter.clear()
            for (item in listDataHewan){
                if (item is Ayam){
                    filter.add(item)
                }
            }
            binding.listHewanRV.adapter = adapter2
        }
        binding.sapiFilterbutton.setOnClickListener {
            filter.clear()
            for (item in listDataHewan){
                if (item is Sapi){
                    filter.add(item)
                }
            }
            binding.listHewanRV.adapter = adapter2
        }
        binding.kambingFilterbutton.setOnClickListener {
            filter.clear()
            for (item in listDataHewan){
                if (item is Kambing){
                    filter.add(item)
                }
            }
            binding.listHewanRV.adapter = adapter2
        }
        binding.resetFilterbutton.setOnClickListener {
            binding.listHewanRV.adapter=adapter
        }

        adapter.notifyDataSetChanged()
    }


    private fun hidetext(){
        if(listDataHewan.isEmpty()){
            binding.addTextview.isVisible = true
        } else {
            binding.addTextview.isInvisible = true
        }
    }

    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(baseContext)
        binding.listHewanRV.layoutManager= layoutManager //Set layout
        binding.listHewanRV.adapter=adapter //Set adapter
    }
}