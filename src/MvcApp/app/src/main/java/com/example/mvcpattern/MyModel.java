package com.example.mvcpattern;


// Acts as our DB or Network (Cloud storage)
public class MyModel {
    String appName;
    int appDownloads;
    int appRating;

    public MyModel(String appName, int appDownloads, int appRating) {
        this.appName = appName;
        this.appDownloads = appDownloads;
        this.appRating = appRating;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppDownloads(int appDownloads) {
        this.appDownloads = appDownloads;
    }

    public int getAppDownloads() {
        return appDownloads;
    }

    public void setAppRating(int appRating) {
        this.appRating = appRating;
    }

    public int getAppRating() {
        return appRating;
    }
}
