package com.cookandroid.ex10_02_artvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9]; // 투표수 저장 배열 선언
        for(int i=0; i<9; i++) // 9 대신 voteCount.length 가능
            voteCount[i] = 0;

        ImageView image[] = new ImageView[9]; // 이미지뷰 위젯 저장 배열 선언
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9}; // 이미지뷰 위젯 아이디 저장 배열
        final String imageName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "아레느깡 단 베르앙", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨",
                "피아노 앞의 소녀들", "해변에서"}; // 그림 이름 저장 배열 선언

        // 각 이미지뷰에 대한 클릭 리스너 생성
        for(int i=0; i<imageId.length; i++){
            final int index; // 꼭 필요함!
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    voteCount[index]++; // 이미지 클릭하면 각 이미지의 투표수 증가
                    Toast.makeText(getApplicationContext(), imageName[index] + ": 총 " + voteCount[index] + " 표",
                            Toast.LENGTH_SHORT).show(); // 각 이미지 이름과 투표수를 토스트 메세지로 출력
                }
            });
        }

        // 투표 종료 이벤트
        Button btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imageName);
                startActivity(intent);
            }
    });
    }
}
