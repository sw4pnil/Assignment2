package com.test.assignment

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager.LayoutParams.FLAG_SECURE
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * @author swapnil-tml on 26-06-2020.
 * base activity
 */

abstract class BaseActivity : AppCompatActivity() {
    var mProgressBar: ProgressBar? = null
    override fun setContentView(layoutResID: Int) {
        val constraintLayout = layoutInflater.inflate(R.layout.activity_base, null) as ConstraintLayout
        val frameLayout = constraintLayout.findViewById<FrameLayout>(R.id.activity_content)
        mProgressBar = constraintLayout.findViewById(R.id.progress_bar)
        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(constraintLayout)
    }

    fun showProgressBar(visible: Boolean) {
        mProgressBar!!.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}