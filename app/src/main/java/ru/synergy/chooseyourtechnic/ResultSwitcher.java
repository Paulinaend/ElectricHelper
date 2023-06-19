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

        Float nom = Float.parseFloat(result);
        SwitcherInformation(nom);



        final ImageButton backsw = (ImageButton) findViewById(R.id.backswitcher);

        backsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(ResultSwitcher.this, FirstActivity.class);
                startActivity(i);
            }
        });
    }

    public void SwitcherInformation(float a) {

        String nominal;

        if ( a > 0 && a <= 6) {
            float result = 6;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultswitcher);
            ans.setText(nominal + " A");

        } else if (a > 6 && a <= 10 ) {
            float result = 10;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultswitcher);
            ans.setText(nominal + " A");

        } else if (a > 10 && a <= 16 ) {
            float result = 16;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultswitcher);
            ans.setText(nominal + " A");

        } else if (a > 16 && a <= 25 ) {
            float result = 25;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultswitcher);
            ans.setText(nominal + " A");

        } else if (a > 25 && a <= 32 ) {
            float result = 32;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultswitcher);
            ans.setText(nominal + " A");

        } else if (a > 32 && a <= 40 ) {
            float result = 40;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultswitcher);
            ans.setText(nominal + " A");

        } else if (a > 40 && a <= 63 ) {
            float result = 63;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultswitcher);
            ans.setText(nominal + " A");

        } else if (a > 63 && a <= 80 ) {
            float result = 80;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultswitcher);
            ans.setText(nominal + " A");

        } else if (a > 80 && a <= 100 ) {
            float result = 100;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultswitcher);
            ans.setText(nominal + " A");

        } else {
            nominal = "Ваш ток слишком большой для НКУ";
            TextView ans = (TextView) findViewById(R.id.resultswitcher);
            ans.setText(nominal);
        }

    }
}
