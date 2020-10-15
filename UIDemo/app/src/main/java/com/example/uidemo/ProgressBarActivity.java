package com.example.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import java.io.InterruptedIOException;

public class ProgressBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        Log.e("你好", "世界");
        final ProgressBar progressBar = findViewById(R.id.progress);
        progressBar.setProgress(80);
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++){
                    progressBar.setProgress(i);
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}