package com.example.bones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //MUSIC
    TextView CouldntFindSongTextView;
    Button RetryToSearchSongsButton;
    ArrayList<Song> songsList = new ArrayList<>();
    ListView PlayListSongsView;

    //CAMERA
    private Button btnCamera;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    //RECORD VOICE
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static final String TAG = "MainActivity";
    private Button btnRecord;
    private MediaRecorder mediaRecorder;
    private String fileName;
    private boolean isRecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayListSongsView = findViewById(R.id.PlayListSongsView);
        RetryToSearchSongsButton = findViewById(R.id.RetryToFindSongButton);
        RetryToSearchSongsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {SearchForSongs();}
        });
        CouldntFindSongTextView = findViewById(R.id.DidntFindSongTextView);

        //Asks for permission if we don't have them already
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE))
                Toast.makeText(MainActivity.this, "PLEASE GRANT READ PERMISSION🎵", Toast.LENGTH_LONG).show();
            else
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        SearchForSongs();

        PlayListSongsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                int CLICKAT=arg2;
//                INICIAR INTENTO
                DJ.getInstance().reset();
                DJ.currentIndex = CLICKAT;
                Context context = getApplicationContext();
                Intent intent = new Intent(context,MusicPlayerActivity.class);
                intent.putExtra("PLAYLIST",songsList);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        btnCamera = findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    // El permiso no está concedido, solicitarlo al usuario.
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            69);
                } else {
                    // El permiso está concedido, puedes continuar con la lógica de la cámara.
                    dispatchTakePictureIntent();
                }

            }
        });
        btnRecord = findViewById(R.id.btn_record);

        fileName = getExternalCacheDir().getAbsolutePath();
        fileName += "/recorded_audio.mp3";

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRecording) {
                    stopRecording();
                    btnRecord.setText("NUEVA SESSION🎙");
                    isRecording = false;
                } else {
                    startRecording();
                    btnRecord.setText("ACABAR SESSION🎤");
                    isRecording = true;
                }
            }
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO_PERMISSION);
        }
    }

    private void startRecording() {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mediaRecorder.setOutputFile(fileName);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
            Toast.makeText(this, "Recording started", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Log.e(TAG, "prepare() failed");
        }
    }

    private void stopRecording() {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
        Toast.makeText(this, "Recording stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Record audio permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Record audio permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // Guardar la imagen en el archivo
            try {
                File photoFile = createImageFile();
                FileOutputStream fos = new FileOutputStream(photoFile);
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();
                Toast toast = Toast.makeText(getApplicationContext(), "ALTA FOTO😎🤙", Toast.LENGTH_SHORT);
                toast.show();
                // Mostrar un mensaje de éxito o hacer algo más con el archivo guardado
            } catch (IOException e) {
                // Manejar la excepción
            }
        }
    }
    private File createImageFile() throws IOException {
        // Crea un nombre de archivo único basado en la fecha y hora actual
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefijo */
                ".jpg",         /* sufijo */
                storageDir      /* directorio */
        );
        return image;
    }


    public void ShowSongs(){
        if(songsList.size()>0){
            AdapterSongList myAdapter = new AdapterSongList(this);
            PlayListSongsView.setAdapter(myAdapter);
            CouldntFindSongTextView.setVisibility(View.GONE);
            RetryToSearchSongsButton.setVisibility(View.GONE);
        }else{
            CouldntFindSongTextView.setVisibility(View.VISIBLE);
            RetryToSearchSongsButton.setVisibility(View.VISIBLE);
        }
    }

    public void SearchForSongs(){
        String[] WhatToPickFromAudio = {MediaStore.Audio.Media.TITLE,MediaStore.Audio.Media.DATA,MediaStore.Audio.Media.DURATION};
        //String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, WhatToPickFromAudio, null, null, null);
        songsList.clear();
        //Iterate over the query result
        while (cursor.moveToNext()) {
            // Crea un objeto de datos de canción a partir de los resultados de la consulta
            String songTitle = cursor.getString(0);
            String songPath = cursor.getString(1);
            String songDuration = cursor.getString(2);
            Song currentSong = new Song(songTitle, songPath, songDuration);

            // Verifica si el archivo de la canción existe antes de agregarla a la lista
            File currentSongFile = new File(currentSong.getPath());
            if (currentSongFile.exists()) songsList.add(currentSong);
        }
        ShowSongs();
    }

    class AdapterSongList extends ArrayAdapter {
        Activity context;
        public AdapterSongList(Activity context) {
            super(context, R.layout.song_item, songsList);
            this.context = (Activity) context;
        }

        // GetView s'executa per cada element i el que fa es "inflar" el layout del XML
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Inflem el Lauoyt
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.song_item, null);

            TextView SontTitleTextView = (TextView) item.findViewById(R.id.SontTitleTextView);
            SontTitleTextView.setText(songsList.get(position).getTitle().toString());
            ImageView iconImageView = (ImageView) item.findViewById(R.id.SongIconImageView);
            return (item);
        }
    }

}