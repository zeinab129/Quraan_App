package com.route.quraan

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        nav_view.setOnNavigationItemSelectedListener{
            var fragment:Fragment? = null
            if(it.itemId == R.id.navigation_quraan){
                fragment = SurasFragment()
            }else if(it.itemId == R.id.navigation_sebha){
                fragment = SebhaFragment()
            }else if(it.itemId == R.id.navigation_hadith){
                fragment = HadithFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment?:SurasFragment())
                .commit()
            return@setOnNavigationItemSelectedListener true
        }
        nav_view.selectedItemId = R.id.navigation_quraan
    }
}
