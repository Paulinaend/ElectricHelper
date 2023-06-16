package ru.synergy.chooseyourtechnic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultSwitcher extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultswitcher);

        Bundle arguments = getIntent().getExtras();
        String result = arguments.getString("current");
        TextView answer = (TextView) findViewById(R.id.currentswitcher);
        answer.setText(result + " A");


        final ImageButton backsw = (ImageButton) findViewById(R.id.backswitcher);

        backsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(ResultSwitcher.this, FirstActivity.class);
                startActivity(i);
            }
        });
    }
}
