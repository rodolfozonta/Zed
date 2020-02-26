package br.com.zed.domain;

import java.io.Serializable;

import br.com.zed.exception.ZedExceptions;

public class PartnerCoveragePK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5750113756234003724L;
	private Integer partnerId;
	private Integer idCoordinate;
	
	public PartnerCoveragePK() {
		super();
	}

	public PartnerCoveragePK(Integer partnerId, Integer idCoordinate) {
		super();
		this.partnerId = partnerId;
		this.idCoordinate = idCoordinate;
		
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public Integer getIdCoordinate() {
		return idCoordinate;
	}

	public void setIdCoordinate(Integer idCoordinate) {
		this.idCoordinate = idCoordinate;
	}
	
	
}
