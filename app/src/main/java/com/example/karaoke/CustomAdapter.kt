package com.example.karaoke

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapter(private var ctx: Context,
                    private var ourResource: Int,
                    private var items: ArrayList<Model>): ArrayAdapter<Model>(ctx, ourResource, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(ourResource, null)

        val song = view.findViewById<TextView>(R.id.textCustomLineSong)
        val artist = view.findViewById<TextView>(R.id.textCustomLineArtist)
        val genre = view.findViewById<TextView>(R.id.textCustomLineGenre)
        val duration = view.findViewById<TextView>(R.id.textCustomLineDuration)

        song.text = items[position].name
        artist.text = items[position].artist
        genre.text = items[position].genre
        duration.text = items[position].duration

        return view
    }
}