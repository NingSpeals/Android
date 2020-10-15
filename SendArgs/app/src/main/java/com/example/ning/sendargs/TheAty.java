package com.example.ning.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TheAty extends AppCompatActivity {
private TextView tv;
private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_aty);
        final Intent i = getIntent();
        tv = findViewById(R.id.tv);
        editText = findViewById(R.id.edit_text);
//        Bundle data = i.getExtras();
//        Bundle data = i.getBundleExtra("data");
//        /// 接收传递的简单数据
////        tv.setText(i.getStringExtra("data"));
//        /// 接收传递的数据包
//        tv.setText(String.format("name = %s, age = %d, name = %s", data.getString("name"),data.getInt("age"),data.getString("name1","ningspeals")));
//      User user = (User) i.getSerializableExtra("user");
      User user = i.getParcelableExtra("user");
      tv.setText(String.format("User info(name = %s, age = %d)",user.getName(),user.getAge()));

      findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent i = new  Intent();
              i.putExtra("data",editText.getText().toString());
              setResult(1,i);
              finish();
          }
      });

    }
}
