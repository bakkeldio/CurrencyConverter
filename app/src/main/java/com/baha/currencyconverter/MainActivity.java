package com.baha.currencyconverter;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

        CurrencyAdapter arrayAdapter = new CurrencyAdapter(this);
        arrayAdapter.updateData(converter.getCurrents());

        fromSpinner.setAdapter(arrayAdapter);
        toSpinner.setAdapter(arrayAdapter);

        ImageView myImageView =  findViewById(R.id.my_image_view);
        myImageView.setImageResource(R.drawable.thumbnail_tw_20181218080332_7644);



        btConvert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                if (etAmount.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please type an amount", Toast.LENGTH_SHORT).show();
                } else {
                    double result = converter.convert(fromSpinner.getSelectedItem(),
                            toSpinner.getSelectedItem(), Double.valueOf(etAmount.getText().toString()));

                    String text = "%.2f " + converter.getCurrents().get((int) toSpinner.getSelectedItemId()).getName();
                    tvResult.setText(String.format(text, result));
                }
            }
        });
    }
}
