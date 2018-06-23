package pl.edu.agh.mwo.lazyminds.model;

import java.util.Objects;

public class Project {
	
	public Project(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.name); 
	}

	@Override
	public boolean equals(Object project) {
		if (this.getName().equals(((Project) project).getName()))
			return true;
		else {
			return false;
		}

	}

}
