package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {


    private TextView edit1;
    private TextView edit2 = null;
    private Boolean switchState = false;

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
    public void onClick3(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "3";
        edit1.setText(numberString);
    }

    public void onClick4(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "4";
        edit1.setText(numberString);
    }
    public void onClick5(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "5";
        edit1.setText(numberString);
    }
    public void onClick6(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "6";
        edit1.setText(numberString);
    }

    public void onClick7(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "7";
        edit1.setText(numberString);
    }
    public void onClick8(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "8";
        edit1.setText(numberString);
    }
    public void onClick9(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "9";
        edit1.setText(numberString);
    }
    public void onClick0(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "0";
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
        edit2 = findViewById(R.id.edit2);
        edit2.setText("");
    }

    /*SCIENTIFIC CALCULATIONS*/

    private HashMap<String, String> checkScientificFunctions(String string) {
        boolean isLogFound = string.indexOf("log( ") != -1 ? true: false;
        boolean isSinFound = string.indexOf("sin( ") != -1 ? true: false;
        boolean isSqrtFound = string.indexOf("sqrt( ") != -1 ? true: false;
        boolean isSqrFound = string.indexOf("sqr( ") != -1 ? true: false;

        if (isLogFound) {
            Log.i("In substring of chS", "info");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("log", string.substring(string.indexOf("log") + 3, string.length() - 1));
            return hashMap;
        }

        if (isSinFound) {
            Log.i("In substring of chS", "info");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("sin", string.substring(string.indexOf("sin") + 3, string.length() - 1));
            return hashMap;
        }

        if (isSqrtFound) {
            Log.i("In substring of chS", "info");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("sqrt", string.substring(string.indexOf("sqrt") + 4, string.length() - 1));
            return hashMap;
        }

        if (isSqrFound) {
            Log.i("In substring of chS", "info");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("sqr", string.substring(string.indexOf("sqr") + 3, string.length() - 1));
            return hashMap;
        }

        Log.i("Out substring of chS", "info");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("default", "null");

        return hashMap;
    }

    public void onLog(View view) {
        edit1 = findViewById(R.id.edit1);
        edit1.setText("log( ");
        numberString = "log( " + numberString;
    }

    public void onSin(View view) {
        edit1 = findViewById(R.id.edit1);
        edit1.setText("sin( ");
        numberString = "sin( " + numberString;
    }

    public void onSqrt(View view) {
        edit1 = findViewById(R.id.edit1);
        edit1.setText("sqrt( ");
        numberString = "sqrt( " + numberString;

    }

    public void onSquare(View view) {
        edit1 = findViewById(R.id.edit1);
        edit1.setText("sqr( ");
        numberString = "sqr( " + numberString;

    }

    /*-----------------------*/

    public void onEquals(View view) {
        if (numberString.length() == 0)
            return;
        edit2 = findViewById(R.id.edit2);
        double ans = 0;
        try {
            if (switchState) {
                HashMap<String, String> scientificMap = checkScientificFunctions(numberString);
//            numberString = checkScientificFunctions(numberString);
                if (scientificMap.containsKey("log")) {
                    Log.i("In scientific state", "info");
                    ans = evaluator.evaluate(scientificMap.get("log"));
                    ans = Math.log(ans);
                } else if (scientificMap.containsKey("sin")) {
                    Log.i("In scientific state", "info");
                    ans = evaluator.evaluate(scientificMap.get("sin"));
                    ans = Math.sin(Math.toRadians(ans));
                } else if (scientificMap.containsKey("sqrt")) {
                    Log.i("In scientific state", "info");
                    ans = evaluator.evaluate(scientificMap.get("sqrt"));
                    ans = Math.sqrt(ans);
                }
                else if (scientificMap.containsKey("sqr")) {
                    Log.i("In scientific state", "info");
                    ans = evaluator.evaluate(scientificMap.get("sqr"));
                    ans = ans * ans;
                }
                else {
                    ans = evaluator.evaluate(numberString);
                }

            } else
                ans = evaluator.evaluate(numberString);

            Log.i("Number String" + numberString  + "ans" + ans, "info");
            edit2.setText(Double.toString(ans));

        } catch (Exception e) {
            Log.i("Exception in equals", "exception");
            edit2.setText("Invalid Number Entered!");
        }
    }

    public void onBackSpace(View view) {
        if (numberString.length() > 0)
            numberString = numberString.substring(0, numberString.length() - 1);
        edit1.setText(numberString);
    }


    public void onToggleScientific(View view) {
        Switch scientificToggleSwitch = findViewById(R.id.scientific_switch);
        switchState = scientificToggleSwitch.isChecked();
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
