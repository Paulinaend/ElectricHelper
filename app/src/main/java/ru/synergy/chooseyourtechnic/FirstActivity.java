package ru.synergy.chooseyourtechnic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    float powerset=1;
    float voltageset=1;
    float phaseset=1;
    float cosfiset=1;

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
                SetFields();
                Intent i = new Intent(FirstActivity.this, ResultSwitcher.class);
                i.putExtra("current", getCurrent());
                startActivity(i);
            }
        });

        cable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                SetFields();
                Intent i = new Intent(FirstActivity.this, ResultCable.class);
                i.putExtra("current", getCurrent());
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
                SetFields();
                Intent i = new Intent(FirstActivity.this, SavedData.class);
                i.putExtra("power", getPower());
                i.putExtra("voltage", getVoltage());
                i.putExtra("phase", getPhase());
                i.putExtra("cosFi", getCosFi());
                i.putExtra("current", getCurrent());
                startActivity(i);
            }
        });

    }

    public void SetFields() {
        EditText powerSet = (EditText) findViewById(R.id.PowerSet);
        EditText voltageSet = (EditText) findViewById(R.id.VoltageSet);
        EditText phaseSet = (EditText) findViewById(R.id.PhaseSet);
        EditText cosFiSet = (EditText) findViewById(R.id.CosFiSet);

        String powers = powerSet.getText().toString();
        String voltages = voltageSet.getText().toString();
        String phases = phaseSet.getText().toString();
        String cosfis = cosFiSet.getText().toString();

        if (!powers.equals("")) {
            powerset = Float.parseFloat(powers);//powerSet.getText().toString()
        }
        if (!voltages.equals("")) {
            voltageset = Float.parseFloat(voltages);//voltageSet.getText().toString()
        }
        if (!phases.equals("")) {
            phaseset = Float.parseFloat(phases);//phaseSet.getText().toString()
        }
        if (!cosfis.equals("")) {
            cosfiset = Float.parseFloat(cosfis);//cosFiSet.getText().toString()
        }
    }


    public float getPower()
    {
        return this.powerset;
    }
    public float getVoltage()
    {
        return this.voltageset;
    }

    public float getPhase()
    {
        return this.phaseset;
    }

    public float getCosFi()
    {
        return this.cosfiset;
    }

    public String getCurrent() {

        String res;

        if (phaseset == 3) {
            float result = (float) (powerset / (voltageset * cosfiset * (Math.sqrt(3))));
            res = Float.toString(result);

        } else if (phaseset == 1) {
            float result = (float) powerset / voltageset;
            res = Float.toString(result);

        } else {
            res = "Введите корректное число фаз";

        }
        return res;
    }

}
