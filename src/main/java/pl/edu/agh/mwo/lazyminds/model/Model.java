package pl.edu.agh.mwo.lazyminds.model;

import java.util.List;

public class Model {

	private List<User> userList;
	private List<Project> projectList;
	
	public Model( List<User> userList, List<Project> projectList) {
		this.userList = userList;
		this.projectList = projectList;

	}
}
