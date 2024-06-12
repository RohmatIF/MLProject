package com.example.guesswhat.mynavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class infotambahan : AppCompatActivity() {
    private lateinit var infokolomButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infotambahan)
        infokolomButton = findViewById(R.id.btninfokolom)

        infokolomButton.setOnClickListener{
            val aboutIntent = Intent(this@infotambahan, InfoKolom::class.java)
            startActivity(aboutIntent)
        }
    }
}