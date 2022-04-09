package com.example.mathiathloustic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMaths(View view) {

        // Création d'une intention
        Intent Exercice1ViewActivityIntent = new Intent(MainActivity.this, Selection_exercice_maths.class);
        // Lancement de la demande de changement d'activité
        startActivity(Exercice1ViewActivityIntent);
    }

    public void onOther(View view){
        // Création d'une intention
        Intent Exercice1ViewActivityIntent = new Intent(MainActivity.this, TableMultiplication.class);

        // Lancement de la demande de changement d'activité
        startActivity(Exercice1ViewActivityIntent);
    }
}