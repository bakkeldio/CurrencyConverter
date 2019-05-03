package com.baha.currencyconverter;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner fromSpinner;
    private Spinner toSpinner;
    private Button btConvert;
    private TextView tvResult;

    private EditText etAmount;
    private Converter converter;

    private void init() {

        fromSpinner = findViewById(R.id.formSpinner);
        toSpinner = findViewById(R.id.toSpinner);
        btConvert = findViewById(R.id.btConvert);
        tvResult = findViewById(R.id.tvResult);
        etAmount = findViewById(R.id.etAmount);

        converter = new Converter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,  android.R.layout.simple_spinner_item, converter.getCurrents());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(arrayAdapter);
        toSpinner.setAdapter(arrayAdapter);
        

        btConvert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                double result = converter.convert(fromSpinner.getSelectedItem().toString(),
                        toSpinner.getSelectedItem().toString(), Double.valueOf(etAmount.getText().toString()));

                String text = "%.2f " + toSpinner.getSelectedItem().toString();
                tvResult.setText(String.format(text, result));
            }
        });
    }

}
