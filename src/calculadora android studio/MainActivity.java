package com.parcial.programacion_aplicaciones_moviles_calculadora_simple;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private float num1, num2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = findViewById(R.id.add);
        Button subtract = findViewById(R.id.subtract);
        Button multiply = findViewById(R.id.multiply);
        Button divide = findViewById(R.id.divide);

        add.setOnClickListener(this::onClickSum);
        subtract.setOnClickListener(this::onClickSubtract);
        multiply.setOnClickListener(this::onClickMultiply);
        divide.setOnClickListener(this::onClickDivide);

    }

    @SuppressLint("SetTextI18n")
    public boolean getNumbers() {
        EditText txtNum1 = findViewById(R.id.num1);
        EditText txtNum2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        String s1 = txtNum1.getText().toString();
        String s2 = txtNum2.getText().toString();

        if (s1.equals("") && s2.equals("")) {
            result.setText("Ingrese los números necesarios para la operación");
            return false;
        }

        if (s1.equals("")) {
            result.setText("Ingrese el número 1");
            return false;
        }

        if (s2.equals("")) {
            result.setText("Ingrese el número 2");
            return false;
        }

        num1 = Float.parseFloat(s1);
        num2 = Float.parseFloat(s2);

        return true;
    }

    @SuppressLint("SetTextI18n")
    public void onClickSum(View view) {

        if (getNumbers()) {
            result.setText(Float.toString(num1 + num2));
        }

    }

    @SuppressLint("SetTextI18n")
    public void onClickSubtract(View view) {

        if (getNumbers()) {
            result.setText(Float.toString(num1 - num2));
        }

    }

    @SuppressLint("SetTextI18n")
    public void onClickMultiply(View view) {

        if (getNumbers()) {
            result.setText(Float.toString(num1 * num2));
        }

    }

    @SuppressLint("SetTextI18n")
    public void onClickDivide(View view) {

        if (Objects.equals(num2, 0.0f)) {
            result.setText("No se puede dividir entre 0");
        }

        if (getNumbers() & !Objects.equals(num2, 0.0f)) {
            result.setText(Float.toString(num1 / num2));
        }

    }

}