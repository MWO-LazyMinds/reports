package pl.edu.agh.mwo.lazyminds.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Comparable<User> {

	private String name;
	private String surname;

	private List<WorkUnit> workUnits;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<WorkUnit> getWorkUnits() {
		return workUnits;
	}

	public void setWorkUnits(List<WorkUnit> workUnits) {
		this.workUnits = workUnits;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name,surname); 
	}

	@Override
	public boolean equals(Object user) {
		if (this.getName().equals(((User) user).getName()) && this.getSurname().equals(((User) user).getSurname()))
			return true;
		else {
			return false;
		}

	}
	
	public void addWorkUnit(WorkUnit workunit) {
		if (this.workUnits==null) {
			this.workUnits=new ArrayList<WorkUnit>();
		}
		workUnits.add(workunit);
	}

	public User(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	@Override
	public int compareTo(User o) {
		return this.getSurname().compareTo(o.getSurname());
	}

}
