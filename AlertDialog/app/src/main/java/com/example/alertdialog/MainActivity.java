package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showNormalDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("提示");
        alertDialog.setMessage("您确定退出程序吗？");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
    public void myOnclick(View view){
        switch (view.getId()){
            case R.id.normal_dialog_btn:
                //1.实例化一个Builder
               // AlertDialog的构造方法是protected
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //2.设置对话框样式
                builder.setTitle("提示"); //标题
                builder.setMessage("您确定退出程序吗"); //提示语句
                //设置按钮
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("取消",null);
                // 3.展示
                builder.show();
//                AlertDialog dialog = builder.create();
//                dialog.show();
                break;
            case R.id.div_dialog_btn:
                MyDialog myDialog = new MyDialog(this, R.style.myDialog);
                myDialog.show();
                break;
            case R.id.popup_btn:
                popupWindow(view);
                break;
        }
    }

    //设置 popupWindow
    private void popupWindow(View v) {
        //准备弹框所需要的视图对象
        View view = LayoutInflater.from(this).inflate(R.layout.popup_layout,null);
        //1.实例化对象
        //参数1：用在弹框中的view；参数2，3：弹窗的宽高；参数4：（focusable）
        final PopupWindow popupWindow = new PopupWindow(view,310,100,true);

        //2.设置(背景，动画)
        //设置背景
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置能响应外部的点击事件
        popupWindow.setOutsideTouchable(true);
        //设置能相应的点击事件
        popupWindow.setTouchable(true);
        //1.创建动画资源 2.创建style应用动画资源 3.对当前弹窗的动画风格设置为第二步的资源索引
        popupWindow.setAnimationStyle(R.style.translate_anim);
        //3.显示
        //参数1：(anchor)锚；参数2，3：相对于锚在x，y方向上的偏移量；
        popupWindow.showAsDropDown(v,-190,0);
        //为弹框中的文本添加点击事件
        view.findViewById(R.id.choose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"您点击了选择",Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
        view.findViewById(R.id.choose_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"您点击了全选",Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
        view.findViewById(R.id.copy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"您点击了复制",Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
    }

}