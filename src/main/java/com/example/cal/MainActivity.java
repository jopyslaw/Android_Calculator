package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    private Boolean isResult = false; // variable that check if equal button was clicked
    private Boolean toEnd = false; // variable that contains if end bracket is needed
    private Boolean isZero = false; // variable that contains if zero is shown on screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        TextView text = findViewById(R.id.textView);
        outState.putString("RESULT", text.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        TextView text = findViewById(R.id.textView);
        String res = savedInstanceState.getString("RESULT","0");
        text.setText(res);
    }


    public void Calculate(View view) {
        TextView text = findViewById(R.id.textView);
        checkIfZero(text);
        clearResult(text);
        switch(view.getId())
        {
            case R.id.button://AC
                text.setText("0");
                break;
            case R.id.button2:// +/-
                text.append("-");
                break;
            case R.id.button3:// %
                text.append("%");
                break;
            case R.id.button4:// /
                text.append(" / ");
                break;
            case R.id.button5:// 7
                text.append("7");
                break;
            case R.id.button6:// 8
                text.append("8");
                break;
            case R.id.button7:// 9
                text.append("9");
                break;
            case R.id.button8:// *
                text.append(" * ");
                break;
            case R.id.button9:// 4
                text.append("4");
                break;
            case R.id.button10:// 5
                text.append("5");
                break;
            case R.id.button11:// 6
                text.append("6");
                break;
            case R.id.button12:// -
                text.append(" - ");
                break;
            case R.id.button13:// 1
                text.append("1");
                break;
            case R.id.button14:// 2
                text.append("2");
                break;
            case R.id.button15:// 3
                text.append("3");
                break;
            case R.id.button16:// +
                text.append(" + ");
                break;
            case R.id.button17:// 0
                text.append("0");
                break;
            case R.id.button18:
                break;
            case R.id.button19: // ,
                if(isZero == true)
                    text.append("0");
                text.append(".");
                isZero = false;
                break;
            case R.id.button20:// =
                if(toEnd == true)
                {
                    text.append(")");
                    toEnd = false;
                }
                Expression exp = new Expression(text.getText().toString());
                Double result  = exp.calculate();
                text.setText(result.toString());
                isResult = true;
                break;
            case R.id.button21:// log10
                text.append("log10(");
                toEnd = true;
                break;
            case R.id.button22:// x!
                text.append("!");
                break;
            case R.id.button23:// sqrt
                text.append("sqrt(");
                toEnd = true;
                break;
            case R.id.button24:// x^3
                text.append("^3");
                break;
            case R.id.button25:// x^2
                text.append("^2");
                break;
            default:
                break;
        }
    }

    private void checkIfZero(TextView view) // method that check if zero is display on screen and if its true then display is going to be cleared
    {
        if(view.getText().toString().matches("0"))
        {
            view.setText("");
            isZero = true;
        }
    }

    private void clearResult(TextView view) // method that check if result was display on screen and if it was then screen gonna by cleared
    {
        if(isResult == true)
        {
            view.setText("");
            isResult = false;
        }
    }


}