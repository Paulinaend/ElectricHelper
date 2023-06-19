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

        Float nom = Float.parseFloat(result);
        CableInformation(nom);

        final ImageButton backcab = (ImageButton) findViewById(R.id.backcable);

        backcab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(ResultCable.this, FirstActivity.class);
                startActivity(i);
            }
        });
    }

    public void CableInformation(float a) {

        String nominal;

        if ( a > 0 && a <= 5) {
            float result = 0.75F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 5 && a <= 20 ) {
            float result = 1.5F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 20 && a <= 30 ) {
            float result = 2.5F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 30 && a <= 40 ) {
            float result = 4F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 40 && a <= 50 ) {
            float result = 6F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 50 && a <= 80 ) {
            float result = 10F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 80 && a <= 100 ) {
            float result = 16F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 100 && a <= 140 ) {
            float result = 25F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 140 && a <= 170 ) {
            float result = 35F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 170 && a <= 215 ) {
            float result = 50F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 215 && a <= 270 ) {
            float result = 70F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else if (a > 270 && a <= 330 ) {
            float result = 95F;
            nominal = Float.toString(result);
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal + " mm2");

        } else {
            nominal = "Ваш ток слишком большой для НКУ";
            TextView ans = (TextView) findViewById(R.id.resultcable);
            ans.setText(nominal);
        }

    }

}
