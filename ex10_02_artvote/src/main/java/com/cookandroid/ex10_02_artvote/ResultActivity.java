package com.cookandroid.ex10_02_artvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent(); // MainActivity의 Intent 받기
        int[] voteResult = intent.getIntArrayExtra("VoteCount"); // 넘겨 받은 투표수 배열 저장
        String[] imageName = intent.getStringArrayExtra("ImageName"); // 넘겨 받은 그림 이름 배열 저장

        // 최다 득표수의 인덱스를 배열에서 찾기
//        int max = 0;
//        int max_index = 0;
//        for(int i=0; i<voteCount.length; ++i) {
//            if (voteCount[i] > max) {
//                max = voteCount[i];
//                max_index = i;
//            }
//        }
        int max_index = 0;
        for(int i=0; i<9; ++i) {
            if (voteResult[i] > voteResult[max_index]) {
                max_index = i;
            }
        }

        TextView tvMax = findViewById(R.id.tvMax);
        ImageView ivMax = findViewById(R.id.ivMax);

        Integer imageFileId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
        tvMax.setText(imageName[max_index]);
        ivMax.setImageResource(imageFileId[max_index]);

        // 바인딩
        TextView tv[] = new TextView[9];
        RatingBar rb[] = new RatingBar[9];

        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

            for(int i=0; i<voteResult.length; ++i) {
                tv[i] = findViewById(tvID[i]);
                rb[i] = findViewById(rbID[i]);
            }

            for(int i=0; i<imageName.length; ++i){
                tv[i].setText(imageName[i]);
                rb[i].setRating((float) voteResult[i]);
            }

            Button btnResult = (Button) findViewById(R.id.btnReturn);
            btnResult.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    finish();
                }
            });
        }
    }
