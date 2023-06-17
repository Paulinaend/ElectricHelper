package ru.synergy.chooseyourtechnic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SavedData extends AppCompatActivity {

    private final static String FILE_NAME = "content.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saveddata);

        Bundle arguments = getIntent().getExtras();
        String current = arguments.getString("current");
        Float power = arguments.getFloat("power");
        Float voltage = arguments.getFloat("voltage");
        Float phase = arguments.getFloat("phase");
        Float cosFi = arguments.getFloat("cosFi");

        String powerstr = Float.toString(power);
        String voltagestr = Float.toString(voltage);
        String phasestr = Float.toString(phase);
        String cosFistr = Float.toString(cosFi);

        TextView answer = (TextView) findViewById(R.id.savedvalues);
        answer.setText("При нагрузке " + powerstr + " Вт, " + "напряжении " + voltagestr + " В, " + "количестве фаз " + phasestr + ", " + "коэффициенте нагрузки " + cosFistr + " - ток равен " + current + " А на фазу");


        final ImageButton backsaved = (ImageButton) findViewById(R.id.backsaved);
        backsaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SavedData.this, FirstActivity.class);
                startActivity(i);
            }
        });
    }

    private File getExternalFilePath() {
        return new File(getExternalFilesDir(null), FILE_NAME);
    }

    //сохранение файла

    public void saveText(View view) {
        FileOutputStream fos = null;
        try {
            TextView textBox = (TextView) findViewById(R.id.savedvalues);
            String text = textBox.getText().toString();

            fos = new FileOutputStream(getExternalFilePath());  //openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "Данные успешно сохранены", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        } finally {

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    //открытие файла
    public void openText(View view){
        FileInputStream fin = null;
        TextView textView = (TextView) findViewById(R.id.text);

        File file = getExternalFilePath();

        try{
            fin = new FileInputStream(file); //openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            textView.setText(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        } finally {

            try{
                if(fin != null){
                    fin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
    }


}