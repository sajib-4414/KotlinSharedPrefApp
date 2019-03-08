package com.example.arefin.registerlistapplication

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
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
