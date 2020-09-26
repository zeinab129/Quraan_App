package com.route.quraan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hadith_details.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class HadithDetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadith_details)

        var hadithPos = intent.getIntExtra(Constants.EXTRA_HADITH_POSITION, -1)
        var hadith: String = ""

        val hadithList = readHadithFile("h${hadithPos + 1}.txt")

        hadith_title.setText(hadithList.get(0))
        for ((index, line) in hadithList.withIndex()){
            if(index != 0)
                hadith += " $line"
        }

        hadith_content.setText(hadith)

    }

    fun readHadithFile(fileName:String): List<String>{
        val hadithList = mutableListOf<String>()
        val reader: BufferedReader

        try {
            val file: InputStream = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = reader.readLine()
            while (line != null) {
                hadithList.add(line)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return hadithList
    }
}
