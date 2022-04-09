package com.example.mathiathloustic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

public class MathsQuestions extends AppCompatActivity {

    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_questions_test);
        this.chronometer = (Chronometer) findViewById(R.id.chronometer);

        long elapsedRealtime = SystemClock.elapsedRealtime();
        // Set the time that the count-up timer is in reference to.
        this.chronometer.setBase(elapsedRealtime);
        this.chronometer.start();




    }



}