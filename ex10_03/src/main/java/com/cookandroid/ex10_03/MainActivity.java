package com.cookandroid.ex10_03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("여기", "11111 온크리에이트");

        EditText et1 = (EditText) findViewById(R.id.et1);
        EditText et2 = (EditText) findViewById(R.id.et2);
        RadioGroup rGroup1 = (RadioGroup) findViewById(R.id.rGroup1);
        RadioButton btn1 = (RadioButton) findViewById(R.id.btn1);
        RadioButton btn2 = (RadioButton) findViewById(R.id.btn2);
        RadioButton btn3 = (RadioButton) findViewById(R.id.btn3);
        RadioButton btn4 = (RadioButton) findViewById(R.id.btn4);
        Button BtnResult = (Button) findViewById(R.id.btnResult);

        BtnResult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.i("여기", "22222 온클릭메인");
                Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);

                String str1 = et1.getText().toString();
                String str2 = et2.getText().toString();
                int num1 = Integer.parseInt(str1);
                int num2 = Integer.parseInt(str2);
                intent1.putExtra("Num1", num1);
                intent1.putExtra("Num2", num2);

                String operator1 = "";
                switch(rGroup1.getCheckedRadioButtonId())
                {
                    case R.id.btn1:
                        operator1 = "+";
                        break;
                    case R.id.btn2:
                        operator1 = "-";
                        break;
                    case R.id.btn3:
                        operator1 = "*";
                        break;
                    case R.id.btn4:
                        operator1 = "/";
                        break;
                    default:
                        operator1="";
                }

                intent1.putExtra("Operator1", operator1);
                startActivity(intent1);

//                if (btn1.isChecked()) {
//                    Integer strResult = Integer.parseInt(str1) + Integer.parseInt(str2);
//                }
//                if (btn2.isChecked()) {
//                    Integer strResult = Integer.parseInt(str1) - Integer.parseInt(str2);
//                }
//                if (btn3.isChecked()) {
//                    Integer strResult = Integer.parseInt(str1) * Integer.parseInt(str2);
//                }
//                if (btn4.isChecked()) {
//                    Integer strResult = Integer.parseInt(str1) / Integer.parseInt(str2);
//                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("여기", "55555");
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("")
        }
    }
}