package com.example.investimento;

import android.widget.EditText;

public class ServiceConversor {

    public static Double conversor(EditText textvalorMensal) {
        String getString = textvalorMensal.getText().toString();
        Double convertToDouble = Double.parseDouble(getString);
        return convertToDouble;
    }
}
