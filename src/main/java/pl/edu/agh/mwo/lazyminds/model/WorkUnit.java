package pl.edu.agh.mwo.lazyminds.model;

import java.util.Date;

public class WorkUnit {
	
	private Project project;
	
	private Date date;
	
	private String note;
	
	private int hours;
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public WorkUnit(Project project, Date date, String note, int hours) {
		super();
		this.project = project;
		this.date = date;
		this.note = note;
		this.hours = hours;
	}

}
