package com.route.quraan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.route.quraan.adapter.VerseAdapter
import kotlinx.android.synthetic.main.activity_sura_details.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class SuraDetailsActivity : AppCompatActivity() {

    lateinit var adapter: VerseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        var suraName = intent.getStringExtra(Constants.EXTRA_SURA_NAME)
        var suraPos = intent.getIntExtra(Constants.EXTRA_SURA_POSITION, -1)

        sura_name_title.setText(suraName)

        val versesList = readSuraFile("${suraPos + 1}.txt")

        adapter = VerseAdapter(versesList)
        sura_rv_verses.adapter = adapter
    }

    fun readSuraFile(fileName:String): List<String>{
        val versesList = mutableListOf<String>()
        val reader: BufferedReader

        try {
            val file: InputStream = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = reader.readLine()
            while (line != null) {
                versesList.add(line)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return versesList
    }
}
