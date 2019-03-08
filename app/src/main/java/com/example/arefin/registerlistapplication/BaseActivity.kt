package com.example.arefin.registerlistapplication

import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

open class BaseActivity : AppCompatActivity() {
    fun setToolbar(titleResourceId:Int,isBackButtonNeeded:Boolean=true) {
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(titleResourceId)
        if(isBackButtonNeeded){
            supportActionBar?.setDisplayHomeAsUpEnabled(true);
            supportActionBar?.setDisplayShowHomeEnabled(true);
            toolbar.setNavigationOnClickListener({finish()})
        }
    }
}