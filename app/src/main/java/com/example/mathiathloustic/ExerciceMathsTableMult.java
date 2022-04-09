package com.example.mathiathloustic;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ExerciceMathsTableMult {
    Integer min = 0;
    Integer max = 10;
    Integer nbQ = 5;
    Integer score = 0;
    Integer done = 0;


    public final ArrayList<Integer> reps = new ArrayList<Integer>();

    public ArrayList<String> generateNewTable(){
        ArrayList<String> r = new ArrayList<String>();
        reps.clear();

        for (int i = 0; i < nbQ; i++) {
            final int random1 = new Random().nextInt((max - min) + 1) + min;
            final int random2 = new Random().nextInt((max - min) + 1) + min;

            r.add(random1 + "x" + random2 + " = ");
            this.reps.add(random1 * random2);
        }
        return r;
    }

    public ArrayList<Integer> correction(ArrayList<Integer> values){
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(this.reps.get(i))){
                results.add(i);
            }
        }

        this.score += results.size();
        this.done += 1;

        return results;
    }

}
