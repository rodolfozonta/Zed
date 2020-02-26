package br.com.zed.domain;

import java.util.List;

public class CoverageAreaDO {

	private String type;
	private List<List<List<List<Double>>>> coordinates;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<List<List<List<Double>>>> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<List<List<List<Double>>>> coordinates) {
		this.coordinates = coordinates;
	}
	
	
	@Override
	public String toString() {
		return "CoverageAreaDO [type=" + type + ", coordinates=" + coordinates + "]";
	}
	
	
	

	
	
}
