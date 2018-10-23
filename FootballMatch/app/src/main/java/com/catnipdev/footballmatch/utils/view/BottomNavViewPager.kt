package com.catnipdev.footballmatch.utils.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class BottomNavViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    private var enable: Boolean = false

    init { this.enable = true }

    override fun onTouchEvent(event: MotionEvent): Boolean = this.enable && super.onTouchEvent(event)
    override fun onInterceptTouchEvent(event: MotionEvent): Boolean = this.enable && super.onInterceptTouchEvent(event)

    fun setPaging(enabled: Boolean) {
        this.enable = enabled
    }

}