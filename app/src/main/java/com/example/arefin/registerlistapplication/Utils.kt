package com.example.arefin.registerlistapplication

import android.content.Context
import com.example.arefin.registerlistapplication.Constants.Companion.gson
import com.example.arefin.registerlistapplication.models.Candidate
import com.google.gson.reflect.TypeToken

class Utils {
    companion object {
        fun getListFromSharedPref(context: Context): ArrayList<Candidate>? {
            val preference = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
            val json = preference.getString(Constants.LIST_GSON_NAME, "")
            var personList: ArrayList<Candidate>? = gson.fromJson(json, object : TypeToken<List<Candidate>>() {}.type)
            if (personList == null)
                personList = ArrayList()
            return personList
        }

        fun saveCandidateInSharedPref(context: Context, candidate: Candidate) {
            val personList: ArrayList<Candidate>? = getListFromSharedPref(context)
            val editor = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
            personList!!.add(candidate)
            editor.putString(Constants.LIST_GSON_NAME, gson.toJson(personList))
            editor.apply()
        }
    }
}