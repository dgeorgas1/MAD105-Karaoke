package com.example.karaoke

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DeleteSongActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_song)

        val entrySong = findViewById<EditText>(R.id.editDeleteSongEntry)
        val buttonDeleteCancel = findViewById<Button>(R.id.buttonDeleteCancel)
        val buttonDeleteConfirm = findViewById<Button>(R.id.buttonDeleteConfirm)

        buttonDeleteCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            onBackPressed()
            Toast.makeText(this, "Cancelling Deleting A Song!", Toast.LENGTH_SHORT).show()
        }

        buttonDeleteConfirm.setOnClickListener {
            val intent = Intent()
            intent.putExtra("song", entrySong.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}