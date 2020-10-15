package com.example.ning.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TheActivity.class);
                /***简单数据传递
                 * i.putExtra("data","我想学好安卓");
                 */
                /**
                 * 传递数据包
                 */
                Bundle b = new Bundle();
                b.putString("name","Android");
                b.putInt("age",3);
//                i.putExtras(b);
                i.putExtra("data",b);
                startActivity(i);
            }
        });
    }
}
