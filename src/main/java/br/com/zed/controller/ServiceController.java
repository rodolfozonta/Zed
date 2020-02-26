package br.com.zed.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.zed.domain.PartnerCoverageDO;
import br.com.zed.domain.PartnerDO;
import br.com.zed.domain.PdvsDO;
import br.com.zed.exception.ZedExceptions;
import br.com.zed.repository.PartnerCoverageRepositoryJPA;
import br.com.zed.repository.PartnerRepositoryJPA;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.HEAD })
@RestController
@RequestMapping("api")
public class ServiceController {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	PartnerRepositoryJPA partnerRepositoryJPA;
	
	@Autowired
	PartnerCoverageRepositoryJPA partnerCoverageRepositoryJPA;

	@PostMapping(path = "/createPartner",  produces = "application/json")
	public String createPartner(Integer id, String tradingName, String ownerName, String document, Double address_lat, Double address_lng, Double[] coverageAreaLat, Double[] coverageAreaLng) throws ZedExceptions{
		PartnerDO partner = new PartnerDO();
		PartnerCoverageDO dados = new PartnerCoverageDO();
		String sit ="";
		try {
			partner.setId(id);
			partner.setTradingName(tradingName);
			partner.setOwnerName(ownerName);
			partner.setDocument(document);
			partner.setAddress_lat(address_lat);
			partner.setAddress_lng(address_lng);
			
			Double vetLat[] = coverageAreaLat;
			Double vetLng[] = coverageAreaLng;
			 
			int j = dados.checkCoordinateQty(vetLat.length, vetLng.length);
			
			partnerRepositoryJPA.save(partner);
			for(int i =0; i<j;i++) {
				PartnerCoverageDO coverage = new PartnerCoverageDO();
				coverage.setPartnerId(id);
				coverage.setIdCoordinate(i);
				coverage.setLat((vetLat[i] == null ? 0 : vetLat[i]));
				coverage.setLgn((vetLng[i] == null ? 0 : vetLng[i]));
				partnerCoverageRepositoryJPA.save(coverage);
			}
			sit = "Create Success";
			
		}catch (ZedExceptions e){
			LOG.error("Fail to save partner: "+e);
			throw e;
		}
		return sit;
		
	}

	@GetMapping(value ="/getPartnerById", produces = "application/json")
	public Optional<PartnerDO> getPartnerById(Integer idPartner) {
		Optional<PartnerDO> dados = partnerRepositoryJPA.findById(idPartner);
		return dados;
	}

	@GetMapping(name="/getNearPartner", produces = "application/json")
	public Optional<List<PartnerDO>> getNearPartner(Double lat, Double lng) {
		Optional<List<PartnerDO>> busca = partnerRepositoryJPA.getSearchPartner(lat, lng);
		return busca;		

	}


	public static final String JSON_PATH = "pdvs.json";
	@GetMapping("/getJson")
	public String loadJson() throws IOException {
		
		LOG.info("Start /getJson - Load Base");
		try {
			Resource resource = new ClassPathResource("pdvs.json");
			InputStream input = resource.getInputStream();
			String theString = IOUtils.toString(input);
			input.close();

			Gson gson = new Gson();
			PdvsDO[] jsonData = gson.fromJson(theString, PdvsDO[].class);

			for (PdvsDO pdvs : jsonData) {
				LOG.info("Begin Save Datas On Base");
				LOG.info("Log pdvs.json on console");
				System.out.println(pdvs.toString());
				// Save header
				for (int j = 0; j < pdvs.getPdvs().size(); j++) {
					PartnerDO partner = new PartnerDO();

					System.out.println(pdvs.getPdvs().get(j).getId());
					System.out.println(pdvs.getPdvs().get(j).getTradingName());
					System.out.println(pdvs.getPdvs().get(j).getOwnerName());
					System.out.println(pdvs.getPdvs().get(j).getDocument());

					partner.setId(pdvs.getPdvs().get(j).getId());
					partner.setTradingName(pdvs.getPdvs().get(j).getTradingName());
					partner.setOwnerName(pdvs.getPdvs().get(j).getOwnerName());
					partner.setDocument(pdvs.getPdvs().get(j).getDocument());

					int controlAddr = 0;
					for (Double addrs : pdvs.getPdvs().get(j).getAddress().getCoordinates()) {
						if (controlAddr == 0) {
							partner.setAddress_lat(addrs);
						} else {
							partner.setAddress_lng(addrs);
						}
						controlAddr++;
					}

					partnerRepositoryJPA.save(partner);
					LOG.info("Save Partner on DB: " + partner.getId());
					// Explode Coverage of partner
					for (List<List<List<Double>>> list1 : pdvs.getPdvs().get(j).getCoverageArea().getCoordinates()) {
						for (List<List<Double>> list2 : list1) {
							int controlId = 1;
							PartnerCoverageDO coverage = new PartnerCoverageDO();
							coverage.setPartnerId(partner.getId());
							for (List<Double> list3 : list2) {
								int i = 0;
								coverage.setIdCoordinate(controlId);
								for (Double coordinates : list3) {
									// Parse Lat and Lng of Multipolygon
									if (i == 0) {
										coverage.setLat(coordinates);
										System.out.println("Lat:" + coordinates);
									} else {
										coverage.setLgn(coordinates);
										System.out.println("Lng:" + coordinates);
									}
									i++;
								}
								controlId++;
								partnerCoverageRepositoryJPA.save(coverage);
								LOG.info("Save Coverage Area Patner!");
								System.out.println(
										">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + controlId);
							}
						}

					}

				}

			}

		} catch (Exception e) {
			LOG.error("Error loadJson  -  " + e);
			throw e;
		}
		LOG.info("Sucess!");
		 String ret = "Load Sucess";
		 return ret;
	}
}
