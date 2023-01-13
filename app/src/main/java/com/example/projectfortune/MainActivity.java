package com.example.projectfortune;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    OtherFortune ot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button today = (Button) findViewById(R.id.today);
        Button EL = (Button) findViewById(R.id.EL_button);
        Button star = (Button) findViewById(R.id.Star_button);
        ot = new OtherFortune();


        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = check_El();
                if(num == 100){
                    Toast.makeText(getApplicationContext(), "생년월일을 입력해 주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    int[] rand = new int[4];
                    for (int i = 0; i < 4; i++) {
                        rand[i] = Random_num();
                    }
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("total", rand[0]);
                    intent.putExtra("love", rand[1]);
                    intent.putExtra("money", rand[2]);
                    intent.putExtra("study", rand[3]);
                    startActivity(intent);
                }
            }
        });

        EL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int num = check_El();
                    if(num == 100){
                        Toast.makeText(getApplicationContext(), "생년월일을 입력해 주세요", Toast.LENGTH_SHORT).show();
                    }
                    else {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(ot.getEl_name(num));
                switch(num){
                    case 0: builder.setIcon(R.drawable.mouse);break;
                    case 1: builder.setIcon(R.drawable.cow);break;
                    case 2: builder.setIcon(R.drawable.tiger);break;
                    case 3: builder.setIcon(R.drawable.rabbit);break;
                    case 4: builder.setIcon(R.drawable.dragon);break;
                    case 5: builder.setIcon(R.drawable.snake);break;
                    case 6: builder.setIcon(R.drawable.horse);break;
                    case 7: builder.setIcon(R.drawable.sheep);break;
                    case 8: builder.setIcon(R.drawable.monkey);break;
                    case 9: builder.setIcon(R.drawable.chicken);break;
                    case 10: builder.setIcon(R.drawable.dog);break;
                    case 11: builder.setIcon(R.drawable.pig);break;
                }
                builder.setMessage(ot.getEl(num));
                builder.setPositiveButton("확인",null);
                builder.show();
                }
            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = check_Star();
                if(num == 100){
                    Toast.makeText(getApplicationContext(), "생년월일을 입력해 주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(ot.getStar_name(num));
                switch(num){
                    case 0: builder.setIcon(R.drawable.star1);break;
                    case 1: builder.setIcon(R.drawable.star2);break;
                    case 2: builder.setIcon(R.drawable.star3);break;
                    case 3: builder.setIcon(R.drawable.star4);break;
                    case 4: builder.setIcon(R.drawable.star5);break;
                    case 5: builder.setIcon(R.drawable.star6);break;
                    case 6: builder.setIcon(R.drawable.star7);break;
                    case 7: builder.setIcon(R.drawable.star8);break;
                    case 8: builder.setIcon(R.drawable.star9);break;
                    case 9: builder.setIcon(R.drawable.star10);break;
                    case 10: builder.setIcon(R.drawable.star11);break;
                    case 11: builder.setIcon(R.drawable.star12);break;
                }
                builder.setMessage(ot.getStar(num));
                builder.setPositiveButton("확인",null);
                builder.show();
                }
            }
        });
    }

    public int Random_num(){
        Random rand = new Random();
        int num = rand.nextInt(4);
        return num;
    }

    public int check_El(){
        TextView date = (TextView) findViewById(R.id.birth_date);
        String tmp = date.getText().toString();
        if(tmp.equals("")){
            return 100;
        }
        int year = Integer.parseInt(tmp.substring(2,4));
        int num = year % 12;
        switch (num){
            case 0: return 0;
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            case 4: return 4;
            case 5: return 5;
            case 6: return 6;
            case 7: return 7;
            case 8: return 8;
            case 9: return 9;
            case 10: return 10;
            case 11: return 11;
        }
        return -1;
    }

    public int check_Star() {
        TextView date = (TextView) findViewById(R.id.birth_date);
            String tmp = date.getText().toString();
        if(tmp.equals("")){
            return 100;
        }
            int month = Integer.parseInt(tmp.substring(4, 6));
            int day = Integer.parseInt(tmp.substring(6));
            if ((month == 1 && 20 <= day && day <= 31) || (month == 2 && 1 <= day && day <= 18)) {
                return 0;
            } else if ((month == 2 && 19 <= day && day <= 29) || (month == 3 && 1 <= day && day <= 20)) {
                return 1;
            } else if ((month == 3 && 21 <= day && day <= 31) || (month == 4 && 1 <= day && day <= 19)) {
                return 2;
            } else if ((month == 4 && 20 <= day && day <= 30) || (month == 5 && 1 <= day && day <= 20)) {
                return 3;
            } else if ((month == 5 && 21 <= day && day <= 31) || (month == 6 && 1 <= day && day <= 21)) {
                return 4;
            } else if ((month == 6 && 22 <= day && day <= 30) || (month == 7 && 1 <= day && day <= 22)) {
                return 5;
            } else if ((month == 7 && 23 <= day && day <= 31) || (month == 8 && 1 <= day && day <= 22)) {
                return 6;
            } else if ((month == 8 && 23 <= day && day <= 31) || (month == 9 && 1 <= day && day <= 23)) {
                return 7;
            } else if ((month == 9 && 24 <= day && day <= 30) || (month == 10 && 1 <= day && day <= 22)) {
                return 8;
            } else if ((month == 10 && 23 <= day && day <= 31) || (month == 11 && 1 <= day && day <= 22)) {
                return 9;
            } else if ((month == 11 && 23 <= day && day <= 30) || (month == 12 && 1 <= day && day <= 24)) {
                return 10;
            } else if ((month == 12 && 25 <= day && day <= 31) || (month == 1 && 1 <= day && day <= 19)) {
                return 11;
            } else
                return -1;
        }
   /* }*/
}