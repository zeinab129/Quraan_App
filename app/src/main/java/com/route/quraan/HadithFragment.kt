package com.route.quraan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.quraan.adapter.AhadithAdapter
import com.route.quraan.adapter.SauraAdapter
import kotlinx.android.synthetic.main.fragment_hadith.*
import kotlinx.android.synthetic.main.fragment_suras.*


class HadithFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadith, container, false)
    }

    lateinit var adapter: AhadithAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AhadithAdapter(Constants.Ahadith)
        ahadith_rv_list.adapter = adapter
        adapter.onItemClickListener =
            object : AhadithAdapter.OnItemClickListener{
                override fun onItemClick(position: Int, item: String) {
                    val intent = Intent(activity,
                        HadithDetailsActivity::class.java)
                    intent.putExtra(Constants.EXTRA_HADITH_POSITION, position)
                    startActivity(intent)

                }

            }
    }

}
