package com.example.androidstyles_colors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner languagesSpinner;
    private Spinner colorsSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        languagesSpinner = findViewById(R.id.language);
        colorsSpinner = findViewById(R.id.spinner_color);

    }

    public void onClick(View v) {
        String selected = languagesSpinner.getSelectedItem().toString();

        if (selected.equals("Английский")) {
            Locale locale = new Locale("en");
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            recreate();
        }

        if (selected.equals("Russian")) {
            Locale locale = new Locale("ru");

            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            recreate();
        }
    }

    public void changeTheme(View v) {
        String selected = colorsSpinner.getSelectedItem().toString();

        switch (selected) {
            case "Черный":
                Utils.changeToTheme(this, Utils.THEME_BLACK);
                break;
            case "Синий":
                Utils.changeToTheme(this, Utils.THEME_BLUE);
                break;
            case "Зеленый":
                Utils.changeToTheme(this, Utils.THEME_GREEN);
                break;
        }
    }
}

