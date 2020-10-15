package com.example.basiccontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox checkBox = findViewById(R.id.checkBox);
        // 设置是否选中（设置它的状态）
        checkBox.setChecked(false);
        // 获取它的状态，是否选中
        boolean isChecked = checkBox.isChecked();

        Log.e("TAG","onCreate, isChecked:" + isChecked);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.e("TAG","onCreate, isChecked:" + b);
            }
        });
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);
        seekBar.setProgress(40);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.e("TAG","onProgressChanged:" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("TAG","onStartTrackingTouch:" + seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("TAG","onStopTrackingTouch:" + seekBar.getProgress());
            }
        });
    }
}