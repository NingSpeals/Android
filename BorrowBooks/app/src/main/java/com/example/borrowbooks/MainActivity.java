package com.example.borrowbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {

    private TextView readerText;
    private EditText editText;
    private TextView sexText;
    private RadioGroup radioGroup;
    private TextView borrowTimeText;
    private EditText timeEditText;
    private TextView returnTimeText;
    private TextView returnTimeText1;
    private TextView hobbyText;
    private CheckBox checkBoxHistory;
    private CheckBox checkBoxMystery;
    private CheckBox checkBoxLiterary;
    private TextView ageText;
    private TextView minAgeText;
    private SeekBar seekBar;
    private TextView maxAgeText;
    private ImageView imageView;
    private TextView bookNameText;
    private TextView bookTypeText;
    private TextView useAgeText;
    private TextView countText;
    private Button searchBtn;
    private Button nextBtn;
    private List<Book> books;
    private List<Book> bookResult;
    private Person person;
    private boolean isHistory;
    private boolean isMystery;
    private boolean isLiterary;
    private int age;
    private int currentIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化控件
        findViews();
        // 初始化数据
        initData();
        // 添加事件处理操作,实现基本操作
        addListener();
        // 
    }
    private void findViews() {
        readerText = findViewById(R.id.reader_text);
        editText = findViewById(R.id.editText);
        sexText = findViewById(R.id.sex_text);
        radioGroup = findViewById(R.id.radioGroup);
        borrowTimeText = findViewById(R.id.borrowTime_text);
        timeEditText = findViewById(R.id.time_editText);
        returnTimeText = findViewById(R.id.returnTime_text);
        returnTimeText1 = findViewById(R.id.returnTime_text1);
        hobbyText = findViewById(R.id.hobby_text);
        checkBoxHistory = findViewById(R.id.checkBox_history);
        checkBoxMystery = findViewById(R.id.checkBox_mystery);
        checkBoxLiterary = findViewById(R.id.checkBox_literary);
        ageText = findViewById(R.id.age_text);
        minAgeText = findViewById(R.id.minAge_text);
        seekBar = findViewById(R.id.seekBar);
        maxAgeText = findViewById(R.id.maxAge_text);
        imageView = findViewById(R.id.imageView);
        bookNameText = findViewById(R.id.bookName_text);
        bookTypeText = findViewById(R.id.bookType_text);
        useAgeText = findViewById(R.id.useAge_text);
        searchBtn = findViewById(R.id.search_btn);
        nextBtn = findViewById(R.id.next_btn);
        countText = findViewById(R.id.count_text);
    }

    private void initData() {
        books = new ArrayList<>();
        books.add(new Book("人生感悟","心灵鸡汤", 18, R.drawable.aa, false, false, true,"2016.09.09"));
        books.add(new Book("边城","小说", 12, R.drawable.bb, false, false, true,"2016.09.09"));
        books.add(new Book("Sapir","计算机", 20, R.drawable.cc, false, false, false,"2016.09.09"));
        books.add(new Book("光辉岁月","小说", 28, R.drawable.dd, false, false, true,"2016.09.09"));
        books.add(new Book("宋词三百首","诗文", 30, R.drawable.ee, false, false, true,"2016.09.09"));
        books.add(new Book("荷花","画本", 38, R.drawable.f, false, false, true,"2016.09.09"));
        books.add(new Book("中国古代文学","文学", 40, R.drawable.ff, false, false, true,"2016.09.09"));
        books.add(new Book("无花果","小说", 52, R.drawable.gg, false, false, true,"2016.09.09"));
        books.add(new Book("古镇记忆","旅游", 61, R.drawable.hh, false, false, false,"2016.09.09"));
        person = new Person();
        bookResult = new ArrayList<>();
    }

    private void addListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.male_btn:
                        person.setSex("男");
                        break;
                    case R.id.female_btn:
                        person.setSex("女");
                        break;
                }
            }
        });
        checkBoxHistory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isHistory = b;
            }
        });
        checkBoxMystery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isMystery = b;
            }
        });
        checkBoxLiterary.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isLiterary = b;
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                age = seekBar.getProgress();
                minAgeText.setText(String.valueOf(seekBar.getProgress()));
            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String beginTime = new String(timeEditText.getText().toString());
                String endTime = new String(returnTimeText1.getText().toString());
                // 直接用Date自带方法before()和after()比较
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date endDate=df.parse(endTime);
                    Date beginDate = df.parse(beginTime);
                    System.out.println("++++++"+endDate.after(beginDate));
                    if (endDate.before(beginDate)){
                        finish();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                // 记录当前显示的第几本书
                currentIndex = 0;
                // 结果列表每次都要清空
                bookResult.clear();
                // 判断列表是否为空,为空的话，每次都要初始化
                if (bookResult == null){
                    bookResult = new ArrayList<>();
                }
                for (int index = 0; index<books.size(); index++){
                    Book book = books.get(index);
                    if (book != null){
                        if (book.getAge() > age
                                && (book.isHistory() == isHistory
                                || book.isLiterary() == isLiterary
                                || book.isMystery() == isMystery)){
                            bookResult.add(book);
                        }
                    }
                }
                if (currentIndex < bookResult.size()){
                    imageView.setImageResource(bookResult.get(currentIndex).getPicID());
                    countText.setText("符合条件的书有"+bookResult.size() +"本");
                    bookNameText.setText(bookResult.get(currentIndex).getName());
                    bookTypeText.setText(bookResult.get(currentIndex).getType());
                    useAgeText.setText("" + bookResult.get(currentIndex).getAge());
                    Toast.makeText(MainActivity.this,"显示个人信息：姓名："
                            +editText.getText().toString()+"，性别："
                            +person.getSex()+"，年龄："+age+"，借书时间："
                            +timeEditText.getText().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex++;
                if (currentIndex < bookResult.size()){
                    imageView.setImageResource(bookResult.get(currentIndex).getPicID());
                    bookNameText.setText(bookResult.get(currentIndex).getName());
                    bookTypeText.setText(bookResult.get(currentIndex).getType());
                    useAgeText.setText("" + bookResult.get(currentIndex).getAge());
                    Toast.makeText(MainActivity.this,"显示个人信息：姓名："+editText.getText().toString()+"，性别："+person.getSex()+"，年龄："+age+"，借书时间："+timeEditText.getText().toString(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"没有符合的书籍",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}