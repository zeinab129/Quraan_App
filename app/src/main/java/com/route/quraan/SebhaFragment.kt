package com.route.quraan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_sebha.*


class SebhaFragment : Fragment() {

    var tasbehaCount: Int = 0
    var totalTasbeehCount: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sebha.setOnClickListener(View.OnClickListener {
            tasbehaCount++
            totalTasbeehCount++

            tasbeha_count.setText(tasbehaCount.toString())
            total_tasbehat_count.setText(totalTasbeehCount.toString())
        })

        refresh.setOnClickListener(View.OnClickListener {
            tasbehaCount = 0
            totalTasbeehCount = 0

            tasbeha_count.setText(tasbehaCount.toString())
            total_tasbehat_count.setText(totalTasbeehCount.toString())
        })

        tasbeeh_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tasbehaCount = 0
                tasbeha_count.setText(tasbehaCount.toString())
            }

        }
    }


}

