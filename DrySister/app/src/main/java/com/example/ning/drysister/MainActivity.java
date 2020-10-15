package com.example.ning.drysister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("A onCreate");
        findViewById(R.id.btnStartBAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BatActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("A onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("A onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("A onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("A onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("A onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("A onRestart");
    }
}

