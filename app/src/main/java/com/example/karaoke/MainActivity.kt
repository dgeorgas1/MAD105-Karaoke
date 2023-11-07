package com.example.karaoke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addSongButton = findViewById<Button>(R.id.buttonAddSong)
        val deleteSongButton = findViewById<Button>(R.id.buttonDeleteSong)
        val selectSongButton = findViewById<Button>(R.id.buttonSelectSong)

        addSongButton.setOnClickListener {
            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show()
        }

        deleteSongButton.setOnClickListener {
            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show()
        }

        selectSongButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}