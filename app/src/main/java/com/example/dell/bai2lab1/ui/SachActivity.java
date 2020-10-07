package com.example.dell.bai2lab1.ui;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.dell.bai2lab1.R;

import com.example.dell.bai2lab1.adapter.SachAdapter;
import com.example.dell.bai2lab1.dao.SachDao;
import com.example.dell.bai2lab1.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachActivity extends AppCompatActivity {
    public  static  List<Sach> dsSach = new ArrayList<>();
    ListView lvBooks;
    SachAdapter adapter= null;
    SachDao sachDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
    setTitle("Quản Lý Sách");
    lvBooks=(ListView)findViewById(R.id.customlvsach);
    sachDao= new SachDao(SachActivity.this);


    dsSach = sachDao.getAllSach();

    adapter = new SachAdapter(dsSach,this);
    lvBooks.setAdapter(adapter);

    lvBooks.setTextFilterEnabled(true);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menusach, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemaddsach:
                Intent a = new Intent(SachActivity.this,ThemSachActivity.class);
                startActivity(a);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
