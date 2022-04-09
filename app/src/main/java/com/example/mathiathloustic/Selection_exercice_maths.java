package com.example.mathiathloustic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Selection_exercice_maths extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_exercice_maths);
    }


    public void home(View view){
        Intent Exercice1ViewActivityIntent = new Intent(Selection_exercice_maths.this, MainActivity.class);
        Exercice1ViewActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Lancement de la demande de changement d'activité
        startActivity(Exercice1ViewActivityIntent);
    }

    public void calcul_ment(View view){
        Intent Exercice1ViewActivityIntent = new Intent(Selection_exercice_maths.this, Exercice_calcul_mental.class);
        // Lancement de la demande de changement d'activité
        startActivity(Exercice1ViewActivityIntent);
    }

    public void table_mult(View view){
        Intent Exercice1ViewActivityIntent = new Intent(Selection_exercice_maths.this, Exercice_table_mult.class);
        // Lancement de la demande de changement d'activité
        startActivity(Exercice1ViewActivityIntent);
    }

}