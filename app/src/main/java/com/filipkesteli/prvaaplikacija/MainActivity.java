package com.filipkesteli.prvaaplikacija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String PARAMETER_SMALLER = "parameter_smaller";
    public static final String PARAMETER_BIGGER = "parameter_bigger";

    private EditText etFirst;
    private EditText etSecond;
    private Button btnBigger;
    private Button btnSmaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();

        registerContextMenu();
    }

    private void registerContextMenu() {
        registerForContextMenu(etFirst);
        registerForContextMenu(etSecond);
    }

    private void initWidgets() {
        etFirst = (EditText) findViewById(R.id.etFirst);
        etSecond = (EditText) findViewById(R.id.etSecond);
        btnBigger = (Button) findViewById(R.id.btnBigger);
        btnSmaller = (Button) findViewById(R.id.btnSmaller);
    }

    private void setupListeners() {
        btnBigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBigger();
            }
        });
        btnSmaller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSmaller();
            }
        });
    }

    private int bigger;
    private int smaller;

    private void sendBigger() {
        editTextMethod();

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(PARAMETER_BIGGER, bigger);
        startActivity(intent);
    }

    private void sendSmaller() {
        editTextMethod();

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(PARAMETER_SMALLER, smaller);
        startActivity(intent);
    }

    private void editTextMethod() {
        int first = Integer.parseInt(etFirst.getText().toString());
        int second = Integer.parseInt(etSecond.getText().toString());
        smaller = first;
        bigger = second;
        if (first > second) {
            bigger = first;
            smaller = second;
        }
    }

    private EditText etSelected;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        etSelected = (EditText) v;

        menu.setHeaderTitle(R.string.choose);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.miDelete:
                etSelected.setText("");
                return true;
            case R.id.miCancel:
                return true;
        }

        return super.onContextItemSelected(item);
    }
}