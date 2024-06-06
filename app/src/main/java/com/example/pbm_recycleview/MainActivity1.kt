package com.example.pbm_recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity1 : AppCompatActivity() {
    private  lateinit var rview: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rview = findViewById(R.id.rview)
        rview.setHasFixedSize(true)
    }
    //method utk get data dari arraylist dan ditampilkan dlm recycleview
    private fun getData(): ArrayList<classPahlawan>{
        val list = ArrayList<classPahlawan>()
        val dataImg = resources.obtainTypedArray(R.array.data_photo)
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDes = resources.getStringArray(R.array.data_description)

        for (i in  dataName.indices){
            val pahlawan = classPahlawan(
                dataName[i],
                dataDes[i],
                dataImg.getResourceId(i, -1)
            )
            list.add(pahlawan)
        }



        return list
    }
    //menampilkan rv
    private fun showRv(){
        rview.layoutManager = LinearLayoutManager(this)
        val ListPahlawanAdapter = ListAdapter(listArr)
            //parameter listArr dibuat sbg variabel globl
        //private val listArr = ArrayList(classPahlawan)
        rview.adapter = ListPahlawanAdapter



    }
}
