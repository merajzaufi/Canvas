package com.canvas.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.canvas.model.Device;

public class ChallengeTwo {
	public static ArrayList<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>();
	
	
	public List<String> readCSVData(String file) throws IOException{
		
		List<String> csvList = new ArrayList<String>();
		  FileReader fileReader = new FileReader("src/"+file);
		  BufferedReader bufferedReader = new BufferedReader(fileReader);
		    String line = null;
		    while( (line = bufferedReader.readLine()) != null){
		    	csvList.add(line);
		    	
		    }
		    bufferedReader.close();

		    return csvList;
		}
	
	public List<Device> convertCSVToObject(List<String> input) throws ParseException{
		 ArrayList<Device> device = new ArrayList<>();
		 boolean flag = false;
		 ///SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		 ///ArrayList<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>();
		 dateFormats.add(new SimpleDateFormat("M/dd/yy"));
		 dateFormats.add(new SimpleDateFormat("MM/dd/yy"));
		 dateFormats.add(new SimpleDateFormat("M/dd/yyyy"));
		 
		 dateFormats.add(new SimpleDateFormat("yyyy-MM-dd"));
		 dateFormats.add(new SimpleDateFormat("M/dd/yyyy"));
		 
		 dateFormats.add(new SimpleDateFormat("dd.M.yyyy"));
		 ///dateFormats.add(new SimpleDateFormat("M/dd/yyyy hh:mm:ss a"));
		 dateFormats.add(new SimpleDateFormat("M/dd/yyyy"));
		 dateFormats.add(new SimpleDateFormat("dd.M.yyyy"));
		 ///dateFormats.add(new SimpleDateFormat("dd.M.yyyy hh:mm:ss a"));
		 dateFormats.add(new SimpleDateFormat("dd.MMM.yyyy"));
		 dateFormats.add(new SimpleDateFormat("dd-MMM-yyyy"));
		 
		 
			
		 
		 
		 for(String deviceString : input) {
		        String[] parts = deviceString.split(",");
		        if(flag){
		        	for(int i = 0; i < parts.length; i++) {
		        		
		        	String deviceID = parts[0];
		        String  a = parts[1];
		        String b = parts[2];
		        String c = parts[3];
		        String d = parts[4];
		        String date = null;
		        if(parts.length == 5) {
		        		date = null;
		        }else {
		        		date = parts[5];
		        }
		        
		        
		        device.add(new Device(deviceID, a, b, c, d, date));
		       
		         }
		        }
		        flag = true;
		 } 
		
		return device;
		
	}
	public boolean deleteFile() {
		 	File file = new File("src/random_data_sorted.csv");
         
	        if(file.delete())
	        {
	        	return true;
	        }
	        else
	        {
	        	return false;
	        }
		
	}
	public boolean writeUsingBufferedWriter(String data) {
		
		
        try(FileWriter fw = new FileWriter("src/random_data_sorted.csv", true);
        	    BufferedWriter bw = new BufferedWriter(fw);
        	    PrintWriter out = new PrintWriter(bw))
        	{
        	    out.println(data+"\n");
        	    
        	} catch (IOException e) {
        	    e.printStackTrace();
        	    return false;
        	}
		return true;
    }

}
