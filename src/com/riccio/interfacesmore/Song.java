package com.riccio.interfacesmore;

public class Song {
    private String title;
    private int duration;

    public Song(String title, int durationSecs) {
        this.title = title;
        this.duration = durationSecs;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
