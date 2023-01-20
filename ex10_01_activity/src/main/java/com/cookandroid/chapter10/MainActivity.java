package com.cookandroid.chapter10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent1 = new Intent(this, SecondActivity.class);
        Intent intent2 = new Intent(this, ThirdActivity.class);

        RadioGroup rGroup1 = findViewById(R.id.rGroup1);
        RadioButton secondBtn = findViewById(R.id.secondBtn);
        RadioButton thirdBtn = findViewById(R.id.thirdBtn);
        Button btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 선생님 풀이
                Intent intent1 = null;
                switch(rGroup1.getCheckedRadioButtonId())
                {
                    case R.id.secondBtn:
                        intent1 = new Intent(MainActivity.this, SecondActivity.class);
                        break;

                    case R.id.thirdBtn:
                        intent1 = new Intent(MainActivity.this, ThirdActivity.class);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"선택해 주세요", Toast.LENGTH_SHORT).show();
                }
                // 내가 작성
//                if (secondBtn.isChecked()) {
//                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                    intent1.putExtra("firstName", "Hong");
//                    startActivity(intent);
//                } else {
//                    Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
//                    intent2.putExtra("firstName", "Kim");
//                    startActivity(intent);
//                }
            }
        });
    }
}