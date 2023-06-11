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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultswitcher);

        FirstActivity load = new FirstActivity();
        float power = load.getPower();
        float voltage = load.getVoltage();
        float phase = load.getPhase();
        float cosfi = load.getCosFi();


        if(phase==3) {
            float result = (float) (power / (voltage * cosfi * (Math.sqrt(3))));
            String res = Float.toString(result);
            TextView answer = (TextView) findViewById(R.id.currentswitcher);
            answer.setText(res);
        }
        else if(phase==1)
        {
            float result = (float) power / voltage;
            String res = Float.toString(result);
            TextView answer = (TextView) findViewById(R.id.currentswitcher);
            answer.setText(res);
        }
        else{
            TextView answer = (TextView) findViewById(R.id.currentswitcher);
            answer.setText("Введите корректное число фаз");
        }

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
