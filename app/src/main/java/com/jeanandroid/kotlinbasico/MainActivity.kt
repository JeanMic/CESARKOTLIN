package com.jeanandroid.kotlinbasico

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() , View.OnClickListener {

    var ImgTrab: ImageView? = null
    var ImsCasa: ImageView? = null
    var ImgConfig: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onClick(v: View?) {

    }
}
