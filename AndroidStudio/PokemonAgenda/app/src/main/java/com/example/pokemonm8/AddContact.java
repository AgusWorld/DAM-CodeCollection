package com.example.pokemonm8;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class AddContact extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_contacte);
        Button AddBtn = (Button) findViewById(R.id.BTNinputAdd);
        Button CancelBtn = (Button) findViewById(R.id.BTNinputCancel);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean nightmode=prefs.getBoolean("checkboxPref",false);
        if(nightmode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        Log.d("NIGHT","BOOLEA DE NIGHTMODE ES->"+nightmode);


        final EditText inputNom=(EditText) findViewById(R.id.inputNomI);
        final EditText inputNum=(EditText) findViewById(R.id.inputPhoneI);
        final Spinner inputGender=(Spinner) findViewById(R.id.inputGenderI);
        final Spinner inputEquip=(Spinner) findViewById(R.id.inputTeamI);


        AddBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                String nom=inputNom.getText().toString();
                String numT=inputNum.getText().toString();
                String genere=inputGender.getSelectedItem().toString();
                String equip=inputEquip.getSelectedItem().toString();
                Intent inData = new Intent();
                inData.putExtra("nom",nom);
                inData.putExtra("numT",numT);
                inData.putExtra("genere",genere);
                inData.putExtra("equip",equip);
                setResult(RESULT_OK, inData);
                finish();
            }
        });



        CancelBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent inData = new Intent();
                setResult(RESULT_CANCELED, inData);
                finish();
            }
        });

    }
}
