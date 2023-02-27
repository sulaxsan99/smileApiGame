/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizgame.engine;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author SAKTHIMICRO
 */
public class GameServer {
   private static String readUrl(String urlString) {
	    try {
	        URL url = new URL(urlString);
	        InputStream inputStream = url.openStream();
	        // Choose anyone of https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java
	        // to convert InputStream to String.
	        ByteArrayOutputStream result = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = inputStream.read(buffer)) != -1) {
	            result.write(buffer, 0, length);
	        }
	        return result.toString("UTF-8");
	    } catch (IOException e) {
	        System.out.println("An Error occured: "+e.toString());
	        return null; 
	    }
} 
   
   public Game getRandomGame() throws MalformedURLException {
		String smileapi = "https://marcconrad.com/uob/smile/api.php?out=csv";
		String dataraw = readUrl(smileapi); 
		String[] data = dataraw.split(",");
		
		URL quest = new URL(data[0]); 
		int solution  = Integer.parseInt(data[1]);  
		
		return new Game(quest, solution);
                
                
	}
}   
