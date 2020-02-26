package br.com.zed.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.zed.exception.ZedExceptions;

@Entity
@IdClass(PartnerCoveragePK.class)
@Table(schema="ADMNG", name = "zed02_partner_covarage")
public class PartnerCoverageDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6281764869112184497L;
	
	
	@Id
	@Column(name = "partner_id")
	private Integer partnerId;
	
	@Id
	@Column(name = "COVERAGE_ID")
	private Integer idCoordinate;
	
	@Column(name = "coordinate_lat")
	private Double lat;
	
	@Column(name = "coordinate_lng")
	private Double lgn;
	
	public PartnerCoverageDO() {
		super();
	}
	public PartnerCoverageDO(Double latExt, Double lngExt){
		super();
		this.lat = latExt;
		this.lgn = lngExt;
	}
		
	public Integer getIdCoordinate() {
		return idCoordinate;
	}
	public void setIdCoordinate(Integer idCoordinate) {
		this.idCoordinate = idCoordinate;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLgn() {
		return lgn;
	}
	public void setLgn(Double lgn) {
		this.lgn = lgn;
	}
	public Integer getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}
	@Override
	public String toString() {
		return "PartnerCoverageDO [partnerId=" + partnerId + ", idCoordinate=" + idCoordinate + ", lat=" + lat
				+ ", lgn=" + lgn + "]";
	}
	
	public String getCoverageArea() {
		return "Partner Coverage:/n"+
				"lat: "+lat +" - "+
				"lng: "+lgn+"/n";
	}
	
	

	public Integer checkCoordinateQty(int qtyLat, int qtyLng ) throws ZedExceptions {
		Integer j = 0;
		if (qtyLat == qtyLng) {
			if (qtyLat >= qtyLng) {
				j = qtyLat;
			} else {
				j = qtyLng;
			}
		} else {
			throw new ZedExceptions("Please send all coordinates!");
		}
		return j;
		
	}
	
	
	
}
