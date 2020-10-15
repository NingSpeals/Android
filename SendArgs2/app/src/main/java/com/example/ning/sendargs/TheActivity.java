package com.example.ning.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TheActivity extends AppCompatActivity {

    private  TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the);
        text = findViewById(R.id.tv);
        Intent i = getIntent();
//        text.setText(i.getStringExtra("data"));
//        Bundle b = i.getExtras();
        Bundle b = i.getBundleExtra("data");

        String str = String.format("%s,%d",b.getString("name"),b.getInt("age"));
        text.setText(str);
    }
}
