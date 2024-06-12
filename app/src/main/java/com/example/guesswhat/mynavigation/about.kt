package com.example.guesswhat.mynavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class about : AppCompatActivity() {

    private lateinit var authorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        authorButton = findViewById(R.id.authorbutton)

        authorButton.setOnClickListener {
            val AboutIntent = Intent(this@about, Author::class.java)
            startActivity(AboutIntent)


        }
    }
}