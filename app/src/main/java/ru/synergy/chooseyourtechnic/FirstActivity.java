package ru.synergy.chooseyourtechnic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button switcher = (Button) findViewById(R.id.Switcher);
        final Button cable = (Button) findViewById(R.id.CableLine);
        final Button guide = (Button) findViewById(R.id.Guide);
        final Button saved = (Button) findViewById(R.id.SavedData);

        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(FirstActivity.this, ResultSwitcher.class);
                startActivity(i);
            }
        });

        cable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(FirstActivity.this, ResultCable.class);
                startActivity(i);
            }
        });

        guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(FirstActivity.this, Guide.class);
                startActivity(i);
            }
        });

        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(FirstActivity.this, SavedData.class);
                startActivity(i);
            }
        });

    }
    private void solution() {
        EditText powerSet = (EditText) findViewById(R.id.PowerSet);
        EditText voltageSet = (EditText) findViewById(R.id.VoltageSet);
        EditText phaseSet = (EditText) findViewById(R.id.PhaseSet);
        EditText cosFiSet = (EditText) findViewById(R.id.CosFiSet);

        float powerset = 1;
        float voltageset = 1;
        float phaseset = 1;
        float cosfiset = 1;

        String powers = powerSet.getText().toString();
        String voltages = voltageSet.getText().toString();
        String phases = phaseSet.getText().toString();
        String cosfis = cosFiSet.getText().toString();

        if(!powers.equals("") && powers!=null){
            powerset = Integer.parseInt(powerSet.getText().toString());
        }
        if(!voltages.equals("") && voltages!=null){
            voltageset = Integer.parseInt(voltageSet.getText().toString());
        }
        if(!phases.equals("") && phases!=null){
            phaseset = Integer.parseInt(phaseSet.getText().toString());
        }
        if(!cosfis.equals("") && cosfis!=null){
            cosfiset = Integer.parseInt(cosFiSet.getText().toString());
        }

        float solution = 0;



    }

}
