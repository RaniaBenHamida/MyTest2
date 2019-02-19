package com.example.mytest2.views

import android.app.Activity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mytest2.R
import kotlinx.android.synthetic.main.second_layout.*

class SecondActiviyy : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        // get data from intent
        val title = intent.getStringExtra("Titre")
        val date = intent.getStringExtra("Date")
        val copy = intent.getStringExtra("Copy")
        val explanation = intent.getStringExtra("Explanation")
        val url = intent.getStringExtra("Url")


        txtTitleSecondLayout.text = title
        txtDateSecondLayout.text = date
        txtExpSecondLayout.text= explanation
        copyRightSecondLayout.text = copy
        Glide.with(this).load(url).into(imgAstroSecondLayout)

    }

}
