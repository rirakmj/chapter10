package com.cookandroid.ex11_02_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.GatheringByteChannel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }
//        final GridView gv = (GridView) findViewById(R.id.gridView1);
//        MyGridAdapter myAdapter = new MyGridAdapter(this);
//        gv.setAdapter(myAdapter);
//    }

        public class MyGalleryAdapter extends BaseAdapter {
            Context context;

            Integer[] posterID = {
                    R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10, R.drawable.mov11, R.drawable.mov12,
                R.drawable.mov13, R.drawable.mov14, R.drawable.mov15, R.drawable.mov16,
                R.drawable.mov17, R.drawable.mov18, R.drawable.mov19, R.drawable.mov20,
                };
            public MyGalleryAdapter(Context c) {
                context = c;
            }

            @Override
            public int getCount() {
                return posterID.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageview = new ImageView(context);
                imageview.setLayoutParams(new Gallery.LayoutParams(200, 300));
                imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageview.setPadding(5, 5, 5, 5);

                imageview.setImageResource(posterID[position]);

                final int pos = position;
                imageview.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                        ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        ivPoster.setImageResource(posterID[pos]);

                        // 토스트 메세지 띄우기
                        Toast toast1 = new Toast(getApplicationContext());
                        View toastView = View.inflate(getApplicationContext(), R.layout.toast1, null);
                        TextView tv1 = toastView.findViewById(R.id.tv1);
                        tv1.setText(posterName[pos]);
                        toast1.setView(toastView);
                        toast1.show();
                        return false;
                    }
                });

                return imageview;
            }


        }
//    public class MyGridAdapter extends BaseAdapter {
//
//        Integer[] posterID = {
//                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
//                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
//                R.drawable.mov09, R.drawable.mov10, R.drawable.mov01, R.drawable.mov02,
//                R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
//                R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
//                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
//                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
//                R.drawable.mov09, R.drawable.mov10};
//
//        String[] posterName = { "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자",
//                "아일랜드", "웰컴투동막골", "헬보이", "백투더퓨처", "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자",
//                "아일랜드", "웰컴투동막골", "헬보이", "백투더퓨처", "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자",
//                "아일랜드", "웰컴투동막골", "헬보이", "백투더퓨처" };
//
//        Context context;
//        public MyGridAdapter(Context context) {
//            this.context = context;
//        }
//
//        @Override
//        // 그리드뷰에 보여질 이미지의 개수를 반환
//        public int getCount() {
//            return posterID.length;
//        }
//
//        @Override
//        // 영화 포스터를 각 그리드뷰의 칸마다 이미지뷰를 생성해서 보여주기
//        public View getView(int position, View view, ViewGroup viewGroup) {
//            ImageView imageview = new ImageView(context);
//            imageview.setLayoutParams(new GridView.LayoutParams(100, 150));
//            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageview.setPadding(5, 5, 5, 5);
//
//            imageview.setImageResource(posterID[position]);
//
//            imageview.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    View dialogView = (View) View.inflate(context, R.layout.dialog, null);
//
//                    AlertDialog.Builder dlg = new AlertDialog.Builder(context);
//                    ImageView iv1 = (ImageView) dialogView.findViewById(R.id.iv1);
//                    iv1.setImageResource(posterID[position]);
//
//                    // dlg.setTitle("큰 포스터");
//                    dlg.setTitle(posterName[position]);
//                    dlg.setIcon(R.drawable.movie_icon);
//                    dlg.setView(dialogView); // 다른 xml 가져오는 것, 보통 제일 윗줄에 작성한다
//                    dlg.setNegativeButton("닫기", null);
//                    dlg.show();
//                }
//            });
//
//            return imageview;
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }

        }

