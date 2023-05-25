package com.example.bocchicalcu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView information;
    private TextView result;
    private Button btnParenthesesLeft, btnParenthesesRight, btnPercentage, btn7, btn8, btn9, btn4, btn5, btn6,
            btn1, btn2, btn3, btn0, btnDecimal, btnEqual, btnPlus, btnMinus, btnMultiply, btnDivide, btnClear;

    private final char ADDITION = '+';
    private final char DIVISION = '/';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char EQU = 0;

    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        btn0.setOnClickListener(view -> information.setText(information.getText().toString() + "0"));
        btn1.setOnClickListener(view -> information.setText(information.getText().toString() + "1"));
        btn2.setOnClickListener(view -> information.setText(information.getText().toString() + "2"));
        btn3.setOnClickListener(view -> information.setText(information.getText().toString() + "3"));
        btn4.setOnClickListener(view -> information.setText(information.getText().toString() + "4"));
        btn5.setOnClickListener(view -> information.setText(information.getText().toString() + "5"));
        btn6.setOnClickListener(view -> information.setText(information.getText().toString() + "6"));
        btn7.setOnClickListener(view -> information.setText(information.getText().toString() + "7"));
        btn8.setOnClickListener(view -> information.setText(information.getText().toString() + "8"));
        btn9.setOnClickListener(view -> information.setText(information.getText().toString() + "9"));
        btnPlus.setOnClickListener(view -> information.setText(information.getText().toString() + "+"));
        btnParenthesesLeft.setOnClickListener(view -> information.setText(information.getText().toString() + "("));
        btnParenthesesRight.setOnClickListener(view -> information.setText(information.getText().toString() + ")"));
        btnPercentage.setOnClickListener(view -> information.setText(information.getText().toString() + "%"));


        btnPlus.setOnClickListener(view -> {
            compute();
            ACTION = ADDITION;
            result.setText(val1 + "+");
            information.setText("");
        });
        btnMinus.setOnClickListener(view -> {
            compute();
            ACTION = SUBTRACTION;
            result.setText(val1 + "-");
            information.setText("");
        });
        btnMultiply.setOnClickListener(view -> {
            compute();
            ACTION = MULTIPLICATION;
            result.setText(val1 + "*");
            information.setText("");
        });
        btnDivide.setOnClickListener(view -> {
            compute();
            ACTION = MULTIPLICATION;
            result.setText(val1 + "/");
            information.setText("");
        });

        btnEqual.setOnClickListener(new View.OnClickListener()   {
            @Override

            public void onClick(View v) {
                compute();
                ACTION = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                information.setText(null);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener()   {
            @Override

            public void onClick(View v) {
                if(information.getText().length()>0) {
                    CharSequence name = information.getText().toString();
                    information.setText(name.subSequence(0, name.length() - 1));
                }
                else
                {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    information.setText(null);
                    result.setText(null);
                }
            }
        });
    }



    private void setupUIViews(){


        information = findViewById(R.id.bocchiInfo);
        result = findViewById(R.id.bocchiAnswer);
        btnParenthesesLeft = findViewById(R.id.bPL);
        btnParenthesesRight = findViewById(R.id.bPR);
        btnPercentage = findViewById(R.id.bP);
        btn9 = findViewById(R.id.b9);
        btn8 = findViewById(R.id.b8);
        btn7 = findViewById(R.id.b7);
        btn6 = findViewById(R.id.b6);
        btn5 = findViewById(R.id.b5);
        btn4 = findViewById(R.id.b4);
        btn3 = findViewById(R.id.b3);
        btn2 = findViewById(R.id.b2);
        btn1 = findViewById(R.id.b1);
        btn0 = findViewById(R.id.b0);
        btnDecimal = findViewById(R.id.bD);
        btnEqual = findViewById(R.id.bE);
        btnPlus = findViewById(R.id.bPlus);
        btnMinus = findViewById(R.id.bMinus);
        btnMultiply = findViewById(R.id.bMultiply);
        btnDivide = findViewById(R.id.bDivide);
        btnClear = findViewById(R.id.bClear);





    }
    private void compute() {
        try {
            String input = information.getText().toString().trim();
            if (!input.isEmpty()) {
                val2 = Double.parseDouble(input);

                if (!Double.isNaN(val1)) {
                    switch (ACTION) {
                        case ADDITION:
                            val1 += val2;
                            break;
                        case SUBTRACTION:
                            val1 -= val2;
                            break;
                        case MULTIPLICATION:
                            val1 *= val2;
                            break;
                        case DIVISION:
                            val1 /= val2;
                            break;
                        case EQU:
                            break;
                    }
                } else {
                    val1 = val2;
                }
            } else {
                result.setText("Invalid input");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            result.setText("Invalid input");
        }
    }

    @Override
    public void onClick(View view) {

    }
}





