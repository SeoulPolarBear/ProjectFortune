package com.example.projectfortune;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {
    TodayFortune tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        ImageButton total = findViewById(R.id.total);
        ImageButton love = findViewById(R.id.love);
        ImageButton money = findViewById(R.id.money);
        ImageButton study = findViewById(R.id.study);
        int totaln = intent.getIntExtra("total",0);
        int loven = intent.getIntExtra("love",0);
        int moneyn = intent.getIntExtra("money",0);
        int studyn = intent.getIntExtra("study",0);
        tf = new TodayFortune();
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setTitle(tf.getname(0));
                builder.setMessage(tf.getTodayFortune(1,totaln));
                builder.setPositiveButton("확인",null);
                builder.show();
            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setTitle(tf.getname(1));
                builder.setMessage(tf.getTodayFortune(2,loven));
                builder.setPositiveButton("확인",null);
                builder.show();
            }
        });
        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setTitle(tf.getname(2));
                builder.setMessage(tf.getTodayFortune(3,moneyn));
                builder.setPositiveButton("확인",null);
                builder.show();
            }
        });
        study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setTitle(tf.getname(3));
                builder.setMessage(tf.getTodayFortune(4,studyn));
                builder.setPositiveButton("확인",null);
                builder.show();
            }
        });

    }
}