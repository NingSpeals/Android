package com.example.selectedfood;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.selectedfood.model.Food;
import com.example.selectedfood.model.Person;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView selectedFoodTextView;
    TextView nameTextView ;
    EditText editText;
    RadioGroup radioGroup;
    RadioButton maleBtn;
    RadioButton femaleBtn;
    TextView hobbyTextView;
    CheckBox hotBox;
    CheckBox seafoodBox;
    CheckBox sourBox;
    TextView budgetTextView;
    TextView minPriceTextView;
    SeekBar seekBar;
    TextView maxPriceTextView;
    Button btn;
    ImageView imageView;
    ToggleButton toggleButton;
    List<Food> foods;
    Person person;
    List<Food> foodResult;
    boolean isSeaFood;
    boolean isHot;
    boolean isSour;
    int price;
    int currentIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化控件
        findViews();
        // 初始化数据
        initData();
        // 为控件添加监听器，实现基本功能
        setListeners();
        // 自测
    }

    private void setListeners() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (person !=null){
                    person.setName(editable.toString());
                }
            }
        });
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

        hotBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isHot = b;

            }
        });
        seafoodBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isSeaFood = b;
            }
        });
        sourBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isSour = b;
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
               price = seekBar.getProgress();
               Toast.makeText(MainActivity.this,"价格"+price,Toast.LENGTH_SHORT).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchFood();
            }


        });
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked()){
                    currentIndex++;
                    if (currentIndex < foodResult.size()){
                        imageView.setImageResource(foodResult.get(currentIndex).getPicID());
                    }
                }else {
                    if (currentIndex < foodResult.size()){
                        String name = person.getName();
                        String sex = person.getSex();
                        String foodName = foodResult.get(currentIndex).getName();
                        Toast.makeText(MainActivity.this,"菜名："+foodName+"，姓名："+name+"，姓别："+sex,Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(MainActivity.this,"没有啦",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void initData() {
        foods = new ArrayList<>();
        foods.add(new Food("麻辣香锅",55, R.drawable.malaxiangguo, true, false, false));
        foods.add(new Food("水煮鱼", 48, R.drawable.shuizhuyu, true, true, false));
        foods.add(new Food("麻辣火锅", 80, R.drawable.malahuoguo, true, true, false));
        foods.add(new Food("清蒸鲈鱼", 68, R.drawable.qingzhengluyu, false, true, false));
        foods.add(new Food("桂林米粉", 15, R.drawable.guilin, false, false, false));
        foods.add(new Food("上汤娃娃菜", 28, R.drawable.wawacai, false, false, false));
        foods.add(new Food("红烧肉", 60, R.drawable.hongshaorou, false, false, false));
        foods.add(new Food("木须肉", 40, R.drawable.muxurou, false, false, false));
        foods.add(new Food("酸菜牛肉面", 35, R.drawable.suncainiuroumian, false, false, true));
        foods.add(new Food("西芹炒百合", 38, R.drawable.xiqin, false, false, false));
        foods.add(new Food("酸辣汤", 40, R.drawable.suanlatang, true, false, true));
        person = new Person();
        foodResult = new ArrayList<>();
    }

    private void findViews() {
        selectedFoodTextView = findViewById(R.id.selected_food);
        nameTextView = findViewById(R.id.name_text);
        editText = findViewById(R.id.edit_text);
        maleBtn = findViewById(R.id.male_btn);
        femaleBtn = findViewById(R.id.female_btn);
        radioGroup = findViewById(R.id.radio_group);
        hobbyTextView = findViewById(R.id.hobby_text);
        hotBox = findViewById(R.id.hot_box);
        seafoodBox = findViewById(R.id.seafood_box);
        sourBox = findViewById(R.id.sour_box);
        budgetTextView = findViewById(R.id.budget_text);
        minPriceTextView = findViewById(R.id.minPrice_text);
        seekBar = findViewById(R.id.seek_bar);
        seekBar.setProgress(30);
        maxPriceTextView = findViewById(R.id.maxPrice_text);
        btn = findViewById(R.id.btn);
        imageView = findViewById(R.id.image_view);
        toggleButton = findViewById(R.id.toggle_btn);
        toggleButton.setChecked(true);
    }
    //查找菜品
    private void searchFood() {
        //当前显示的是结果中的第几个菜
        currentIndex = 0;
        // 1.结果列表每次都要清空
        foodResult.clear();
        // 2.判断列表是否为空，如果为空，先初始化
        if (foodResult == null){
            foodResult = new ArrayList<>();
        }
        // 3.遍历所有的菜品
        for (int index = 0; index < foods.size(); index++){
            Food food = foods.get(index);
            if (food != null){
                // 价格小于设定的价格，是顾客选择的口味
                if (food.getPrice()>price && (food.isHot() == isHot || food.isSeaFood() == isSeaFood || food.isSour() == isSour)){
                    foodResult.add(food);
                }
            }
        }
        if (currentIndex <foodResult.size()){
            imageView.setImageResource(foodResult.get(currentIndex).getPicID());
        }
    }
}