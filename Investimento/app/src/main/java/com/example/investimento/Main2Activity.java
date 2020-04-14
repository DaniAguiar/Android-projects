package com.example.investimento;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.investimento.MainActivity.EXTRA_MESSAGE;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        if(parametros != null){
            Double valorMensal = parametros.getDouble("chave_valorMensal");
            Double valorCiclo = parametros.getDouble("chave_valorCiclo");
            Double qtdMesesInvestidos = parametros.getDouble("chave_qtdMesesInvestidos");
            Double qtdMesesCiclo = parametros.getDouble("chave_qtdMesesCiclo");
            Double porcentagemRetorno = parametros.getDouble("chave_porcentagemRetorno");
            Double saldoInicial = parametros.getDouble("chave_saldoInicial");

            carregaLista(
                    valorMensal,
                    valorCiclo,
                    qtdMesesInvestidos,
                    qtdMesesCiclo,
                    porcentagemRetorno,
                    saldoInicial);
        }
    }

    private void carregaLista(
            Double valorMensal,
            Double valorCiclo,
            Double qtdMesesInvestidos,
            Double qtdMesesCiclo,
            Double porcentagemRetorno,
            Double saldoInicial) {

        ListView listResultado = (ListView) findViewById(R.id.listaResultados);
        List<String> listValores = new ArrayList<String>();

        Double saldoFinal = saldoInicial * (saldoInicial*porcentagemRetorno);

        for (int i=1; i<=qtdMesesInvestidos; i++){

            listValores.add("Mês " + i +
                    "\n– Juros sobre Saldo: R$" + (i*porcentagemRetorno) * saldoInicial +
                    "\n– Saldo: " + saldoFinal);

            saldoFinal = saldoFinal * (saldoFinal*(porcentagemRetorno*(i+1)));
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listValores);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listResultado.setAdapter(dataAdapter);
    }

}
