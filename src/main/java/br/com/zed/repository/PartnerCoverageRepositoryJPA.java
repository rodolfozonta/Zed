package br.com.zed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.zed.domain.PartnerCoverageDO;
import br.com.zed.domain.PartnerDO;

public interface PartnerCoverageRepositoryJPA  extends JpaRepository<PartnerCoverageDO, Integer>{


}
