package com.example.mvppattern.ui;

public interface AppView {

    // This is the linkage between presenter and the view
    void onGetAppName(String appName);

    void onGetAppDownload(int appDownload);
}
