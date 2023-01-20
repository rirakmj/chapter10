package com.cookandroid.chapter10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btn1 = findViewById(R.id.btn1);

        Intent intent2 = getIntent(); // 받아오기
        // String str1 = intent1.getStringExtra("firstName"); // 값 꺼내서 받기

        Toast.makeText(getApplicationContext(), "이름은" +intent2.getStringExtra("firstname")+ "입니다.", Toast.LENGTH_SHORT).show();

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
}