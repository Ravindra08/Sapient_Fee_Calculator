package com.sapient.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author RAVINDRA.SINGH
 *  RA20004613
 *
 */
public class Utils {

	public static Double parseMarketValue(String marketValue) {
		try{// TODO Auto-generated method stub
			return Double.parseDouble(marketValue);
		}catch(Exception ex){
			return (double) 0;
		}
	}

	public static Boolean getPriority(String priority) {
		if(priority!= null){
			priority = priority.trim();
			if(priority.equals("true")||priority.equals("TRUE")){
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}

	public static Date parseDate(String date) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date convertedCurrentDate = sdf.parse(date);
			return convertedCurrentDate;
		}catch(Exception  ex){
			return null;
		}
	}
}
