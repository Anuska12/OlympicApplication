package com.example.olympicapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c = Calendar.getInstance()
        val btn = findViewById<Button>(R.id.btn1)
        val edit_text1 = findViewById<EditText>(R.id.edit_text1)
        val events = findViewById<TextView>(R.id.tv1)
        val relax = findViewById<TextView>(R.id.tv2)

        btn.setOnClickListener {
        if(edit_text1.text.isNotEmpty()!!){
            val splitYear = edit_text1.text.toString().trim().split(",")
            val year2 = splitYear[1].toInt()
            var count = 0
            var relaxCount = 0
            for (i in 2020..year2 step 4){
                val d = Date(i,7,23)
                c.time = d
                    if(Calendar.THURSDAY == c.get(Calendar.DAY_OF_WEEK) || Calendar.FRIDAY == c.get(Calendar.DAY_OF_WEEK) || Calendar.SATURDAY == c.get(Calendar.DAY_OF_WEEK) ){
                   relaxCount++
                }
             count++
            }
           events.text = "Total Event: "+ count.toString()
            relax.text = "Total relax start: "+relaxCount.toString()}
        }
    }
}