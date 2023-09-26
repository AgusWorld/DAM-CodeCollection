package com.example.bones;

import android.media.MediaPlayer;

public class DJ {
    //Lo hacemos SINGLETONE para usar el mismo siempre
    static MediaPlayer instance;
    public static int currentIndex = -1;
    public static MediaPlayer getInstance(){
        if(instance == null) instance = new MediaPlayer();
        return instance;
    }
}
