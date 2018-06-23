package pl.edu.agh.mwo.lazyminds;

import java.util.Calendar;

public class WorkUnit {
	
	private Project project;
	
	private Calendar date;
	
	private String note;
	
	private int hours;
	
	

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

}
