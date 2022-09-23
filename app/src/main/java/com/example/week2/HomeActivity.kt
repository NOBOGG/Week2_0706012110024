package com.example.week2

import Adapter.ListHewanRvAdapter
import Database.GlobalVar
import Database.GlobalVar.Companion.listDataHewan
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val adapter= ListHewanRvAdapter(listDataHewan)
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