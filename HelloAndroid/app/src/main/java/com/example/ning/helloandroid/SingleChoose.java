package com.example.ning.helloandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SingleChoose extends AppCompatActivity {

    private Button btnSubmit;
    private RadioButton btnA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_choose);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnSubmit = findViewById(R.id.btnSubmit);
        btnA = findViewById(R.id.btnA);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnA.isChecked()){
                    Toast.makeText(SingleChoose.this,"所选是正确的",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SingleChoose.this,"所选是错误的",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
