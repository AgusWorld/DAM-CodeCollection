package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String num1String="N/A";
    private String num2String="N/A";
    private Double result=0.0;
    private String operacio="N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultHerePLS = (TextView) findViewById(R.id.resultHerePLS);
        Button bCE = (Button) findViewById(R.id.bCE);
        Button bC = (Button) findViewById(R.id.bC);
        Button bBorrar = (Button) findViewById(R.id.bBorrar);
        Button bDivision = (Button) findViewById(R.id.bDivision);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);
        Button bPor = (Button) findViewById(R.id.bPor);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button bMenos = (Button) findViewById(R.id.bMenos);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button bMas = (Button) findViewById(R.id.bMas);
        Button bMasMenos = (Button) findViewById(R.id.bMasMenos);
        Button b0 = (Button) findViewById(R.id.b0);
        Button bComa = (Button) findViewById(R.id.bComa);
        Button bIgual = (Button) findViewById(R.id.bIgual);


        View.OnClickListener dumbo = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1String.equals("N/A")){
                    num1String=((TextView)view).getText().toString();
                    resultHerePLS.setText(num1String);
                }else if(operacio.equals("N/A")){
                    num1String+=((TextView)view).getText().toString();
                    resultHerePLS.setText(num1String);
                }else{
                    if(num2String.equals("N/A")){
                        num2String=((TextView)view).getText().toString();
                    }else {
                        num2String+=((TextView)view).getText().toString();
                    }
                    resultHerePLS.setText(num2String);
                }

            }
        };
        View.OnClickListener MaxiOreja  = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getResources().getResourceEntryName(view.getId())){

                    case "bIgual":
                        if(!num1String.equals("N/A") && !num2String.equals("N/A") && !operacio.isEmpty()){
                            Double num1=Double.parseDouble(num1String);
                            Double num2=Double.parseDouble(num2String);
                            result=0.0;
                            switch (operacio){
                                case "bDivision":
                                    result=num1/num2;
                                    break;
                                case "bPor":
                                    result=num1*num2;
                                    break;
                                case "bMenos":
                                    result=num1-num2;
                                    break;
                                case "bMas":
                                    result=num1+num2;
                                    break;
                            }
                            num1String=result.toString();
                            num2String="N/A";
                            resultHerePLS.setText(result.toString());

                        }
                        break;
                    case "bComa":
                        if(num2String.equals("N/A") && !num1String.contains(".")){
                            num1String+=".";
                            resultHerePLS.setText(num1String);
                        }else if(!num2String.equals("N/A") && !num2String.contains(".")){
                            num2String+=".";
                            resultHerePLS.setText(num2String);
                        }
                        break;
                    case "bBorrar":
                        if(!num2String.equals("N/A") && !num2String.isEmpty()){
                            num2String=num2String.substring(0,num2String.length()-1);
                            resultHerePLS.setText(num2String);
                        }else if(!num1String.equals("N/A") && !num1String.isEmpty()){
                            num1String=num1String.substring(0,num1String.length()-1);
                            resultHerePLS.setText(num1String);
                        }
                        break;
                    case "bMasMenos":
                        if(!num2String.equals("N/A") && !num2String.isEmpty()){
                            if(num2String.charAt(0)=='-'){
                                num2String=num2String.substring(1);
                            }else{
                                num2String="-"+num2String;
                            }
                            resultHerePLS.setText(num2String);
                        }else if(!num1String.equals("N/A") && !num1String.isEmpty()){
                            if(num1String.charAt(0)=='-'){
                                num1String=num1String.substring(1);
                            }else{
                                num1String="-"+num1String;
                            }
                            resultHerePLS.setText(num1String);
                        }
                        break;
                    case "bCE":
                        if(!num2String.equals("N/A")){
                            num2String="N/A";
                            resultHerePLS.setText("0");
                        }else if(!num1String.equals("N/A")){
                            num1String="N/A";
                            resultHerePLS.setText("0");
                        }
                        break;
                    case "bC":
                        num1String="N/A";
                        num2String="N/A";
                        result=0.0;
                        operacio="N/A";
                        resultHerePLS.setText(result.toString());
                        break;
                    default:
                        operacio=view.getResources().getResourceEntryName(view.getId());
                        break;

                }
            }
        };
        bCE.setOnClickListener(MaxiOreja);
        bC.setOnClickListener(MaxiOreja);
        bBorrar.setOnClickListener(MaxiOreja);
        bDivision.setOnClickListener(MaxiOreja);
        b7.setOnClickListener(dumbo);
        b8.setOnClickListener(dumbo);
        b9.setOnClickListener(dumbo);
        bPor.setOnClickListener(MaxiOreja);
        b4.setOnClickListener(dumbo);
        b5.setOnClickListener(dumbo);
        b6.setOnClickListener(dumbo);
        bMenos.setOnClickListener(MaxiOreja);
        b1.setOnClickListener(dumbo);
        b2.setOnClickListener(dumbo);
        b3.setOnClickListener(dumbo);
        bMas.setOnClickListener(MaxiOreja);
        bMasMenos.setOnClickListener(MaxiOreja);
        b0.setOnClickListener(dumbo);
        bComa.setOnClickListener(MaxiOreja);
        bIgual.setOnClickListener(MaxiOreja);


    }

}