package ru.synergy.chooseyourtechnic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ResultCable extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultcable);

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
