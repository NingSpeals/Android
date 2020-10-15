package com.example.ning.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TheAty.class);
                ///传递简单的数据
                //                i.putExtra("data", "Hello NingSpeals");
                ///传递数据包Bundle
//                Bundle b = new Bundle();
//                b.putString("name","jikexueyuan");
//                b.putInt("age",2);
//                b.putString("name1","wsn");
////                i.putExtras(b);
//                i.putExtra("data",b);

                /// 传递值对象
                i.putExtra("user", new User("jikexueyuan",3));
//                startActivity(i);
                startActivityForResult(i,0);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView.setText("另一个Activity返回的数据是："+data.getStringExtra("data"));

    }
}
