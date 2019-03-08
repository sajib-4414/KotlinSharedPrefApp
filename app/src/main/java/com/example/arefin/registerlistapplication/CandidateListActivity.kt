package com.example.arefin.registerlistapplication

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.arefin.registerlistapplication.models.Candidate
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_candidate_list.*

class CandidateListActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_list)
        setToolbar(R.string.registered_candidates)
        setData()
    }



    private fun setData() {
        val personList = Utils.getListFromSharedPref(this)
        if( personList!!.size ==0 ){
            tv_no_available_candidates.visibility = View.VISIBLE
        }
        else{
            tv_no_available_candidates.visibility = View.GONE
            // Creates a vertical Layout Manager
            rv_can_list.layoutManager = LinearLayoutManager(this)

            //Initialize the adapter
            rv_can_list.adapter = ListAdapter(personList)
        }
    }
}
