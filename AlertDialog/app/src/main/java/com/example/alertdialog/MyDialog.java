package com.example.alertdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

//1.自定义对话框样式dialog_layout.xml
//2.设计style（去标题，去背景）
//3.将第一步的布局应用到当前自定义对话框
//4.实例化对话框（参数1：环境上下文，参数2：第二步创建的style，R.style.myDialog），并展示
public class MyDialog extends Dialog {
    public MyDialog(@NonNull Context context, int themeResID) {
        super(context, themeResID);
        //为对话框设置布局
        setContentView(R.layout.dialog_layout);
        findViewById(R.id.yes_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
        findViewById(R.id.no_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
