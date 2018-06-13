package com.riccio.interfacesmore;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songList;


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
    }


    public boolean addSong(String name, int duration) {
        return this.songList.add(new Song(name,duration));
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        Song checkedSong = this.songList.findSong(trackNumber);
        if (checkedSong!=null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("this album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {

        Song checkedSong = this.songList.findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            System.out.println("Added song "+title +" To playlist");
            return true;
        }
        System.out.println("this album does not have a track " + title);
        return false;
    }

    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs=new ArrayList<Song>();
        }

        public boolean add(Song song){
            for (Song checkedSong : songs){
                if (checkedSong.getTitle().equalsIgnoreCase(song.getTitle())){
                    System.out.println("Song "+song.getTitle()+" already in songList");
                    return false;
                }
            }
            songs.add(song);
            System.out.println("Adding song "+song.getTitle()+" to the SongList");
            return true;

        }
        private Song findSong(String name) {
            for (Song checkedSong : this.songs) {
                if (checkedSong.getTitle().equalsIgnoreCase(name))
                    return checkedSong;
            }
            return null;
        }
        public Song findSong(int trackNumber){
            int index=trackNumber--;
            if ((index>0) && index<songs.size()){
                return songs.get(index);
            }
            return null;
        }
    }
}
