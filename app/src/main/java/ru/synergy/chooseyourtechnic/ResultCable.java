package ru.synergy.chooseyourtechnic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultCable extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultcable);

        Bundle arguments = getIntent().getExtras();
        String result = arguments.getString("current");
        TextView answer = (TextView) findViewById(R.id.currentcable);
        answer.setText(result + " A");

        final ImageButton backcab = (ImageButton) findViewById(R.id.backcable);

        backcab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(ResultCable.this, FirstActivity.class);
                startActivity(i);
            }
        });
    }
}
