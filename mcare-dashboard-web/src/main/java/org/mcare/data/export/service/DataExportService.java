/**
 * 
 */
package org.mcare.data.export.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * @author proshanto
 */
public interface DataExportService {
	
	public void export(List<Object[]> dataSets, HttpServletResponse response);
	
	public List<Object[]> getData(Date start, Date end, String provider);
	
}
