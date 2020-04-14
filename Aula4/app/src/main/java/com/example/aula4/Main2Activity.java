package com.example.aula4;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        toolbar.setTitle("Wellcome " + userName);

        TextView textView = findViewById(R.id.textViewUserName);
        textView.setText(userName);
    }

}
