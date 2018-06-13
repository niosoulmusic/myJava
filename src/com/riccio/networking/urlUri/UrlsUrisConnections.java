package com.riccio.networking.urlUri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class UrlsUrisConnections {

    public static void main(String[] args) {
        try {

            //basic URI scheme
            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI relativeUri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedUri = baseUri.resolve(uri);

            URL urlFromUri = resolvedUri.toURL();
            System.out.println("URL = " + urlFromUri);
            System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            System.out.println("Authority = " + uri.getAuthority());
            System.out.println("User info = " + uri.getUserInfo());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Port = " + uri.getPort());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Query = " + uri.getQuery());
            System.out.println("Fragment = " + uri.getFragment());


            //let's connect and download html with java IO
            URL url = new URL("http://www.example.org");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String htmlLine="";
            while (inputStream.readLine()!=null){
                htmlLine = inputStream.readLine();
                System.out.println(htmlLine);
            }
            inputStream.close();

            //headers
            Map<String,List<String>> headerFields = urlConnection.getHeaderFields();
            for (Map.Entry<String,List<String>> entry : headerFields.entrySet()){
                String key = entry.getKey();
                List<String> values = entry.getValue();
                System.out.print("---key = "+ key + " , ");
                for (String value : values){
                    System.out.println(" value = "+value);
                }
            }

        }catch (URISyntaxException e){
            System.out.println("URISyntaxException "+e.getMessage());
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed url : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}
