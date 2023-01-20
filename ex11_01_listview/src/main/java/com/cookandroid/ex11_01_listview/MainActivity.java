package com.cookandroid.ex11_01_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");

        // 동적 추가 및 삭제
        final ArrayList<String> midList = new ArrayList<String>();

        // 기본 리스트뷰
//        final String[] mid = { "히어로즈", "24시", "로스트", "로스트룸", "빅뱅이론", "프렌즈", "스몰빌", "탐정몽크", "덱스터", "글리"
//        , "가쉽걸", "테이큰", "슈퍼내츄럴", "브이" };

        ListView list = (ListView) findViewById(R.id.listView1);

        // 동적 추가 및 삭제
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, midList);
        // 심플 리스트 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mid);
        // 싱글체크 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, mid);
        // list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // 멀티플체크 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, mid);
        // list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);

        final EditText et1 = (EditText) findViewById(R.id.et1);
        Button btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                midList.add(et1.getText().toString());
                adapter.notifyDataSetChanged(); // 갱신
            }
        });
        // 기본 리스트뷰
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), mid[position], Toast.LENGTH_SHORT).show();
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                midList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}