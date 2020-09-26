package com.route.quraan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.quraan.adapter.SauraAdapter
import kotlinx.android.synthetic.main.fragment_suras.*

class SurasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_suras, container, false)
    }

    lateinit var adapter: SauraAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SauraAdapter(Constants.ArSuras)
        suras_rv_list.adapter = adapter
        adapter.onItemClickListener =
            object : SauraAdapter.OnItemClickListener{
                override fun onItemClick(position: Int, item: String) {
                    val intent = Intent(activity,
                        SuraDetailsActivity::class.java)
                    intent.putExtra(Constants.EXTRA_SURA_NAME, item)
                    intent.putExtra(Constants.EXTRA_SURA_POSITION, position)
                    startActivity(intent)

                }

            }
    }

}
