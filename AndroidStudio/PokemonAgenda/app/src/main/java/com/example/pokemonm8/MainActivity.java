package com.example.pokemonm8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AdapterContact myAdapter;
    ArrayList<Contacte> listaContactes = new ArrayList<>();

    private int CLICKAT=-1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){ //SET NEW IMAGE TO CONTACT
            if(resultCode == RESULT_OK && data!=null  && CLICKAT!=-1){
                Uri image = data.getData();
                //String num=data.getStringExtra("arg2").toString();
                //int posicio=Integer.parseInt(num);
                //Log.e("NUMERO","EL NUMERO ES -> "+posicio);
                listaContactes.get(CLICKAT).setImagePFP(image);
                myAdapter.notifyDataSetChanged();

                ContactBBDD miAgenda = new ContactBBDD(this, "Agenda", null, 1);
                SQLiteDatabase db =  miAgenda.getWritableDatabase();
                if(db!=null)
                    db.execSQL("UPDATE Agenda SET PFP='" +image.toString()+ "' WHERE id=" +listaContactes.get(CLICKAT).getId());

                miAgenda.close();
                db.close();
                CLICKAT=-1;
            }
       }else if(requestCode==2 ){// ADD CONTACT
            if(resultCode == RESULT_OK && data!=null){
                String theName=data.getStringExtra("nom");
                String theNumber=data.getStringExtra("numT");
                String genere=data.getStringExtra("genere");
                Gender theGender;
                String equip=data.getStringExtra("equip");
                Team theTeam;

                switch (genere){
                    case "Home":
                        theGender=Gender.HOME;
                        break;
                    case "Dona":
                        theGender=Gender.DONA;
                        break;
                    case "Altre":
                        theGender=Gender.ALTRE;
                        break;
                    default:
                        theGender=Gender.ALTRE;
                }
                switch (equip){
                    case "Valor":
                        theTeam=Team.Valor;
                        break;
                    case "Mystic":
                        theTeam=Team.Mystic;
                        break;
                    case "Instinct":
                        theTeam=Team.Instinct;
                        break;
                    default:
                        theTeam=Team.Instinct;
                }


                ContactBBDD miAgenda = new ContactBBDD(this, "Agenda", null, 1);
                SQLiteDatabase db =  miAgenda.getWritableDatabase();
                Cursor cursor2 = db.rawQuery("SELECT MAX(id) FROM Agenda",null);
                int idF=100;
                if (cursor2!= null && cursor2.moveToFirst())
                {
                    idF=cursor2.getInt(0);

                    Log.w("INFO MIA","EL CURSOR MAS GRANDE ES "+idF);
                    idF++;
                }
                db.execSQL("INSERT INTO Agenda (id,Nom,Num_Telefon,Gender,Team) VALUES ("+idF+",'" +theName+ "','" +theNumber+ "','" +genere+ "','" +equip+ "')");
                listaContactes.add(new Contacte(idF,theName,theNumber,theGender,theTeam));
                myAdapter.notifyDataSetChanged();
                Log.w("INFO MIA","METO NUEVO REGISTRO CON ID: "+idF);
                miAgenda.close();
                db.close();
            }

        }
        UpdateTheme();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UpdateTheme();



        Button editPrefs = (Button) findViewById(R.id.prefButton);
        editPrefs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PonerPrefs.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button showPrefs = (Button) findViewById(R.id.showButton);
        showPrefs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ShowPrefs.class);
                startActivityForResult(myIntent, 0);
            }
        });


        ContactBBDD miAgenda = new ContactBBDD(this, "Agenda", null, 1);
        SQLiteDatabase db =  miAgenda.getWritableDatabase();

        //Si la BBDD no es null hacemos cositas
        if(db!=null){

            //En este ejemplo se insertan 5 valores nuevos relllenando todas la columnas
//            for(int i=1;i<=5;i++){
//                String nom = "Nom"+i;
//                String nTelefon = ""+((int) (Math.random() * 6731288));
//                String gender = "H";
//                String team = "V";
//                db.execSQL("INSERT INTO Agenda (Nom,Num_Telefon,Gender,Team) VALUES ('" +nom+ "','" +nTelefon+ "','" +gender+ "','" +team+ "')");
//            }

            //aqui creamos un cursor
            Cursor cursor1 = db.rawQuery("SELECT * FROM AGENDA",null);

            int theID;
            String theName;
            String theNumber;
            Gender theGender;
            Team theTeam;

            if (cursor1!= null && cursor1.moveToFirst())
            {
                do {
                    theID=cursor1.getInt(0);
                    theName=cursor1.getString(1);
                    theNumber=cursor1.getString(2);
                    switch (cursor1.getString(4)){
                        case "H":
                            theGender=Gender.HOME;
                            break;
                        case "D":
                            theGender=Gender.DONA;
                            break;
                        case "A":
                            theGender=Gender.ALTRE;
                            break;
                        default:
                            theGender=Gender.ALTRE;
                    }
                    switch (cursor1.getString(5)){
                        case "V":
                            theTeam=Team.Valor;
                            break;
                        case "M":
                            theTeam=Team.Mystic;
                            break;
                        case "I":
                            theTeam=Team.Instinct;
                            break;
                        default:
                            theTeam=Team.Instinct;
                    }
                    String pic = cursor1.getString(3);
                    if(pic==null)
                        listaContactes.add(new Contacte(theID,theName,theNumber,theGender,theTeam));
                    else{
                        Uri thePic= Uri.parse(pic);
                        listaContactes.add(new Contacte(theID,theName,theNumber,thePic,theGender,theTeam));
                        Log.e("FOTO","tENGO UNA FOTO!!!!!!!!!");
                    }


                } while (cursor1.moveToNext());

            }

            for (Contacte c:listaContactes) {

                Log.d("CONTACTO -> ",c.toString());
            }

        }

        myAdapter = new AdapterContact(this);
        ListView listaContactesView = (ListView) findViewById(R.id.listViewContactes);
        listaContactesView.setAdapter(myAdapter);

        //CLICK LISTENER DELS CONTACTES A LA LLISTA && GUARDA POSICIO DEL CLICKAT
        listaContactesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                CLICKAT=arg2;
                startActivityForResult(intent,1);
            }
        });

        //CLICK LISTENER DE ADD CONTACT BUTTON
        Button addContactButton = (Button) findViewById(R.id.addContactButtonMain);
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),AddContact.class);
                startActivityForResult(intent2,2);
            }
        });

        //CLICK LISTENER DE DELETE TABLE BUTTON
        Button deleteAllTableBtn = (Button) findViewById(R.id.deleteAllButtonMain);
        deleteAllTableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteAllMiami();
                listaContactes.clear();
                myAdapter.notifyDataSetChanged();
            }
        });


    }

    //BORRA LA TABLA AGENDA Y CREA UNA NUEVA
    public void DeleteAllMiami(){
        ContactBBDD miAgenda = new ContactBBDD(this, "Agenda", null, 1);
        SQLiteDatabase db =  miAgenda.getWritableDatabase();
        db.execSQL("DELETE FROM AGENDA WHERE ID >0");
//        db.execSQL("DROP TABLE Agenda");
//        db.execSQL("CREATE TABLE agenda (id integer primary key autoincrement, " +
//                "Nom text  not null, Num_Telefon text not null, PFP text, Gender text not null,Team text not null)");
        miAgenda.close();
        db.close();
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

    class AdapterContact extends ArrayAdapter  {

        Activity context;
        public AdapterContact(Activity context) {
            super(context, R.layout.listitem_contacte, listaContactes);
            this.context = (Activity) context;
        }

        // GetView s'executa per cada element i el que fa es "inflar" el layout del XML
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Inflem el Lauoyt
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_contacte, null);

            TextView lblNom = (TextView) item.findViewById(R.id.lblNom);
            lblNom.setText(listaContactes.get(position).getNom().toString());

            TextView lblTelefon = (TextView) item.findViewById(R.id.lblTelefon);
            lblTelefon.setText(listaContactes.get(position).getnTelefon().toString());

            TextView lblSexe = (TextView) item.findViewById(R.id.lblSexe);
            lblSexe.setText("S: "+listaContactes.get(position).getGenere().toString());

            TextView lblTeam = (TextView) item.findViewById(R.id.lblTeam);
            lblTeam.setText("T: "+listaContactes.get(position).getEquip().toString());

            ImageView lbImage = (ImageView) item.findViewById(R.id.lblImatge);
            if(listaContactes.get(position).getImagePFP()!=null){
                lbImage.setImageURI(listaContactes.get(position).getImagePFP());
                Log.e("FOTO","SETTEO LA FOTO A "+listaContactes.get(position).getNom());
                Log.e("FOTO",listaContactes.get(position).getNom()+" _> "+listaContactes.get(position).getImagePFP().toString());
            }


            return (item);
        }

    }

}
