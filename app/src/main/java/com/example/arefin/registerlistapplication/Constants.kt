package com.example.arefin.registerlistapplication

import com.google.gson.Gson

interface Constants {
    companion object{
        const val PREFERENCE_NAME: String = "com.netizen.sharedpreference"
        const val LIST_GSON_NAME: String = "LIST_DATA"
        const val OBJECT_NAME: String = "PERSON"
        val gson: Gson = Gson()
    }

}