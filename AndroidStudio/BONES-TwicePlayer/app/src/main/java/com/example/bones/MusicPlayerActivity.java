package com.example.bones;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MusicPlayerActivity extends AppCompatActivity {
    TextView songNameTextView,ElapsedTimeTextView,SongTotalTimeTextView;
    SeekBar PlaybackBarSeekBar;
    ImageView PlayAndPauseImageView,SkipSongImageView,PreviousSongImageView,SongCoverImageView;
    ArrayList<Song> songsList;
    Song currentSong;
    MediaPlayer mediaPlayer = DJ.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer);
        songsList = (ArrayList<Song>) getIntent().getSerializableExtra("PLAYLIST");
        songNameTextView = findViewById(R.id.songNameTextView);
        ElapsedTimeTextView = findViewById(R.id.ElapsedTimeTextView);
        SongTotalTimeTextView = findViewById(R.id.SongTotalTimeTextView);
        PlaybackBarSeekBar = findViewById(R.id.PlaybackBarSeekBar);
        PlayAndPauseImageView = findViewById(R.id.PlayAndPauseImageView);
        SkipSongImageView = findViewById(R.id.SkipSongImageView);
        PreviousSongImageView = findViewById(R.id.PreviousSongImageView);
        SongCoverImageView = findViewById(R.id.SongCoverImageView);
        songNameTextView.setSelected(true);
        setResourcesWithMusic();
        MusicPlayerActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer!=null){
                    PlaybackBarSeekBar.setProgress(mediaPlayer.getCurrentPosition());
                    ElapsedTimeTextView.setText(convertToMMSS(mediaPlayer.getCurrentPosition()+""));
                    if(mediaPlayer.isPlaying()) PlayAndPauseImageView.setImageResource(R.drawable.ic_baseline_pause_circle_24);
                    else PlayAndPauseImageView.setImageResource(R.drawable.ic_baseline_play_circle_24);
                }
                new Handler().postDelayed(this,100);
            }
        });

        PlaybackBarSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar PlaybackBarSeekBar, int progress, boolean fromUser) {
                if(mediaPlayer!=null && fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }
            @Override
            public void onStopTrackingTouch(SeekBar PlaybackBarSeekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar PlaybackBarSeekBar) {}
        });

    }
    void setResourcesWithMusic(){
        currentSong = songsList.get(DJ.currentIndex);
        songNameTextView.setText(currentSong.getTitle());
        SongTotalTimeTextView.setText(convertToMMSS(currentSong.getDuration()));
        PlayAndPauseImageView.setOnClickListener(v-> PlayAndPauseImageView());
        SkipSongImageView.setOnClickListener(v-> playNextSong());
        PreviousSongImageView.setOnClickListener(v-> playPreviousSong());
        playMusic();
    }


    private void playMusic(){
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(currentSong.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            PlaybackBarSeekBar.setProgress(0);
            PlaybackBarSeekBar.setMax(mediaPlayer.getDuration());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playNextSong(){
        if(DJ.currentIndex== songsList.size()-1) return;
        DJ.currentIndex +=1;
        mediaPlayer.reset();
        setResourcesWithMusic();
    }

    private void playPreviousSong(){
        if(DJ.currentIndex== 0) return;
        DJ.currentIndex -=1;
        mediaPlayer.reset();
        setResourcesWithMusic();
    }

    private void PlayAndPauseImageView(){
        if(mediaPlayer.isPlaying()) mediaPlayer.pause();
        else mediaPlayer.start();
    }


    public static String convertToMMSS(String duration){
        Long millis = Long.parseLong(duration);
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
    }
}
