package com.catnipdev.footballmatch.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import java.util.ArrayList

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class ViewPagerAdapter (fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    private val listFragment = ArrayList<Fragment>()
    private val listFragmentTitle = ArrayList<String>()

    override fun getItem(position: Int): Fragment = listFragment[position]

    override fun getCount(): Int = listFragment.size

    override fun getPageTitle(position: Int): CharSequence? = listFragmentTitle[position]

    fun addFragment(fragment: Fragment, title: String) {
        listFragment.add(fragment)
        listFragmentTitle.add(title)
    }
}