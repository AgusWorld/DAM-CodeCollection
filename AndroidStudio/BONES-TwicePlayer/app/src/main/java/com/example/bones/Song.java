package com.example.bones;

import java.io.Serializable;

public class Song implements Serializable {
    String path;
    String title;
    String duration;

    public Song(String title,String path,  String duration) {
        this.title = title;
        this.path = path;
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
