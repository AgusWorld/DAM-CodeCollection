package com.example.pokemonm8;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class ShowPrefs extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_prefs);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean nightmode=prefs.getBoolean("checkboxPref",false);
        if(nightmode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        Log.d("NIGHT","BOOLEA DE NIGHTMODE ES->"+nightmode);


        TextView text1 = (TextView)findViewById(R.id.textview1);
        TextView text2 = (TextView)findViewById(R.id.textview2);
        TextView text3 = (TextView)findViewById(R.id.textview3);
        //TextView text4 = (TextView)findViewById(R.id.textView4);

        text1.setText("DARK -> "+new Boolean(prefs.getBoolean("checkboxPref", false)).toString());
        text2.setText("N -> "+prefs.getString("editTextPref", "<unset>").toString());;
        text3.setText("S/M/L -> "+prefs.getString("listPref", "<unset>").toString());
        //text4.setText(prefs.getString("VALOR", "null"));



    }


}
