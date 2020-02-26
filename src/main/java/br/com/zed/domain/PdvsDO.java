package br.com.zed.domain;

import java.util.List;

public class PdvsDO {
	private List<PdvDO> pdvs;

	public List<PdvDO> getPdvs() {
		return pdvs;
	}

	public void setPdvs(List<PdvDO> pdvs) {
		this.pdvs = pdvs;
	}

	@Override
	public String toString() {
		return "PdvsDO [pdvs=" + pdvs + "]";
	}
	
	

}
