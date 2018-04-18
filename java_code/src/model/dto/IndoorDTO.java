package model.dto;

import java.util.ArrayList;

public class IndoorDTO{
	private String store_name;
	private String X;
	private String Y;
	private String Location;
	
	
	public IndoorDTO() {
	}
	
	public IndoorDTO(String store_name,String x, String y,String Location) {
		super();
		this.store_name = store_name;
		this.X = x;
		this.Y = y;
		this.Location = Location;
	}

	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getX() {
		return X;
	}
	public void setX(String x) {
		X = x;
	}
	public String getY() {
		return Y;
	}
	public void setY(String y) {
		Y = y;
	}
	
	public String getLocation() {
		return Location;
	}
	public void setLocation(String loc) {
		Location = loc;
	}


}