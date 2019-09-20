package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {


    private TextView edit1;
    private TextView edit2;

    private String numberString = "";
    private InfixEvaluator evaluator = new InfixEvaluator();

    public void onClick1(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "1";
        edit1.setText(numberString);
    }

    public void onClick2(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "2";
        edit1.setText(numberString);
    }

    public void onClickOpeningBrace(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + " ( ";
        edit1.setText(numberString);
    }

    public void onClickClosingBrace(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + " ) ";
        edit1.setText(numberString);

    }

    public void onAdd(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + " + ";
        edit1.setText(numberString);
    }

    public void onSubtract(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + " - ";
        edit1.setText(numberString);
    }


    public void onMultiply(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + " * ";
        edit1.setText(numberString);

    }


    public void onDivide(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + " / ";
        edit1.setText(numberString);

    }

    public void onClear(View view) {
        numberString = "";
        edit1.setText(null);
        edit2.setText(null);
    }

    public void onEquals(View view) {
        edit2 = findViewById(R.id.edit2);
        double ans = evaluator.evaluate(numberString);
        Log.i("Number String" + numberString  + "ans" + ans, "info");
        edit2.setText(Double.toString(ans));
    }

    public void onBackSpace(View view) {
        if (numberString.length() > 0)
            numberString = numberString.substring(0, numberString.length() - 1);
        edit1.setText(numberString);
    }


    public void onToggleScientific(View view) {
        Switch scientificToggleSwitch = findViewById(R.id.scientific_switch);
        Boolean switchState = scientificToggleSwitch.isChecked();
        GridLayout gridLayout2 = findViewById(R.id.grid_layout2);
        GridLayout gridLayout1 = findViewById(R.id.grid_layout1);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) gridLayout1.getLayoutParams();

        if (switchState) {
            gridLayout2.setVisibility(View.VISIBLE);
            params.topMargin = 50;
            gridLayout1.setLayoutParams(params);
        } else {
            gridLayout2.setVisibility(View.GONE);
            params.topMargin = 80;
            gridLayout1.setLayoutParams(params);

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
