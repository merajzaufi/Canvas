package com.canvas.model;

import java.util.Date;

public class Device {
	
	String deviceID,a,b,c,d;
	
	 public Device() {
		 
		     }
	public Device(String deviceID, String a, String b, String c, String d, String date){
		super();

		this.deviceID = deviceID;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.date = date;
	}
	
		
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	
	String date;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	

}
