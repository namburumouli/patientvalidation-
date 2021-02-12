package com.example.patientvalidation.ValidationRepo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.patientvalidation.textinputvalidation

class Validation (application: Application){

    var application:Application
    init{
        this.application=application
    }

    fun validateCredentials(email: String, phone: String): LiveData<String> {
     val loginErrorMessage=MutableLiveData<String>()
        if(!textinputvalidation.isValidEmail(email)){
            loginErrorMessage.value="email address is not valid"
        }
        if (!textinputvalidation.isValidMobile(phone)){
            loginErrorMessage.value=" Must be a valid Phone number"
        }
        return loginErrorMessage
    }
}