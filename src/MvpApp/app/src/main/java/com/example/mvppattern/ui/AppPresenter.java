package com.example.mvppattern.ui;


import com.example.mvppattern.util.MyModel;

// This will act as Presenter
public class AppPresenter {
    // 1. The link between presenter and the view (MainActivity) is done by Interface
    // Link instance
    AppView appView;

    public AppPresenter(AppView appView) {
        this.appView = appView;
    }

    // 2. Linkage between presenter and model
    public MyModel GetAppFromModel() {
        return new MyModel("Master Coding App", 900000, 4);
    }

    // 3. Linkage between presenter and MainActivity (Calling the interface)
    public void getAppName() {
        appView.onGetAppName(GetAppFromModel().getAppName());
    }

    public void getAppDownloads() {
        appView.onGetAppDownload(GetAppFromModel().getAppDownloads());
    }
}
