package jp.suntech.c22010.mypicturebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        ButtonClickListener listener = new ButtonClickListener();

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
    }

    private class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            int id = view.getId();

            if(id == R.id.button1){
                transaction.replace(R.id.frag_view_pic, new Fragment1());
            }
            else if(id == R.id.button2){
                transaction.replace(R.id.frag_view_pic, new Fragment2());
            }
            else if(id == R.id.button3){
                transaction.replace(R.id.frag_view_pic, new Fragment3());
            }
            transaction.commit();
        }
    }
}