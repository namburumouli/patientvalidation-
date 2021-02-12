package com.example.patientvalidation


import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.patientvalidation.presenter.Handler
import com.example.patientvalidation.ViewModel.UserViewModel
import com.example.patientvalidation.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity(),Handler {

    lateinit var binding: ActivityMainBinding
    lateinit var viewmodel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //viewmodel
         viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)

        //set binding para
        binding.viewmodel=viewmodel






        //calender
        var c= Calendar.getInstance()
        var cyear=c.get(Calendar.YEAR)
        var cmonth=c.get(Calendar.MONTH)
        var cday=c.get(Calendar.DAY_OF_MONTH)
        // button clicke to show calender
        binding.userdateofbirth.setOnClickListener(){
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                cyear=year
                cmonth=monthOfYear
                cday=dayOfMonth
                // Display Selected date in textbox
                val currentyear=Calendar.getInstance()
                        .get(Calendar.YEAR)
                val age=currentyear-cyear
                binding.userage.setText(age.toString())

            }, cyear, cmonth, cday)
            dpd.show()
        }



    }
    fun showToast(value:String){
        Toast.makeText(this,""+value,Toast.LENGTH_LONG).show()
    }

    override fun registerClick() {
        var email=binding.useremail.text.toString()
        var phone=binding.usernumber.text.toString()

       viewmodel.validateCredentials(email,phone)
    }
}

