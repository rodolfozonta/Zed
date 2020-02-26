package br.com.zed.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.zed.domain.PartnerDO;

public interface PartnerRepositoryJPA extends JpaRepository<PartnerDO, Integer>{
	
	String SQL_CHECK_DBASE =
			"Select max(partner_id)" + 
			" from zed01_partner";
	@Query(value = SQL_CHECK_DBASE, nativeQuery = true)
	public PartnerDO getCheckBase();

	String SQL_SEARCH =
			"Select distinct z01.* from zed01_partner z01" + 
			"       inner join  (Select * from zed02_partner_covarage z02" + 
			"                    where ((z02.coordinate_lat between :lat and  (:lat +0.1))" + 
			"                    or    (z02.coordinate_lat between  :lat and  (:lat +0.1)))" + 
			"                                            and  	" + 
			"                          ((z02.coordinate_lng between  :lng and  (:lng +0.1))" + 
			"                    or    (z02.coordinate_lng between  :lng and  (:lng +0.1)))) z " + 
			"          on z.partner_id = z01.partner_id"+
			" order by z01.partner_id";
	@Query(value = SQL_SEARCH, nativeQuery = true)
	public Optional<List<PartnerDO>> getSearchPartner(Double lat, Double lng);

	
	

}
