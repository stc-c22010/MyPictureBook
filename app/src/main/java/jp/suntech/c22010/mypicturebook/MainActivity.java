package jp.suntech.c22010.mypicturebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn = findViewById(R.id.imageButton);
        ImageButton btn_xlarge = findViewById(R.id.imageButton_xlarge);
        ButtonClickListener listener = new ButtonClickListener();
        if(btn != null) {
            btn.setOnClickListener(listener);
        }
        if(btn_xlarge != null){
            btn_xlarge.setOnClickListener(listener);
        }


    }

    private class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            startActivity(intent);
        }
    }
}