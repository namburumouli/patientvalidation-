package com.example.patientvalidation.Model


import androidx.databinding.BaseObservable

import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class User() :BaseObservable() {


    var name: String? = null
        @Bindable get() = field
        set(name) {
            field = name
            notifyPropertyChanged(BR.name)
        }
    var email: String? = null
        @Bindable get() = field
        set(email) {
            field = email
            notifyPropertyChanged(BR.email)
        }

    var phone: String? = null
        @Bindable get() = field
        set(phone) {
            field = phone
            notifyPropertyChanged(BR.phone)
        }
}



