package org.mcare.etl.interfaces;

import org.json.JSONException;
import org.json.JSONObject;

public interface DataConverterService {
	
	public void convertToEntityAndSave(JSONObject t) throws JSONException, Exception;
}
