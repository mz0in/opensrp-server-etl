package org.unicef.etl.interfaces;

import org.json.JSONException;
import org.json.JSONObject;

public interface TransmissionServices {
	
	public void convertDataJsonToEntity(JSONObject t) throws JSONException;
	
}
