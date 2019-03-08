package com.example.arefin.registerlistapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.arefin.registerlistapplication.models.Candidate
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_candidate_details.*

class CandidateDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_details)
        setToolbar(R.string.candidate_details)
        setData()
    }

    private fun setData() {
        if (intent !=null){
            val gson = Gson()
            val candidate:Candidate = gson.fromJson(intent.getStringExtra(Constants.OBJECT_NAME),Candidate::class.java)
            tv_can_full_name.text = candidate.fullName
            tv_can_country.text = candidate.countryName
            tv_candidate_gender.text = if (candidate.male) getText(R.string.male) else getText(R.string.female)
            tv_candidate_phone.text = candidate.phoneNumber
            tv_can_email.text = candidate.email
            tv_can_passport_now.text = candidate.passportNumber
        }
    }
}
