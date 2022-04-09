package com.example.mathiathloustic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class result_exercice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_exercice);

        Integer score_f = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("score_final");
            TextView info = findViewById(R.id.score_final);
            info.setText(getString(R.string.score_final, value));
        }
        else {
            TextView info = findViewById(R.id.score_final);
            info.setText(getString(R.string.score_final, "0"));
        }


    }

    public void home(View view){
        Intent Exercice1ViewActivityIntent = new Intent(result_exercice.this, MainActivity.class);
        Exercice1ViewActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(Exercice1ViewActivityIntent);
    }

    public void back(View view){
        finishActivity(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
    }
}