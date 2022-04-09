package com.example.mathiathloustic;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Exercice_table_mult extends AppCompatActivity {

    private final ArrayList<EditText> editTexts = new ArrayList<EditText>();

    private final ExerciceMathsTableMult exercice = new ExerciceMathsTableMult();

    private Button btn_valider;
    private Button btn_next;

    private final TextChangedListener<Exercice_table_mult> listener;


    public Exercice_table_mult(){
        this.listener = new TextChangedListener<Exercice_table_mult>(this) {
            @Override
            public void onTextChanged(Exercice_table_mult target, Editable s) {
                target.checkIfAllFilled();
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_table_mult);

        this.btn_valider = findViewById(R.id.btn_valider);
        this.btn_next = findViewById(R.id.btn_suivant);

        this.initQuestions();


    }

    protected void initQuestions(){

        TextView info = findViewById(R.id.info);
        info.setText(getString(R.string.info_ex_serie, this.exercice.done));


        LinearLayout linear = findViewById(R.id.list_mult);
        // reset all by default
        linear.removeAllViews();
        editTexts.clear();
        this.btn_valider.setEnabled(false);
        this.btn_next.setEnabled(false);

        ArrayList<String> questions = this.exercice.generateNewTable();

        for (int i = 0; i < questions.size(); i++) {
            LinearLayout tmpL = (LinearLayout) getLayoutInflater().inflate(R.layout.multiplication_layout, null);
            TextView calcul = tmpL.findViewById(R.id.mult_text);
            calcul.setText(questions.get(i));
            EditText editText = tmpL.findViewById(R.id.mult_rep);
            // Set basic state
            editText.setEnabled(true);
            editText.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            editText.setText("");
            editText.addTextChangedListener(this.listener);
            editTexts.add(editText);
            linear.addView(tmpL);
        }

        // Place le curseur dans le 1er
        EditText firstE = editTexts.get(0);
        firstE.setFocusableInTouchMode(true);
        firstE.requestFocus();

    }

    public void checkAwnser(View view){

        ArrayList<Integer> results = new ArrayList<Integer>();

        for (EditText e : editTexts){
            results.add(Integer.valueOf(e.getText().toString()));
        }

        ArrayList<Integer> correct = this.exercice.correction(results);

        for (int i = 0; i < editTexts.size(); i++) {
            EditText editText = editTexts.get(i);
            if (correct.contains(i)) {
                editText.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
            } else {
                editText.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            }
        }

        this.btn_valider.setEnabled(false);
        this.btn_next.setEnabled(true);


    }

    private void checkIfAllFilled(){
        Boolean good = true;
        for (int i = 0; i < this.editTexts.size(); i++) {
            if (this.editTexts.get(i).getText().toString().equals("")){
                good =false;
            }
        }

        if (good){
            this.btn_valider.setEnabled(true);
        } else {
            this.btn_valider.setEnabled(false);
        }
    }




    public void home(View view){
        Intent Exercice1ViewActivityIntent = new Intent(Exercice_table_mult.this, MainActivity.class);
        Exercice1ViewActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Lancement de la demande de changement d'activité
        startActivity(Exercice1ViewActivityIntent);
    }

    public void nextQuestions(View view){
        if (this.exercice.done.equals(2                                   )){
            Intent Exercice1ViewActivityIntent = new Intent(Exercice_table_mult.this, result_exercice.class);
            startActivity(Exercice1ViewActivityIntent);
        } else {
            this.initQuestions();
        }
    }
}