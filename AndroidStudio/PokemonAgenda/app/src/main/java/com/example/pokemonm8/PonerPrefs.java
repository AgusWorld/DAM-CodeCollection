package com.example.pokemonm8;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class PonerPrefs extends PreferenceActivity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void UpdateTheme(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean nightmode=prefs.getBoolean("checkboxPref",false);
        if(nightmode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        Log.d("NIGHT","BOOLEA DE NIGHTMODE ES->"+nightmode);
    }








}
