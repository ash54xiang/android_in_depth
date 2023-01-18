
package com.example.mvppattern.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvppattern.R;
import com.example.mvppattern.util.MyModel;

public class MainActivity extends AppCompatActivity implements AppView {
    // View: MainActivity with the TextView & Button
    // Model: MyModel Class
    // Presenter: AppPresenter

    Button btn;
    TextView textView;
    // Link MainActivity with presenter
    AppPresenter appPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayAppInModel();
            }
        });

        appPresenter = new AppPresenter(this);
    }

    public void DisplayAppInModel() {
        // Calling presenter to get data from DB
        // No linkage between Activity and Model anymore
        // MainActivity is mainly handling UI only!!
        // All logics occur at the presenter
        appPresenter.getAppName();
//        appPresenter.getAppDownloads();
    }

    @Override
    public void onGetAppName(String appName) {
        textView.setText(appName);
    }

    @Override
    public void onGetAppDownload(int appDownload) {
        textView.setText(String.valueOf(appDownload));
    }


}