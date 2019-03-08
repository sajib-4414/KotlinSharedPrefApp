package com.example.arefin.registerlistapplication

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arefin.registerlistapplication.Constants.Companion.gson
import com.example.arefin.registerlistapplication.models.Candidate
import kotlinx.android.synthetic.main.candidate_list_item.view.*

class ListAdapter(private val userList: ArrayList<Candidate>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.candidate_list_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is holding the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(candidate: Candidate) {
            itemView.tv_candidate_name.text=candidate.firstName + " " + candidate.lastName
            itemView.tv_candidate_email.text=candidate.email
            itemView.setOnClickListener {
                val myIntent = Intent(itemView.context,CandidateDetailsActivity::class.java)
                myIntent.putExtra(Constants.OBJECT_NAME, gson.toJson(candidate))
                itemView.context.startActivity(myIntent)
            }
        }
    }

}
