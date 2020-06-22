package main.java.vista.util;

import java.util.Properties;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public enum DatePicker {
	
	INSTANCE;
	
	private UtilDateModel model;
	private DateLabelFormatter formatter;
	private Properties properties;	
	
	public JDatePickerImpl getDatePicker() {
		model = new UtilDateModel();
		formatter = new DateLabelFormatter();
		properties = new Properties();			
		properties.put("text.today", "Today");
	    JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
	    return new JDatePickerImpl(datePanel, formatter);
	}

}
