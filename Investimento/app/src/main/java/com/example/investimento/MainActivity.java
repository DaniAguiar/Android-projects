package com.example.investimento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButtonCalcInvestimento();
    }

    private void addButtonCalcInvestimento() {
        Button buttonCalc = (Button) findViewById(R.id.buttonCalc);
        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText textvalorMensal = (EditText) findViewById(R.id.editTextValorMensal);
                Double valorMensal = ServiceConversor.conversor(textvalorMensal);

                EditText textvalorCiclo = (EditText) findViewById(R.id.editTextValorCiclo);
                Double valorCiclo = ServiceConversor.conversor(textvalorCiclo);

                EditText textMesesInvestidos = (EditText) findViewById(R.id.editTextMesesInvestidos);
                Double qtdMesesInvestidos = ServiceConversor.conversor(textMesesInvestidos);

                EditText textMesesCiclo = (EditText) findViewById(R.id.editTextMesesCiclo);
                Double qtdMesesCiclo = ServiceConversor.conversor(textMesesCiclo);

                EditText textPorcentagemRetorno = (EditText) findViewById(R.id.editTextPorcentagemRetorno);
                Double porcentagemRetorno = ServiceConversor.conversor(textPorcentagemRetorno);

                EditText textSaldoInicial = (EditText) findViewById(R.id.editTextSaldoInicial);
                Double saldoInicial = ServiceConversor.conversor(textSaldoInicial);

                abrirSegundaAtividade(
                        valorMensal,
                        valorCiclo,
                        qtdMesesInvestidos,
                        qtdMesesCiclo,
                        porcentagemRetorno,
                        saldoInicial);
            }
        });
    }

    public static final String EXTRA_MESSAGE = "com.example.investimento.MESSAGE";

    private void abrirSegundaAtividade(
            Double valorMensal,
            Double valorCiclo,
            Double qtdMesesInvestidos,
            Double qtdMesesCiclo,
            Double porcentagemRetorno,
            Double saldoInicial) {

        Intent intent = new Intent(this,Main2Activity.class);
        Bundle parametros = new Bundle();

        parametros.putDouble("chave_valorMensal", valorMensal);
        parametros.putDouble("chave_valorCiclo", valorCiclo);
        parametros.putDouble("chave_qtdMesesInvestidos", qtdMesesInvestidos);
        parametros.putDouble("chave_qtdMesesCiclo", qtdMesesCiclo);
        parametros.putDouble("chave_porcentagemRetorno", porcentagemRetorno);
        parametros.putDouble("chave_saldoInicial", saldoInicial);

        intent.putExtras(parametros);

        startActivity(intent);
    }
}
