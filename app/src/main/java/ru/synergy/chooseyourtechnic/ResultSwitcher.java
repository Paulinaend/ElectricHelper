package ru.synergy.chooseyourtechnic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ResultSwitcher extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultswitcher);

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
