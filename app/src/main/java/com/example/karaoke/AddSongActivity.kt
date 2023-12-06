package com.example.karaoke

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddSongActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_song)

        val entrySong = findViewById<EditText>(R.id.editAddSongEntry)
        val entryArtist = findViewById<EditText>(R.id.editAddArtistEntry)
        val entryGenre = findViewById<EditText>(R.id.editAddGenreEntry)
        val entryDuration = findViewById<EditText>(R.id.editAddDurationEntry)
        val entryLyrics = findViewById<EditText>(R.id.editAddLyricsEntry)

        val buttonAddCancel = findViewById<Button>(R.id.buttonAddCancel)
        val buttonAddConfirm = findViewById<Button>(R.id.buttonAddConfirm)

        entrySong.requestFocus()

        buttonAddCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            onBackPressed()
            Toast.makeText(this, "Cancelling Adding A Song!", Toast.LENGTH_SHORT).show()
        }

        buttonAddConfirm.setOnClickListener {
            val intent = Intent()
            intent.putExtra("song", entrySong.text.toString())
            intent.putExtra("artist", entryArtist.text.toString())
            intent.putExtra("genre", entryGenre.text.toString())
            intent.putExtra("duration", "${entryDuration.text.toString().toInt() / 60}:${entryDuration.text.toString().toInt() % 60}")
            intent.putExtra("lyrics", entryLyrics.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}