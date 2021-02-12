package com.example.patientvalidation.ViewModel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.patientvalidation.Model.User
import com.example.patientvalidation.ValidationRepo.Validation

class UserViewModel : ViewModel{
     var Validation:Validation
    constructor(application: Application):super(){
        Validation= Validation(application)
    }

    fun validateCredentials(email:String,phone:String):LiveData<String>{
        return Validation.validateCredentials(email,phone)
    }


}


