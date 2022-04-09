package com.example.mathiathloustic;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class TableMultiplication extends AppCompatActivity {

    private ArrayList<EditText> editTexts;
    private ArrayList<Integer> reps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication_test);
        final int min = 1;
        final int max = 10;

        LinearLayout linear = findViewById(R.id.list_mult);

        this.editTexts = new ArrayList<EditText>();
        this.reps = new ArrayList<Integer>();

        for (int i = 0; i < 6; i++) {
            final int random = new Random().nextInt((max - min) + 1) + min;
            LinearLayout tmpL = (LinearLayout) getLayoutInflater().inflate(R.layout.multiplication_layout, null);

            TextView calcul = tmpL.findViewById(R.id.mult_text);
            calcul.setText(random + "x" + random + " = ");

            EditText editText = tmpL.findViewById(R.id.mult_rep);

            editTexts.add(editText);
            reps.add(random * random);

            linear.addView(tmpL);
        }
    }

    public void checkAwnser(View view){
        for (int i = 0; i < this.reps.size(); i++) {
            EditText editText = this.editTexts.get(i);
            Integer value = new Integer(editText.getText().toString());
            if (value.equals(this.reps.get(i))){
                editText.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
            } else {
                editText.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }
}