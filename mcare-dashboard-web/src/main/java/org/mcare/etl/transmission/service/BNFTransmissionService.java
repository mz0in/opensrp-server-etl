package org.mcare.etl.transmission.service;

import org.json.JSONObject;
import org.mcare.etl.data.converter.BNFDataConverterService;
import org.mcare.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

public class BNFTransmissionService implements TransmissionServices {
	
	@Autowired
	private BNFDataConverterService bnfDataConverterService;
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws Exception {
		bnfDataConverterService.convertToEntityAndSave(doc);
	}
	
}
