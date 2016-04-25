package com.example.shakabreaux.nutritionguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Plan3Activity extends AppCompatActivity {
    private Button returnBtn;
    private Button protein;
    private Button fat;
    private Button veggie;
    private Button dairy;
    private Button fruit;
    private Button carb;
    private Button snack;
    private Button cond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan3);

        returnBtn = (Button) findViewById(R.id.returnBtn);
        protein = (Button) findViewById(R.id.proteinBtn);
        fat = (Button) findViewById(R.id.fatBtn);
        veggie = (Button) findViewById(R.id.vegiBtn);
        dairy = (Button) findViewById(R.id.dairyBtn);
        fruit = (Button) findViewById(R.id.fruitBtn);
        carb = (Button) findViewById(R.id.carbBtn);
        snack = (Button) findViewById(R.id.snackBtn);
        cond = (Button) findViewById(R.id.condBtn);

        returnBtn.setOnClickListener(mClickListener);
        protein.setOnClickListener(tClickListener);
        fat.setOnClickListener(tClickListener);
        veggie.setOnClickListener(tClickListener);
        dairy.setOnClickListener(tClickListener);
        fruit.setOnClickListener(tClickListener);
        carb.setOnClickListener(tClickListener);
        snack.setOnClickListener(tClickListener);
        cond.setOnClickListener(tClickListener);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private View.OnClickListener tClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == protein){
                startActivity(new Intent(Plan3Activity.this, ProteinActivity.class));
            }else if(v == fat){
                startActivity(new Intent(Plan3Activity.this, FatActivity.class));
            }else if(v == veggie){
                startActivity(new Intent(Plan3Activity.this, VeggieActivity.class));
            }else if(v == dairy){
                startActivity(new Intent(Plan3Activity.this, DairyActivity.class));
            }else if(v == fruit){
                startActivity(new Intent(Plan3Activity.this, FruitActivity.class));
            }else if(v == carb){
                startActivity(new Intent(Plan3Activity.this, CarbActivity.class));
            }else if(v == snack){
                startActivity(new Intent(Plan3Activity.this, SnacksActivity.class));
            }else{
                startActivity(new Intent(Plan3Activity.this, CondActivity.class));
            }
        }
    };
}
