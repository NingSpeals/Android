package com.example.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Button btn1 = (Button)findViewById(R.id.btn1);
        MyClickListener mcl = new  MyClickListener();
        btn1.setOnClickListener(mcl);
        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG","=====匿名内部类=====");
            }
        });
        Button btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.e("TAG","用本类实现了OnClickListener");
    }

    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //
            Log.e("tag","刚刚点击的按钮时注册了内部类监听对象的按钮");
        }
    }

    public void myClick(View v){
        switch (v.getId()){
            case R.id.btn4:
                Log.e("TAG","实现了XML绑定3545事件");
                break;
            case R.id.btn5:
                Log.e("TAG","实现了XML绑定事件");
                break;
        }

    }

}