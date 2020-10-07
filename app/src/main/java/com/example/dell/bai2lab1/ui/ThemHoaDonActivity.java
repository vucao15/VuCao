package com.example.dell.bai2lab1.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dell.bai2lab1.R;

import java.util.Calendar;

public class ThemHoaDonActivity extends AppCompatActivity {

    private EditText edMaHoaDonHoaDon;
    private TextView tvChonNgay;
    private Button btnChonNgay;
    private Button btnThemThemHoaDon;
    private Button btnHuyThemHoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        initView();

        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
    }

    public void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // thiet lap thong tin cho date picker

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Integer n = year;
                Integer t = month;
                Integer d = dayOfMonth;
                tvChonNgay.setText(d.toString() + "-" + t.toString() + "-" + n.toString());
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    private void initView() {
        edMaHoaDonHoaDon = (EditText) findViewById(R.id.edMaHoaDon_HoaDon);
        tvChonNgay = (TextView) findViewById(R.id.tvChonNgay);
        btnChonNgay = (Button) findViewById(R.id.btnChonNgay);
        btnThemThemHoaDon = (Button) findViewById(R.id.btnThem_ThemHoaDon);
        btnHuyThemHoaDon = (Button) findViewById(R.id.btnHuy_ThemHoaDon);
    }
}
