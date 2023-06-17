package ru.synergy.chooseyourtechnic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        //сохранение файла
       /* public void saveText(View view){
            FileOutputStream fos = null;
            try {
                EditText textBox = (EditText) findViewById(R.id.editor);
                String text = textBox.getText().toString();

                fos = new FileOutputStream(getExternalFilePath());  //openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(text.getBytes());
                Toast.makeText(this, "Файл успешно сохранен", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
            } finally {

                try {
                    if(fos != null){
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }*/

        final ImageButton backsaved = (ImageButton) findViewById(R.id.backsaved);

        backsaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(SavedData.this, FirstActivity.class);
                startActivity(i);
            }
        });
    }
}
