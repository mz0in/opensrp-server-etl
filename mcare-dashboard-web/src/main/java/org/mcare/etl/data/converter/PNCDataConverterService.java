package org.mcare.etl.data.converter;

import org.json.JSONObject;
import org.mcare.etl.entity.PNCEntity;
import org.mcare.etl.interfaces.DataConverterService;
import org.mcare.etl.service.PNCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PNCDataConverterService implements DataConverterService {
	
	@Autowired
	private PNCEntity pncEntity;
	
	@Autowired
	private PNCService pncService;
	
	public PNCDataConverterService() {
		
	}
	
	@Autowired
	public void setPNCEntity(PNCEntity pncEntity) {
		this.pncEntity = pncEntity;
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws Exception {
		
		try {
			JSONObject data = new JSONObject(doc.getString("data"));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		pncService.save(pncEntity);
	}
	
}
