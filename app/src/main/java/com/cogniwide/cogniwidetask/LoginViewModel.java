package com.cogniwide.cogniwidetask;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    MutableLiveData<LoginModel> mLoginModelMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<LoginModel> getLoginData() {
        return mLoginModelMutableLiveData;
    }

    public void onClick(View v) {
    LoginModel model = new LoginModel(EmailAddress.getValue(), Password.getValue());
    mLoginModelMutableLiveData.setValue(model);
    }

    public MutableLiveData<String> getEmailAddress() {
        return EmailAddress;
    }

    public MutableLiveData<String> getPassword() {
        return Password;
    }

}
