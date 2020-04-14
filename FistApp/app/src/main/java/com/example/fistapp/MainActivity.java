package com.example.fistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButtonSomaClickListener();
    }

    private void addButtonSomaClickListener() {
        Button btnSoma = (Button) findViewById(R.id.btnSoma);
        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtValorA = (EditText) findViewById(R.id.txtValorA);
                EditText txtValorB = (EditText) findViewById(R.id.txtValorB);

                String valorA = txtValorA.getText().toString();
                String valorB = txtValorB.getText().toString();

                int intValorA = Integer.parseInt(valorA);
                int intValorB = Integer.parseInt(valorB);

                int resultado = intValorA + intValorB;

                Toast.makeText(getApplicationContext(), "Resultado da soma: " + resultado, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSubtracao = (Button) findViewById(R.id.btnSubtracao);
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtValorA = (EditText) findViewById(R.id.txtValorA);
                EditText txtValorB = (EditText) findViewById(R.id.txtValorB);

                String valorA = txtValorA.getText().toString();
                String valorB = txtValorB.getText().toString();

                int intValorA = Integer.parseInt(valorA);
                int intValorB = Integer.parseInt(valorB);

                int resultado = intValorA - intValorB;

                Toast.makeText(getApplicationContext(), "Resultado da subtração: " + resultado, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnMultiplicacao = (Button) findViewById(R.id.btnMultiplicacao);
        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtValorA = (EditText) findViewById(R.id.txtValorA);
                EditText txtValorB = (EditText) findViewById(R.id.txtValorB);

                String valorA = txtValorA.getText().toString();
                String valorB = txtValorB.getText().toString();

                int intValorA = Integer.parseInt(valorA);
                int intValorB = Integer.parseInt(valorB);

                int resultado = intValorA * intValorB;

                Toast.makeText(getApplicationContext(), "Resultado da multiplicação: " + resultado, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnDivisao = (Button) findViewById(R.id.btnDivisao);
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtValorA = (EditText) findViewById(R.id.txtValorA);
                EditText txtValorB = (EditText) findViewById(R.id.txtValorB);

                String valorA = txtValorA.getText().toString();
                String valorB = txtValorB.getText().toString();

                float intValorA = Float.parseFloat(valorA);
                float intValorB = Float.parseFloat(valorB);

                float resultado = intValorA / intValorB;

                Toast.makeText(getApplicationContext(), "Resultado da divisão" +
                        ": " + resultado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
