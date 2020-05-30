package com.example.covidregister;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.BaseColumns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);

        Intent intent = getIntent();
        String intentCPF = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        DBCreation dbHelper = new DBCreation(getBaseContext());

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                DBCreation.NOME,
                DBCreation.CPF,
                DBCreation.DIAGNOSTICO,
                DBCreation.CIDADE,
        };

        String where = DBCreation.CPF + " = " + intentCPF;

        Cursor cursor = db.query(
                DBCreation.TABELA,
                projection,
                where,
                null,
                null,
                null,
                null);

        String name = "";
        String cpf = "";
        String diagnostico = "";
        String cidade = "";

        while(cursor.moveToNext()) {
            name = cursor.getString(1);
            cpf = cursor.getString(2);
            diagnostico = cursor.getString(3);
            cidade = cursor.getString(4);
        }

        EditText editTextName = (EditText) findViewById(R.id.editNameLogin);
        editTextName.setText(name);

        EditText editTextCPF = (EditText) findViewById(R.id.editCPFLogin);
        editTextCPF.setText(cpf);

        RadioButton radioButtonPositivo = (RadioButton) findViewById(R.id.radioButtonPLogin);
        RadioButton radioButtonNegativo = (RadioButton) findViewById(R.id.radioButtonNLogin);

        if(diagnostico.equals("positivo")){
            radioButtonPositivo.setChecked(true);
            radioButtonNegativo.setChecked(false);
        }
        else{
            radioButtonPositivo.setChecked(false);
            radioButtonNegativo.setChecked(true);
        }

        inputSpinner();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        switch (cidade){
            case "Araraquara": spinner.setSelection(0);
                break;
            case "Matão": spinner.setSelection(1);
                break;
            case "São Paulo": spinner.setSelection(2);
                break;
            case "São Carlos": spinner.setSelection(3);
                break;
        }

        addButtonAlterar();
        addButtonDeletar();
    }

    private void addButtonDeletar() {
        Button buttonDeletar = (Button) findViewById(R.id.buttonDeletar);
        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editCPF = (EditText) findViewById(R.id.editCPFLogin);
                String cpf = editCPF.getText().toString();

                DBController dbController =  new DBController(getBaseContext());
                dbController.deletarRegistro(cpf);

                Toast.makeText(getApplicationContext(), "Registro Deletado!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addButtonAlterar() {
        Button buttonAlterar = (Button) findViewById(R.id.buttonAlterar);
        buttonAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editName = (EditText) findViewById(R.id.editNameLogin);
                EditText editCPF = (EditText) findViewById(R.id.editCPFLogin);
                RadioButton positivoCovid = (RadioButton) findViewById(R.id.radioButtonPLogin);
                Spinner spinnerCidade = (Spinner) findViewById(R.id.spinner);

                String nome = editName.getText().toString();
                String cpf = editCPF.getText().toString();
                String cidade = spinnerCidade.getSelectedItem().toString();
                String diagnostico;

                if(positivoCovid.isChecked())
                    diagnostico = "positivo";
                else
                    diagnostico = "negativo";

                DBController dbController =  new DBController(getBaseContext());
                dbController.alteraRegistro(nome, cpf, cidade, diagnostico);

                Toast.makeText(getApplicationContext(), "Registro Alterado!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void inputSpinner() {
        Spinner spOperation = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cidade, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spOperation.setAdapter(adapter);
    }

}
