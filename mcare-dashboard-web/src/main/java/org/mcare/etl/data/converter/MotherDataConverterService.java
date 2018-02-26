package org.mcare.etl.data.converter;

import org.json.JSONObject;
import org.mcare.etl.entity.MotherEntity;
import org.mcare.etl.interfaces.DataConverterService;
import org.mcare.etl.service.ExceptionService;
import org.mcare.etl.service.MotherService;
import org.mcare.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotherDataConverterService implements DataConverterService {
	
	@Autowired
	private MotherEntity motherEntity;
	
	@Autowired
	private MotherToANCConverter motherToANCConverter;
	
	@Autowired
	private MotherToPNCConverter motherToPNCConverter;
	
	@Autowired
	private MotherService motherService;
	
	@Autowired
	private BNFDataConverterService bnfDataConverterService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	public MotherDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws Exception {
		String caseID = "";
		try {
			caseID = doc.getString("caseId");
			JSONObject details = new JSONObject(doc.getString("details"));
			motherEntity.setCaseId(doc.getString("caseId"));
			motherEntity.setClientVersion(doc.getLong("clientVersion"));
			if (doc.has("FWWOMDISTRICT"))
				motherEntity.setDistrict(doc.getString("FWWOMDISTRICT"));
			if (doc.has("FWWOMUPAZILLA"))
				motherEntity.setUpazila(doc.getString("FWWOMUPAZILLA"));
			
			if (details.has("division"))
				motherEntity.setDivision(details.getString("division"));
			
			motherEntity.setCountry("BANGLADESH");
			motherEntity.setCurrentFormStatus("");
			if (doc.has("external_user_ID")) {
				motherEntity.setExternalUserId(doc.getString("external_user_ID"));
			} else {
				motherEntity.setExternalUserId("");
			}
			
			motherEntity.setGender("female");
			motherEntity.setGps("");
			motherEntity.setLastName("");
			motherEntity.setFirstName(doc.getString("mother_first_name"));
			motherEntity.setInstanceId(doc.getString("INSTANCEID"));
			motherEntity.setMauzaPara(doc.getString("mother_mauza"));
			motherEntity.setProvider(doc.getString("PROVIDERID"));
			motherEntity.setSubmissionTime(doc.getLong("SUBMISSIONDATE"));
			if (doc.has("FWWOMSUBUNIT"))
				motherEntity.setSubunit(doc.getString("FWWOMSUBUNIT"));
			if (doc.has("FWWOMUNION"))
				motherEntity.setUnion(doc.getString("FWWOMUNION"));
			
			if (doc.has("FWWOMWARD"))
				motherEntity.setWard(doc.getString("FWWOMWARD"));
			motherEntity.setMotherGOBHHID(doc.getString("mother_gobhhid"));
			motherEntity.setMotherJIVIHID(doc.getString("mother_jivhhid"));
			motherEntity.setMotherHusname(doc.getString("mother_husname"));
			motherEntity.setMotherWomNID(doc.getString("mother_wom_nid"));
			motherEntity.setMotherWomBID(doc.getString("mother_wom_bid"));
			motherEntity.setMotherWomAge(doc.getString("mother_wom_age"));
			motherEntity.setMotherValid(details.getString("mother_valid"));
			motherEntity.setFWVG(doc.getString("FWVG"));
			motherEntity.setFWHRP(doc.getString("FWHRP"));
			motherEntity.setFWHR_PSR(doc.getString("FWHR_PSR"));
			motherEntity.setFWFLAGVALUE(doc.getString("FWFLAGVALUE"));
			motherEntity.setFWSORTVALUE(doc.getString("FWSORTVALUE"));
			motherEntity.setMotherWomLMP(DateUtil.getDateFromString(details, "LMP"));
			motherEntity.setBirthDate(DateUtil.getDateFromString(details, "birthDate"));
			motherEntity.setRelationalId(doc.getString("relationalid"));
			motherEntity.setIsClosed(doc.getString("isClosed"));
			
			motherEntity.setReceivedTime(DateUtil.getDateTimeFromString(details, "received_time"));
			
			motherEntity.setStart(DateUtil.getDateTimeFromString(doc, "START"));
			
			motherEntity.setEnd(DateUtil.getDateTimeFromString(doc, "END"));
			
			motherEntity.setToday(DateUtil.getDateFromString(doc, "TODAY"));
			motherEntity.setRegistrationDate(DateUtil.getDateFromString(doc, "TODAY"));
			
			if (doc.has("user_type")) {
				motherEntity.setUserType(doc.getString("user_type"));
			} else {
				motherEntity.setUserType("");
			}
			motherService.save(motherEntity);
			
			bnfDataConverterService.convertToEntityAndSave(doc);
			motherToANCConverter.ancVisitSave(doc);
			motherToPNCConverter.pncVisitSave(doc);
		}
		catch (Exception e) {
			
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "mother");
		}
		
	}
}
