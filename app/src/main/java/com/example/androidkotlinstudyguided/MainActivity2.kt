package com.example.androidkotlinstudyguided

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TableLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.androidkotlinstudyguided.adapter.FragmentAdapter
import com.example.androidkotlinstudyguided.fragments.Fragment_1
import com.example.androidkotlinstudyguided.fragments.Fragment_2
import com.example.androidkotlinstudyguided.fragments.Fragment_3
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity2 : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var fragmentAdapter: FragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val dataPassed = intent.extras?.getString("passedData").toString()
        Log.i("PASSED DATA", dataPassed)

        viewPager2 = findViewById(R.id.viewPager2)
        tabLayout = findViewById(R.id.tabLayout)
        initializeFragments()
    }

    private fun initializeFragments() {
        fragmentAdapter = FragmentAdapter(supportFragmentManager, lifecycle)
        fragmentAdapter.addFragment(Fragment_1(), "Fragment 1")
        fragmentAdapter.addFragment(Fragment_2(), "Fragment 2")
        fragmentAdapter.addFragment(Fragment_3(), "Fragment 3")

        viewPager2.adapter = fragmentAdapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = fragmentAdapter.getFragmentList()[position]
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}