package br.com.zed.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(schema="ADMNG", name = "zed01_partner")
public class PartnerDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8750831444175575624L;
	
	@Id
	@Column(name = "partner_id")
	private Integer id;
	
	@Column(name = "name")
	private String tradingName;
	
	@Column(name = "owner_name")
	private String ownerName;
	
	@Column(name = "doc_cnpj")
	private String document;
		
	@Column(name = "coordinate_lat")
	private Double address_lat;

	@Column(name = "coordinate_lng")
	private Double address_lng;
    
	
	public PartnerDO () {
		super();
	}
	
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
	public Double getAddress_lat() {
		return address_lat;
	}
	public void setAddress_lat(Double addrs) {
		this.address_lat = addrs;
	}
	public Double getAddress_lng() {
		return address_lng;
	}
	public void setAddress_lng(Double address_lng) {
		this.address_lng = address_lng;
	}


	@Override
	public String toString() {
		return "PartnerDO [id=" + id + ", tradingName=" + tradingName + ", ownerName=" + ownerName + ", document="
				+ document + ", address_lat=" + address_lat + ", address_lng=" + address_lng + "]";
	}

	
	
	
	
    
    
}
