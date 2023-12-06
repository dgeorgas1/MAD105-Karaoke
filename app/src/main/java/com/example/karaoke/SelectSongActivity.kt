package com.example.karaoke

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.ScrollingMovementMethod
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SelectSongActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_song)

        val selectedSong = findViewById<TextView>(R.id.textSelectedSong)
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val selectedLyrics = findViewById<TextView>(R.id.textSelectLyrics)
        val goBackButton = findViewById<Button>(R.id.buttonGoBack)

        val song = intent.getStringExtra("song")
        val lyrics = intent.getStringExtra("lyrics")

        val underlineSong = SpannableString(song)
        underlineSong.setSpan(UnderlineSpan(), 0, song.toString().length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        selectedSong.text = underlineSong
        selectedLyrics.text = lyrics

        scrollView.setOnTouchListener { _, _ -> true }
        selectedLyrics.movementMethod = ScrollingMovementMethod.getInstance()

        goBackButton.setOnClickListener {
            val intent = Intent()
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}