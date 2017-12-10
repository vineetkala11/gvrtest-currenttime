package com.gvr.test.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.gvr.test.model.Session;

public class Utils {

    private static String fileLocation = ".";
    public static synchronized Integer getCounter(Session.API api) throws IOException {
        
        String fileName = fileLocation+File.separator+api.name()+".txt";
        Integer hitCount = null;
        File file = new File(fileName);
        if(!file.exists())
            file.createNewFile();
            
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                hitCount = Integer.parseInt(line);
                break;
            }
            
            if(null == hitCount) {
                hitCount = 0;
                writeHitCount(api,hitCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return hitCount;
    }
    
    public static void writeHitCount(Session.API api, Integer hitCount) throws IOException {
        String fileName = fileLocation+File.separator+api.name()+".txt";
        Files.write(Paths.get(fileName), (hitCount).toString().getBytes());
    }
    
    public static synchronized Integer updateCounter(Session.API api) throws IOException {
        Integer hitCount = getCounter(api);
        writeHitCount(api, ++hitCount);
        return hitCount;
    }
}
