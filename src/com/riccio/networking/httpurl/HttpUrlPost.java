package com.riccio.networking.httpurl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlPost {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            //this is not really useful - some serious web server will recognize this is not true
            urlConnection.setRequestProperty("User-Agent", "Chrome");
            urlConnection.setReadTimeout(10000);

            int responseCode = urlConnection.getResponseCode();
            System.out.println("response code : " + responseCode);
            if (responseCode != 200) {
                System.out.println("error reading web page with address : " + url.toString());
                System.out.println("response code : "+urlConnection.getResponseCode());
                return;
            }
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String htmlLine="";
            while ((htmlLine = inputStream.readLine())!=null){
                htmlLine = inputStream.readLine();
                System.out.println(htmlLine);
            }
            inputStream.close();

        } catch (MalformedURLException e) {
            System.out.println("Url malformed : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());

        }
    }
}
