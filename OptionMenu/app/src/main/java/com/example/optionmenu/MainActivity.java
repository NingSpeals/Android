package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ctx_btn:演示contextMenu
        // 1.注册
//        registerForContextMenu( findViewById(R.id.ctx_btn));
        // 2.创建 覆盖onCreateContextMenu
        // 3.菜单项的操作 覆盖onContextItemSelected
        // 4.为按钮设置上下文操作模式(1.实现ActionMode Callback 2.在view的长按事件中去启动上下文操作模式)
        findViewById(R.id.ctx_btn).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                startActionMode(cb);
                return false;
            }
        });
        //popup_btn：演示PopupMenu
        findViewById(R.id.popup_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = findViewById(R.id.popup_btn);
                //1.实例化popupMenu对象
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,button);
                //2.加载菜单资源，利用MenuInflater将PopupMenu.getMenu()所返回的Menu对象中
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());
                //3.为PopupMenu设置点击监听器
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.copy:
                                Toast.makeText(MainActivity.this,"复制",Toast.LENGTH_SHORT).show();
                            case R.id.past:
                                Toast.makeText(MainActivity.this,"粘贴",Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                //4.千万不要忘了这一步
                popupMenu.show();

            }
        });
    }
    ActionMode.Callback cb = new ActionMode.Callback() {
        // 创建 在启动上下文模式（startActionMode（Callback））时调用
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            Log.e("TAG","创建");
            getMenuInflater().inflate(R.menu.context,menu);
            return true;
        }
        //创建方法后进行调用
        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            Log.e("TAG","准备");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.delete:
                    Toast.makeText(MainActivity.this,"删除", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.caozuo1:
                    Toast.makeText(MainActivity.this,"操作1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.caozuo2:
                    Toast.makeText(MainActivity.this,"操作2", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
        //上下文操作模式结束时被调用
        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.e("TAG","结束");

        }
    };
/**
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                Toast.makeText(this,"删除", Toast.LENGTH_SHORT).show();
                break;
            case R.id.caozuo1:
                Toast.makeText(this,"操作1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.caozuo2:
                Toast.makeText(this,"操作2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
**/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //通过XML资源来设计menu
//        getMenuInflater().inflate(R.menu.option,menu);
        //纯java代码设计menu
        /*
        设置
        更多
           添加
           删除
        */
        //Menu 参数1：组id 参数2：菜单项id 参数3：序号 参数4：文本（）设置
        menu.add(1,1,1,"设置");
        SubMenu sub = menu.addSubMenu(1,2,2,"更多");
        sub.add(2,3,1,"添加");
        sub.add(2,4,2,"删除");
        //subMenu
        //一定要记得返回true，否则菜单不显示
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
//            case R.id.save:
//                Toast.makeText(this,"保存", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.setting:
//                Toast.makeText(this,"设置", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.exit:
//                finish();
//                break;
            case 1:
                Toast.makeText(this,"设置", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this,"更多", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this,"添加", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this,"删除", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}