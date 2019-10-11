package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.HashMap;

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

    public void onDot(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + ".";
        edit1.setText(numberString);
    }

    public void onComma(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + ",";
        edit1.setText(numberString);
    }

    public void onFactorial(View view) {
        edit1 = findViewById(R.id.edit1);
        numberString = numberString + "!";
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

    public String convertToFraction(double decimal){
        int digitsAfterPoint = String.valueOf(decimal).length() - String.valueOf(decimal).indexOf('.')+1; // get the count of digits after the point // for example 0.75 has two digits
        BigInteger numerator  = BigInteger.valueOf((long)(decimal*Math.pow(10, digitsAfterPoint))); // multiply 0.75 with 10^2 to get 75
        BigInteger denominator = BigInteger.valueOf((long)(Math.pow(10, digitsAfterPoint)));       // 10^2 is your denominator
        int gcd = numerator.gcd(denominator).intValue();                                           // calculate the greatest common divisor of numerator  and denominator
        if (gcd > 1 ){                                                                             // gcd(75,100) = 25
            return String.valueOf(numerator.intValue()/gcd) +" / "  + String.valueOf(denominator.intValue()/gcd);  // return 75/25 / 100/25 = 3/4
        }
        else{
            return String.valueOf(numerator) +" / "  + String.valueOf(denominator);              // if gcd = 1 which means nothing to simplify just return numerator / denominator
        }
    }

    private HashMap<String, String> checkScientificFunctions(String string) {
        boolean isLogFound = string.indexOf("log( ") != -1 ? true: false;
        boolean isSinFound = string.indexOf("sin( ") != -1 ? true: false;
        boolean isSqrtFound = string.indexOf("pow( ") != -1 ? true: false;
        boolean isFrFound = string.indexOf("fr( ") != -1 ? true: false;

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
            hashMap.put("pow", string.substring(string.indexOf("pow") + 3, string.length() - 1));
            return hashMap;
        }

        if (isFrFound) {
            Log.i("In substring of chS", "info");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("fr", string.substring(string.indexOf("fr") + 2, string.length() - 1));
            return hashMap;
        }

        Log.i("Out substring of chS", "info");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("default", "null");

        return hashMap;
    }

    public void onLog(View view) {
        numberString = "";
        edit1 = findViewById(R.id.edit1);
        edit1.setText("log( ");
        numberString = "log( " + numberString;
    }

    public void onSin(View view) {
        numberString = "";
        edit1 = findViewById(R.id.edit1);
        edit1.setText("sin( ");
        numberString = "sin( " + numberString;
    }

    public void onPow(View view) {
        numberString = "";
        edit1 = findViewById(R.id.edit1);
        edit1.setText("pow( ");
        numberString = "pow( " + numberString;

    }

    public void onFraction(View view) {
        numberString = "";
        edit1 = findViewById(R.id.edit1);
        edit1.setText("fr( ");
        numberString = "fr( " + numberString;

    }

    /*-----------------------*/
    public void onEquals(View view) {
        String calculations = numberString;
        double ans = 0;
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        if (numberString.length() == 0)
            return;
        try {
            if (switchState) {
                if (numberString.contains("!")) {
                    if (numberString.charAt(numberString.length() - 1) == '!') {
                        int idxOfExclamation = numberString.indexOf("!");
                        String strToParse = numberString.substring(0, idxOfExclamation);
                        int number = Integer.parseInt(strToParse);
                        Log.i(strToParse, "substring");
                        String factorial = FunctionsEvaluator.factorial(number);
                        edit2.setText(factorial);
                        numberString = "";
                        return;
                    } else {
                        throw  new Exception("Invalid String found in Factorial");
                    }
                }
                HashMap<String, String> scientificMap = checkScientificFunctions(numberString);
                if (scientificMap.containsKey("log")) {
                    Log.i("In scientific state", "info");
                    ans = evaluator.evaluate(scientificMap.get("log"));
                    ans = Math.log(ans);
                } else if (scientificMap.containsKey("sin")) {
                    Log.i("In scientific state", "info");
                    ans = evaluator.evaluate(scientificMap.get("sin"));
                    ans = Math.sin(Math.toRadians(ans));
                } else if (scientificMap.containsKey("pow")) {
                    Log.i("In scientific state", "info");
                    String powerExpression = scientificMap.get("pow");
                    powerExpression = powerExpression.substring(2, powerExpression.length() - 2);
                    String[] expArr = powerExpression.split(",");
                    if (expArr.length == 1) {
                        throw new Exception("Invalid Expression");
                    }
                    String x = expArr[0];
                    String y = expArr[1];
                    Log.i("Test", "expressions");
                    Log.i(x + "|" + y, "expressions");
                    Double x1 = evaluator.evaluate(x);
                    Double y1 = evaluator.evaluate(y);
                    ans = Math.pow(x1, y1);
                }
                else if (scientificMap.containsKey("fr")) {
                    Log.i("In scientific state", "info");
                    ans = evaluator.evaluate(scientificMap.get("fr"));
                    String fraction = convertToFraction(ans);
                    edit2.findViewById(R.id.edit2);
                    edit2.setText(fraction);
                    return;
                }
                else {
                    ans = evaluator.evaluate(numberString);
                }

            } else
                ans = evaluator.evaluate(numberString);

            String result = ans + "";
            myDb.insertData(calculations, result);
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
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        if (switchState) {
            gridLayout2.setVisibility(View.VISIBLE);
            params.topMargin = 50;
            gridLayout1.setLayoutParams(params);
            edit1.setText(null);
            edit2.setText(null);
            numberString = "";

        } else {
            edit1.setText(null);
            edit2.setText(null);
            numberString = "";
            gridLayout2.setVisibility(View.GONE);
            params.topMargin = 80;
            gridLayout1.setLayoutParams(params);
        }
    }

    /*Data Base Connectivity*/

    // Create database helper instance
    DatabaseHelper myDb;


    // To display the box
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Closed",
                        Toast.LENGTH_SHORT).show();            }
        });
        builder.show();
    }

    public void onViewHistory(View view) {
        viewHistory();
    }

    public void viewHistory() {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            // no data
            showMessage("Data", "No data found!");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id: " + res.getString(0) + "\n" + " Expression: " + res.getString(1) + "\n" + " Result: " + res.getString(2) + "\n" + " Date: " + res.getString(3) + "\n");
        }

        // Show all the data
        showMessage("History", buffer.toString());
    }

    /*-----------------------*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
    }
}
