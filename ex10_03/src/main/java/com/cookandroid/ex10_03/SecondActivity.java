package com.cookandroid.ex10_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("계산하기");

        Log.i("여기", "33333");

        Intent intent1 = getIntent();

        int num1 = intent1.getIntExtra("Num1", 0);
        int num2 = intent1.getIntExtra("Num2", 0);
        String op1 = intent1.getStringExtra("Operator1");

        // switch문은 integer만 사용 가능
        if(op1.equals("+")) {
            int nResult = num1 + num2;
        }
        else if(op1.equals("-")) {
            int nResult = num1 + num2;
        }
        else if(op1.equals("*")) {
            int nResult = num1 + num2;
        }
        else if(op1.equals("/")) {
            int nResult = num1 + num2;
        }
        else{

        }

        Button btn1 = findViewById(R.id.btnReturn);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Log.i("여기", "44444");
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                intent1.putExtra("Result", finalNResult);
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }
}