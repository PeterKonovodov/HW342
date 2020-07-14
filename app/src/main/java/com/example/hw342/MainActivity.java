package com.example.hw342;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner languageSpinner;
    private Spinner themeSpinner;
    Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        languageSpinner = findViewById(R.id.languagesSpinner);
        themeSpinner = findViewById(R.id.themeSpinner);
        okBtn = findViewById(R.id.okBtn);
        initLangSpinner();
        initThemeSpinner();
        initBtnListener(this, okBtn);


    }

    private void initLangSpinner() {
        ArrayAdapter<CharSequence> adapterLangs = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterLangs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapterLangs);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initThemeSpinner() {
        ArrayAdapter<CharSequence> adapterLangs = ArrayAdapter.createFromResource(this, R.array.themes, android.R.layout.simple_spinner_item);
        adapterLangs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themeSpinner.setAdapter(adapterLangs);

        themeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initBtnListener(final Activity activity, Button button) {

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale;
                if (languageSpinner.getSelectedItemPosition() == 1)
                    locale = new Locale("ru");
                else locale = new Locale("en");

                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                int pos = themeSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 1:
                        Utils.changeToTheme(activity, Utils.THEME_MARGIN_MIDDLE);
                        break;
                    case 2:
                        Utils.changeToTheme(activity, Utils.THEME_MARGIN_SMALL);
                        break;
                    default:
                        Utils.changeToTheme(activity, Utils.THEME_DEFAULT);
                        break;
                }

            }
        };

        button.setOnClickListener(onClickListener);
    }


}