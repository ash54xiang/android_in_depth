package com.example.mvvmpattern.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmpattern.util.MyModel;

public class AppViewModel extends ViewModel {

    // 4. LiveData
    public MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    // 3. Connecting ViewModel with DB - (Model)
    private MyModel getAppFromDatabase() {
        // LiveData vs MutableLiveData

        return new MyModel("Master Coding App", 900000, 4);
    }

    // 5. Connecting ViewModel with MainActivity (View)
    public void getAppName() {
        String appName = getAppFromDatabase().getAppName();
        mutableLiveData.setValue(appName);
    }
    public void getAppDownloads() {
        int appDownloads = getAppFromDatabase().getAppDownloads();
        mutableLiveData.setValue(String.valueOf(appDownloads));
    }
    public void getAppRating() {
        int appRating = getAppFromDatabase().getAppRating();
        mutableLiveData.setValue(String.valueOf(appRating));
    }
}
