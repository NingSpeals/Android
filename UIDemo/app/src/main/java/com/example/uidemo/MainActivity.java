package com.example.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout);
    }
    public void register(View v){
        EditText nameEdt = findViewById(R.id.name);
        EditText paswEdt = findViewById(R.id.password);
        final ProgressBar progressBar = findViewById(R.id.pro_bar);

        String name = nameEdt.getText().toString();
        String pasw = paswEdt.getText().toString();

        if (name.equals("")||pasw.equals("")){
            Toast.makeText(this,"姓名或密码不能为空",Toast.LENGTH_SHORT).show();
        }else {
            progressBar.setVisibility(View.VISIBLE);
            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i<+100;i++){
                        progressBar.setProgress(i);
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }
}