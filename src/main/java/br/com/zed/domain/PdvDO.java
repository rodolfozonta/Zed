package br.com.zed.domain;

import java.io.Serializable;
import java.util.List;

public class PdvDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8103285658675843916L;

	private Integer id; 
	private String tradingName;
	private String ownerName;
	private String document;
	private CoverageAreaDO coverageArea;
	private AddressDO address;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTradingName() {
		return tradingName;
	}
	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}


	public CoverageAreaDO getCoverageArea() {
		return coverageArea;
	}
	public void setCoverageArea(CoverageAreaDO coverageArea) {
		this.coverageArea = coverageArea;
	}
	public AddressDO getAddress() {
		return address;
	}
	public void setAddress(AddressDO address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PdvDO [id=" + id + ", tradingName=" + tradingName + ", ownerName=" + ownerName + ", document="
				+ document + ", coverageArea=" + coverageArea + ", address=" + address + "]";
	}



	
	
	
	
	
}
