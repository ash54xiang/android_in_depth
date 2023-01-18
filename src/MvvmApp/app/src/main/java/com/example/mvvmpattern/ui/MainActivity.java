
package com.example.mvvmpattern.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvmpattern.R;
import com.example.mvvmpattern.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // We need to make the connection "Binding" - "ViewModel"
    // 1. Implementing the dependency of ViewModel
    // 2. Creating ViewModel Class


    // View: MainActivity with the TextView & Button
    // Model: MyModel Class
    // ViewModel: Binding

//    Button btn;
//    TextView textView;

    // 6. Connecting MainActivity with ViewModel and Listening to LiveData
    AppViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        textView = findViewById(R.id.textView); // findViewById has no null safety
//        btn = findViewById(R.id.button);
//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                appViewModel.getAppName();
//            }
//        });

        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);

//        // 7. Listening & observing the changes to the LiveData
//        appViewModel.mutableLiveData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                // Any changes in the liveData, we do this:
//                binding.textView.setText(s);
//            }
//        });
        // another 7. View binding with TextView will do the job of observing
        binding.setViewModel(appViewModel);
        binding.setLifecycleOwner(this);
    }
}