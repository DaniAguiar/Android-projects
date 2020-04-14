package com.example.calculadoraspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputSpinner();
        addButtonCalcClickListener();
    }

    public void inputSpinner(){
        Spinner spOperation = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operation, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spOperation.setAdapter(adapter);
    }

    private void addButtonCalcClickListener() {
        Button buttonCalc = (Button) findViewById(R.id.buttonCalc);
        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtValueA = (EditText) findViewById(R.id.editTextValueA);
                EditText txtValueB = (EditText) findViewById(R.id.editTextValueB);
                Spinner spOperation = (Spinner) findViewById(R.id.spinner);

                String stringValueA = txtValueA.getText().toString();
                String stringValueB = txtValueB.getText().toString();

                int intValueA = Integer.parseInt(stringValueA);
                int intValueB = Integer.parseInt(stringValueB);
                String option = spOperation.getItemAtPosition(spOperation.getSelectedItemPosition()).toString();
                int result = 0;
                
                float floatResult = 0;
                float floatValueA = Float.parseFloat(stringValueA);
                float floatValueB = Float.parseFloat(stringValueB);


                switch (option){
                    case "Somar":
                        result = intValueA + intValueB;
                        Toast.makeText(getApplicationContext(), "Resultado da Soma: " + result, Toast.LENGTH_SHORT).show();
                        break;
                    case "Subtrair":
                        result = intValueA - intValueB;
                        Toast.makeText(getApplicationContext(), "Resultado da Subtração: " + result, Toast.LENGTH_SHORT).show();
                        break;
                    case "Dividir":
                        floatResult = floatValueA / floatValueB;
                        Toast.makeText(getApplicationContext(), "Resultado da Divisão: " + floatResult, Toast.LENGTH_SHORT).show();
                        break;
                    case "Multiplicar":
                        result = intValueA * intValueB;
                        Toast.makeText(getApplicationContext(), "Resultado da Multiplicação: " + result, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
