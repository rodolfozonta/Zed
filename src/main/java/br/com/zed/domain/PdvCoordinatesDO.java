package br.com.zed.domain;

import java.io.Serializable;

public class PdvCoordinatesDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2528921299255059128L;
	private String lat;
	private String lng;
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	

}
