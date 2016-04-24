package com.filipkesteli.prvaaplikacija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    private EditText etResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initWidgets();
        handleIntent();
    }

    private void initWidgets() {
        etResult = (EditText) findViewById(R.id.etResult);
    }

    private void handleIntent() {
        int number = 0;
        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.PARAMETER_SMALLER)) {
            number = intent.getIntExtra(MainActivity.PARAMETER_SMALLER, 0);
        }
        if (intent.hasExtra(MainActivity.PARAMETER_BIGGER)) {
            number = intent.getIntExtra(MainActivity.PARAMETER_BIGGER, 0);
        }
        etResult.setText(number+"");
    }
}