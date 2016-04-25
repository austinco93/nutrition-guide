package com.example.shakabreaux.nutritionguide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NutritionActivity extends AppCompatActivity {

    private EditText bodyWeight;
    private TextView RMRoutput;
    private TextView RMRinput;
    private TextView DABoutput;
    private TextView RMRinput2;
    private TextView DABinput;
    private TextView energy;
    private TextView nutrition;

    private TextView energy1;
    private TextView nutrition1;
    private TextView energy2;
    private TextView nutrition2;
    private TextView energy3;
    private TextView nutrition3;

    private Button calculate;
    private Button reset;
    private Button planBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        bodyWeight = (EditText) findViewById(R.id.bdInput);
        RMRoutput = (TextView) findViewById(R.id.RMRoutput);
        RMRinput = (TextView) findViewById(R.id.RMRinput);
        DABoutput = (TextView) findViewById(R.id.DABoutput);
        RMRinput2 = (TextView) findViewById(R.id.RMRinput2);
        DABinput = (TextView) findViewById(R.id.DABinput);
        energy = (TextView) findViewById(R.id.energyOutput);
        nutrition = (TextView) findViewById(R.id.nutritionOutput);

        energy1 = (TextView) findViewById(R.id.energy1);
        nutrition1 = (TextView) findViewById(R.id.nutrit1);
        energy2 = (TextView) findViewById(R.id.energy2);
        nutrition2 = (TextView) findViewById(R.id.nutrit2);
        energy3 = (TextView) findViewById(R.id.energy3);
        nutrition3 = (TextView) findViewById(R.id.nutrit3);

        calculate = (Button) findViewById(R.id.calc);
        reset = (Button) findViewById(R.id.reset);
        planBtn = (Button) findViewById(R.id.plan);

        calculate.setOnClickListener(mClickListener);
        reset.setOnClickListener(mClickListener);
        planBtn.setOnClickListener(tClickListener);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == reset) {
                reset();
            } else {
                calculate();
            }
        }
    };

    private View.OnClickListener tClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(nutrition.getText().toString().equals("") || nutrition.getText().toString().isEmpty()){
                Toast.makeText(NutritionActivity.this, "Nutrition level not yet calculated, please calculate first", Toast.LENGTH_LONG).show();
            }
            else{
                if(nutrition.getText().toString().equals("Level 1")) {
                    startActivity(new Intent(NutritionActivity.this, PlanActivity.class));
                }else if(nutrition.getText().toString().equals("Level 2")){
                    startActivity(new Intent(NutritionActivity.this, Plan2Activity.class));
                }
                else{
                    startActivity(new Intent(NutritionActivity.this, Plan3Activity.class));
                }
            }
        }
    };

    private void calculate(){
        if (bodyWeight.getText().toString().equals("") || bodyWeight.getText().toString().isEmpty()) {
            Toast.makeText(NutritionActivity.this, "Body Weight field must be filled", Toast.LENGTH_LONG).show();
            return;
        }

        double bodyweight = Double.parseDouble(bodyWeight.getText().toString());
        double rmr = bodyweight * 10;
        double dab = rmr * .2;
        double ener = rmr + dab + 600;

        RMRinput.setText(String.format("%.0f", rmr));
        RMRoutput.setText(String.format("%.0f", rmr));
        DABoutput.setText(String.format("%.0f", dab));
        RMRinput2.setText(String.format("%.0f", rmr));
        DABinput.setText(String.format("%.0f", dab));
        energy.setText(String.format("%.0f", ener));

        if(ener < 2400) {
            nutrition.setText("Level 1");
            energy1.setBackgroundColor(Color.RED);
            nutrition1.setBackgroundColor(Color.RED);
            energy2.setBackgroundColor(getResources().getColor(R.color.e2));
            nutrition2.setBackgroundColor(getResources().getColor(R.color.e2));
            energy3.setBackgroundColor(getResources().getColor(R.color.e3));
            nutrition3.setBackgroundColor(getResources().getColor(R.color.e3));
        }
        else if(ener >= 2400 && ener < 3000){
            nutrition.setText("Level 2");
            energy2.setBackgroundColor(Color.RED);
            nutrition2.setBackgroundColor(Color.RED);
            energy1.setBackgroundColor(getResources().getColor(R.color.e1));
            nutrition1.setBackgroundColor(getResources().getColor(R.color.e1));
            energy3.setBackgroundColor(getResources().getColor(R.color.e3));
            nutrition3.setBackgroundColor(getResources().getColor(R.color.e3));
        }
        else{
            nutrition.setText("Level 3");
            energy3.setBackgroundColor(Color.RED);
            nutrition3.setBackgroundColor(Color.RED);
            energy1.setBackgroundColor(getResources().getColor(R.color.e1));
            nutrition1.setBackgroundColor(getResources().getColor(R.color.e1));
            energy2.setBackgroundColor(getResources().getColor(R.color.e2));
            nutrition2.setBackgroundColor(getResources().getColor(R.color.e2));
        }
    }

    private void reset() {
        bodyWeight.setText("");
        RMRinput.setText("");
        RMRoutput.setText("");
        DABoutput.setText("");
        RMRinput2.setText("");
        DABinput.setText("");
        energy.setText("");
        nutrition.setText("");
        energy1.setBackgroundColor(getResources().getColor(R.color.e1));
        nutrition1.setBackgroundColor(getResources().getColor(R.color.e1));
        energy2.setBackgroundColor(getResources().getColor(R.color.e2));
        nutrition2.setBackgroundColor(getResources().getColor(R.color.e2));
        energy3.setBackgroundColor(getResources().getColor(R.color.e3));
        nutrition3.setBackgroundColor(getResources().getColor(R.color.e3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nutrition, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
