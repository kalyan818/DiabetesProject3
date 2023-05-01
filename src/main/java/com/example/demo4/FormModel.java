package com.example.demo4;

import java.sql.Time;

public class FormModel {

	private String Date; // variable for storing the date when the form is submitted
	private String Time1; // variable for storing the time when the user took blood sugar level before
								// eating
	private String Sugar_Level1; // variable for storing the blood sugar level of the user before eating
	private String Time2; // variable for storing the time when the user took blood sugar level after
								// eating
	private String Sugar_Level2; // variable for storing the blood sugar level of the user after eating
	private String BreakFast; // variable for storing the breakfast details of the user
	private String Lunch; // variable for storing the lunch details of the user
	private String Dinner; // variable for storing the dinner details of the user
	
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime1() {
		return Time1;
	}
	public void setTime1(String time1) {
		Time1 = time1;
	}
	public String getSugar_Level1() {
		return Sugar_Level1;
	}
	public void setSugar_Level1(String sugar_Level1) {
		Sugar_Level1 = sugar_Level1;
	}
	public String getTime2() {
		return Time2;
	}
	public void setTime2(String time2) {
		Time2 = time2;
	}
	public String getSugar_Level2() {
		return Sugar_Level2;
	}
	public void setSugar_Level2(String sugar_Level2) {
		Sugar_Level2 = sugar_Level2;
	}
	public String getBreakFast() {
		return BreakFast;
	}
	public void setBreakFast(String breakFast) {
		BreakFast = breakFast;
	}
	public String getLunch() {
		return Lunch;
	}
	public void setLunch(String lunch) {
		Lunch = lunch;
	}
	public String getDinner() {
		return Dinner;
	}
	public void setDinner(String dinner) {
		Dinner = dinner;
	}
	@Override
	public String toString() {
		return "FormModel [Date=" + Date + ", Time1=" + Time1 + ", Sugar_Level1=" + Sugar_Level1 + ", Time2=" + Time2
				+ ", Sugar_Level2=" + Sugar_Level2 + ", BreakFast=" + BreakFast + ", Lunch=" + Lunch + ", Dinner="
				+ Dinner + "]";
	}
	
}
