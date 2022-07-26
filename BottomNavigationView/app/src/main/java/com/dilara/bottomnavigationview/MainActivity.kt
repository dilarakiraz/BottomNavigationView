package com.dilara.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dilara.bottomnavigationview.fragments.HomeFragment
import com.dilara.bottomnavigationview.fragments.SearchFragment
import com.dilara.bottomnavigationview.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment=HomeFragment()
    private val settingsFragment=SettingsFragment()
    private val searchFragment=SearchFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)
        bottom_navigation.setOnItemReselectedListener {
            when(it.itemId){
                R.id.settings ->replaceFragment(settingsFragment)
                R.id.search ->replaceFragment(searchFragment)
                R.id.homefragment ->replaceFragment(homeFragment)
            }
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment !=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }

    }
}