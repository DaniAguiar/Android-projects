package com.example.aula4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButtonListener();
    }

    private void addButtonListener() {
        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String actualPassword = "root";
                EditText requestPassword = (EditText) findViewById(R.id.password);

                String password = requestPassword.getText().toString();

                if(actualPassword.equals(password))
                    successLogin();
                else
                    Toast.makeText(getApplicationContext(), "Senha Incorreta!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static final String EXTRA_MESSAGE = "com.example.aula4.MESSAGE";

    private void successLogin() {
        Intent intent = new Intent(this,Main2Activity.class);

        EditText editText = (EditText) findViewById(R.id.username);
        String userName = editText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE,userName);

        startActivity(intent);
    }
}
