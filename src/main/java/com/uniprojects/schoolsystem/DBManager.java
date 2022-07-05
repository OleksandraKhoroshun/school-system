package com.uniprojects.schoolsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.awt.HeadlessException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.Map;

public class DBManager {
    public DBManager(){

    }
    public static void post(String link, Map<String,String> fields) throws IOException {
        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       conn.setRequestMethod("POST");
       conn.setRequestProperty("Content-Type", "application/json");
       conn.setRequestProperty("Accept", "application/json");
       conn.setDoOutput(true);

        int i=0;
        String jsonString = "{";
        for(Map.Entry<String,String> entry : fields.entrySet()){
            jsonString+=entry.getKey()+": "+entry.getValue();
            i++;
            if(fields.size()>i)jsonString+=", ";
        }
        jsonString+="}";
        System.out.println(jsonString);

        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        System.out.println(jsonString);
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }






    }
}
