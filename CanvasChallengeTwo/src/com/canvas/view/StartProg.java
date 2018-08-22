package com.canvas.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.canvas.controller.ChallengeTwo;
import com.canvas.model.Device;

import java.util.Arrays;

public class StartProg {

	public static void main(String[] args) {
		ChallengeTwo objInstance = new ChallengeTwo(); 
		
		Scanner nameScan = new Scanner(System.in);
		System.out.println("Enter file name to be sorted(provide complete extension of the file): ");
        String name = nameScan.nextLine();
        
		List<String> csvData = new ArrayList<String>();
		 try {
			FileReader fileReader = new FileReader("src/"+name);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    String line = null;
		    while( (line = bufferedReader.readLine()) != null){
		    	csvData.add(line);
		    	
		    }
		    bufferedReader.close();

		   
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("File not found, re-run and enter a valid file name");
				///System.out.println(e1);
			} 
		List<Device> deviceObj = null;
		try {
		deviceObj = objInstance.convertCSVToObject(csvData);
		}
		catch(ParseException pex) {
		System.out.println(pex);
		}
		
	/*	deviceObj.sort(new Comparator<Device>() {

			@Override
			public int compare(Device o1, Device o2) {
				Device dev1  = (Device) o1;
				Device dev2 = (Device) o2;
				return dev1.getDeviceID() - dev2.getDeviceID();
			}
			
			
		});
		*/
		     
		deviceObj.sort(new Comparator<Device>() {

			@Override
			public int compare(Device o1, Device o2) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
				int comparision = 0;
				Device dev1  = (Device) o1;
				Device dev2 = (Device) o2;
				if(dev1.getDeviceID() != null) {
				comparision = Integer.parseInt(dev1.getDeviceID()) - Integer.parseInt(dev2.getDeviceID());
				}
				
				if(comparision == 0) {
					if(dev1.getDate() != null && dev2.getDate() != null) {
						
						Date date1, date2;
						Date dat = null;
						
				        for (SimpleDateFormat format : ChallengeTwo.dateFormats) {
							try {
								format.setLenient(false);
								date1 = format.parse(dev1.getDate());
								date2 = format.parse(dev1.getDate());
								///System.out.println("Date = "+dat);
								
							} catch (ParseException e) {
								date1 = null;
								
								
							}
							
							try {
								format.setLenient(false);
								date2 = format.parse(dev1.getDate());
								
								
							} catch (ParseException e) {
								date1 = null;
								
							}
							
							
						}

						
					
					/*	
						try {
							 date1=(Date) dateFormat.parse(dev1.getDate());
							 date2=(Date) dateFormat.parse(dev2.getDate());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
					comparision = ((dev1.getDate()).compareTo(dev2.getDate()));
					}
				}
				return comparision;
			}
			
			
		});
		
		objInstance.deleteFile();
		objInstance.writeUsingBufferedWriter("Device_ID,A,B,C,D,Date");
			
		
		
        for(Device dev: deviceObj){
        	String date = "";
        	if(dev.getDate() != null) {
        		date = dev.getDate();
        	}
        	boolean returnVal = objInstance.writeUsingBufferedWriter(dev.getDeviceID()+","+dev.getA()+","+dev.getB()+","+dev.getC()+","+dev.getD()+","+date);
    		if(!returnVal) {
    			System.out.println("Exception Occured While Writing...");
    		}
        }
       System.out.println("File sorted successfully!!, please check random_data_sorted.csv under src folder..");
		

	}
}
