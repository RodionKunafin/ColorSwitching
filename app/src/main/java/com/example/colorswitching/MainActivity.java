package com.example.colorswitching;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

import static com.example.colorswitching.R.id.themes;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    Button btnOk;
    TextView textView;
    Spinner themes;
    Button btnOkForThemes;
    String  mLanguage[] = {"ru","en"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        spinner = findViewById(R.id.spinner);
        btnOk = findViewById(R.id.btnOk);
        textView = findViewById(R.id.textView);
        themes = findViewById(R.id.themes);
        btnOkForThemes = findViewById(R.id.btnOkForThemes);
        initSpinner();

        btnOkForThemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (themes.getSelectedItemPosition()){
                    case 0:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                }



            }
        });


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale = new Locale(mLanguage[spinner.getSelectedItemPosition()]);
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                textView.setText(R.string.textView);
                recreate();
            }
        });

    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                String[] languages = getResources().getStringArray(R.array.languages);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapterThemes = ArrayAdapter.createFromResource(this,R.array.themes,android.R.layout.simple_spinner_item);
        adapterThemes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themes.setAdapter(adapterThemes);

        themes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] themes = getResources().getStringArray(R.array.themes);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


}
