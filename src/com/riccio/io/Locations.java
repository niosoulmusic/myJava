package com.riccio.io;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        Path dirPath = FileSystems.getDefault().getPath("directions.dat");
        try(ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))){
            for (Location location : locations.values()){
                locFile.writeObject(location);
            }
        }

    }

    // 1. This first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long.  It will start at byte 8 and end at byte 1699
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700


    static {

        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
        boolean eof = false;
        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(
                Files.newInputStream(locPath)))){
            while(!eof){
                Location location = (Location) locFile.readObject();
            }

        }catch (EOFException e){
            eof = true;
        }catch (IOException e){
            System.out.println("IO EXCEPTION "+e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("CLASS NOT FOUND  "+e.getMessage());
        }
    }



    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
