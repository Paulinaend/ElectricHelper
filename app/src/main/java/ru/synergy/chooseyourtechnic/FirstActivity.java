package ru.synergy.chooseyourtechnic;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    float powerset=1;
    float voltageset=1;
    float phaseset=1;
    float cosfiset=1;

//    SharedPreferences sharedPreferences;
//    final String SAVED_POWER = "saved_power";
//    final String SAVED_VOLTAGE = "saved_voltage";
//    final String SAVED_PHASE = "saved_phase";
//    final String SAVED_COSFI = "saved_cosfi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button switcher = (Button) findViewById(R.id.Switcher);
        final Button cable = (Button) findViewById(R.id.CableLine);
        final Button guide = (Button) findViewById(R.id.Guide);
        final Button saved = (Button) findViewById(R.id.SavedData);
        final Button butdatabase = (Button) findViewById(R.id.but_db);

        EditText powerSet = (EditText) findViewById(R.id.PowerSet);
        EditText voltageSet = (EditText) findViewById(R.id.VoltageSet);
        EditText phaseSet = (EditText) findViewById(R.id.PhaseSet);
        EditText cosFiSet = (EditText) findViewById(R.id.CosFiSet);

//        loadText(powerSet, voltageSet, phaseSet, cosFiSet);
//        powerSet.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                savePower(powerSet);
//                return true;
//            }
//        });
//        voltageSet.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                saveVoltage(voltageSet);
//                return true;
//            }
//        });
//        phaseSet.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                savePhase(phaseSet);
//                return true;
//            }
//        });
//        cosFiSet.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                saveCosFi(cosFiSet);
//                return true;
//            }
//        });


        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                SetFields(powerSet, voltageSet, phaseSet, cosFiSet);
                Intent i = new Intent(FirstActivity.this, ResultSwitcher.class);
                i.putExtra("current", getCurrent());
                startActivity(i);
            }
        });

        cable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                SetFields(powerSet, voltageSet, phaseSet, cosFiSet);
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
                SetFields(powerSet, voltageSet, phaseSet, cosFiSet);
                Intent i = new Intent(FirstActivity.this, SavedData.class);
                i.putExtra("power", getPower());
                i.putExtra("voltage", getVoltage());
                i.putExtra("phase", getPhase());
                i.putExtra("cosFi", getCosFi());
                i.putExtra("current", getCurrent());
                startActivity(i);
            }
        });

        butdatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(FirstActivity.this, NoteListActivity.class);
                startActivity(i);
            }
        });
    }

    public void SetFields(EditText a, EditText b, EditText c, EditText d) {
//        EditText powerSet = (EditText) findViewById(R.id.PowerSet);
//        EditText voltageSet = (EditText) findViewById(R.id.VoltageSet);
//        EditText phaseSet = (EditText) findViewById(R.id.PhaseSet);
//        EditText cosFiSet = (EditText) findViewById(R.id.CosFiSet);

        String powers = a.getText().toString();
        String voltages = b.getText().toString();
        String phases = c.getText().toString();
        String cosfis = d.getText().toString();

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

//    private void loadText(EditText a, EditText b, EditText c, EditText d) {
//        sharedPreferences = getPreferences(MODE_PRIVATE);
//        String savedPower = sharedPreferences.getString(SAVED_POWER, "500...");
//        String savedVoltage = sharedPreferences.getString(SAVED_VOLTAGE, "24, 220 или 380...");
//        String savedPhase = sharedPreferences.getString(SAVED_PHASE, "1 или 3");
//        String savedCosFi = sharedPreferences.getString(SAVED_COSFI, "1 или 0.8");
//        a.setText(savedPower);
//        b.setText(savedVoltage);
//        c.setText(savedPhase);
//        d.setText(savedCosFi);
//    }
//
//    private void savePower(EditText a) {
//        sharedPreferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor ed = sharedPreferences.edit();
//        ed.putString(SAVED_POWER, a.getText().toString());
//        ed.commit();
//    }
//    private void saveVoltage(EditText a) {
//        sharedPreferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor ed = sharedPreferences.edit();
//        ed.putString(SAVED_VOLTAGE, a.getText().toString());
//        ed.commit();
//    }
//    private void savePhase(EditText a) {
//        sharedPreferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor ed = sharedPreferences.edit();
//        ed.putString(SAVED_PHASE, a.getText().toString());
//        ed.commit();
//    }
//    private void saveCosFi(EditText a) {
//        sharedPreferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor ed = sharedPreferences.edit();
//        ed.putString(SAVED_COSFI, a.getText().toString());
//        ed.commit();
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        savePower();
//    }
}
