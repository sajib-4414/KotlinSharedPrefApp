package com.example.arefin.registerlistapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar(R.string.dash_board,false)
        btn_register_new.setOnClickListener({
            val myIntent = Intent(this,RegisterActivity::class.java)
            startActivity(myIntent)
        })
        btn_registered_candidates.setOnClickListener({
            val myIntent = Intent(this,CandidateListActivity::class.java)
            startActivity(myIntent)
        })
    }
}
