package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

 public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 将activity 与 layout进行关联
        setContentView(R.layout.activity_test);
        TextView textView = findViewById(R.id.textView);
        textView.setText(getString(R.string.app_name));
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this,NewActivity.class);
                startActivity(intent);
            }
        });
    }
}
