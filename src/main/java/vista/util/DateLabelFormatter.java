package main.java.vista.util;

import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

import main.java.util.DateUtil;

public class DateLabelFormatter extends AbstractFormatter {
	
    @Override
    public Object stringToValue(String text) throws ParseException {
        return DateUtil.getDateFormat().parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return DateUtil.getDateFormat().format(cal.getTime());
        }
        return "";
    }

}
