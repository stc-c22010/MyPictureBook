package jp.suntech.c22010.mypicturebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button bt_back = findViewById(R.id.btn_back);
        Button bt_next = findViewById(R.id.btn_next);
        ButtonClickListener listener = new ButtonClickListener();

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        bt_back.setOnClickListener(listener);
        bt_next.setOnClickListener(listener);
    }

    private class ButtonClickListener implements View.OnClickListener{
        int idx = 3;
        @Override
        public void onClick(View view){

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            int id = view.getId();
            idx += 1;
            if(idx >= 4){
                idx = 0;
            }

            if(id == R.id.button1){
                transaction.replace(R.id.frag_view_pic, new Fragment1());
                idx = 0;
            }
            else if(id == R.id.button2){
                transaction.replace(R.id.frag_view_pic, new Fragment2());
                idx = 1;
            }
            else if(id == R.id.button3){
                transaction.replace(R.id.frag_view_pic, new Fragment3());
                idx = 2;
            }
            else if(id == R.id.button4){
                transaction.replace(R.id.frag_view_pic, new Fragment4());
                idx = 3;
            }
            else if(id == R.id.btn_next){
                if(idx == 0){
                    transaction.replace(R.id.frag_view_pic, new Fragment1());
                }
                else if(idx == 1){
                    transaction.replace(R.id.frag_view_pic, new Fragment2());
                }
                else if(idx == 2){
                    transaction.replace(R.id.frag_view_pic, new Fragment3());
                }
                else if(idx == 3){
                    transaction.replace(R.id.frag_view_pic, new Fragment4());
                }
            }

            transaction.commit();
            if(id == R.id.btn_back){
                finish();
            }
        }
    }
}