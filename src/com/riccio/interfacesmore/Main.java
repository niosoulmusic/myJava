package com.riccio.interfacesmore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("riccio best songs", "riccio");
        album.addSong("hello by me", 320);
        album.addSong("ciao", 340);
        album.addSong("bella", 310);
        album.addSong("bella", 310);
        albums.add(album);

        album = new Album("who me ?", "paolo");
        album.addSong("blabla", 340);
        album.addSong("cici", 220);
        album.addSong("coco", 340);
        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("ciao", playlist);
        albums.get(0).addToPlaylist("ciao", playlist);
        albums.get(0).addToPlaylist("bella", playlist);
        albums.get(0).addToPlaylist("wow", playlist);
        play(playlist);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                    }
                    forward = true;
                    if (listIterator.hasNext()) {
                        System.out.println("now playing " + listIterator.next());
                    } else {
                        System.out.println("end of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("end of playlist");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    // printPlaylist(playList);
                case 5:
                    // printMenu();
                    break;
                case 6:
                    if (playList.size()>0) {
                        if (listIterator.hasNext()) {
                            System.out.println("removing song "+playList.get(listIterator.nextIndex()).toString());
                            playList.remove();

                        }
                    }
                    break;

            }
        }
    }
}
