package com.example.arefin.registerlistapplication

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.arefin.registerlistapplication.models.Candidate
import kotlinx.android.synthetic.main.activity_register.*
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.arefin.registerlistapplication.Constants.Companion.PREFERENCE_NAME
import android.R.id.edit
import android.content.SharedPreferences.Editor
import com.example.arefin.registerlistapplication.Constants.Companion.LIST_GSON_NAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setToolbar(R.string.register)

        btn_save.setOnClickListener({
            if (validationPassed()){
                saveToModel();
            }
        })
    }

    private fun saveToModel() {
        val candidate = Candidate()
        candidate.firstName = input_firstname.text.toString()
        candidate.lastName = input_lastname.text.toString()
        candidate.countryName = input_country.text.toString()
        candidate.passportNumber = input_passport_no.text.toString()
        candidate.phoneNumber = input_phone_no.text.toString()
        candidate.email = input_email.text.toString()
        candidate.male = rd_male.isChecked
        saveItem(candidate)
    }

    private fun saveItem(candidate: Candidate) {
        val gson = Gson()
        val preference=this.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = preference.edit()
        val json = preference.getString(LIST_GSON_NAME, "")
        var personList: ArrayList<Candidate>? = gson.fromJson(json, object : TypeToken<List<Candidate>>() {}.type)
        if(personList == null){
            personList = ArrayList<Candidate>()
        }
        personList.add(candidate)
        editor.putString(LIST_GSON_NAME, gson.toJson(personList))
        editor.apply()
        Toast.makeText(this,getText(R.string.data_saved), Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun validationPassed(): Boolean {
        val errorMessage  = "This field is required"
        if(input_firstname.text.isEmpty()){
            input_firstname.error = errorMessage
            input_firstname.requestFocus()
            return false
        }
        if(input_lastname.text.isEmpty()){
            input_lastname.error = errorMessage
            input_lastname.requestFocus()
            return false
        }
        if(input_country.text.isEmpty()){
            input_country.error = errorMessage
            input_country.requestFocus()
            return false
        }
        if(input_passport_no.text.isEmpty()){
            input_passport_no.error = errorMessage
            input_passport_no.requestFocus()
            return false
        }
        if(!rd_male.isChecked && !rd_female.isChecked){
            Toast.makeText(this,getText(R.string.gender_required), Toast.LENGTH_SHORT).show()
            return false
        }
        if(input_phone_no.text.isEmpty()){
            input_phone_no.error = errorMessage
            input_phone_no.requestFocus()
            return false
        }
        if(input_email.text.isEmpty()){
            input_email.error = errorMessage
            input_email.requestFocus()
            return false
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(input_email.text).matches()){
            input_email.error = getString(R.string.enter_valid_email)
            input_email.requestFocus()
            return false
        }
        return true
    }
}
