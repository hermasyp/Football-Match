package com.catnipdev.footballmatch.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.catnipdev.footballmatch.R
import com.catnipdev.footballmatch.ui.adapter.ViewPagerAdapter
import com.catnipdev.footballmatch.ui.main.fragment.favorite.FavoriteFrag
import com.catnipdev.footballmatch.ui.main.fragment.lastmatch.LastMatchFrag
import com.catnipdev.footballmatch.ui.main.fragment.nextmatch.NextMatchFrag
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_next_match -> {
                viewpager.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_last_match -> {
                viewpager.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_favorite -> {
                viewpager.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    fun setupViewPager(){
        viewpager.setPaging(false)
        viewpager.offscreenPageLimit = 3
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(NextMatchFrag(),"Next Match")
        adapter.addFragment(LastMatchFrag(),"Last Match")
        adapter.addFragment(FavoriteFrag(),"Favorited Match")
        viewpager.adapter = adapter
    }


}
