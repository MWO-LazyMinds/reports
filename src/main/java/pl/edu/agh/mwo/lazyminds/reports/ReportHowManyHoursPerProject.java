package pl.edu.agh.mwo.lazyminds.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import pl.edu.agh.mwo.lazyminds.model.Project;
import pl.edu.agh.mwo.lazyminds.model.User;
import pl.edu.agh.mwo.lazyminds.model.WorkUnit;

public class ReportHowManyHoursPerProject {

	@SuppressWarnings("deprecation")
	public void generate(HashSet<User> users, int year) {

		List<Project> projectList = new ArrayList<Project>();
		HashMap<Project, Integer> hmap = new HashMap<Project, Integer>();
		int totalHours = 0;
		year = year - 1900;
		for (User user : users) {

			// wczytywanie projektów do listy
			for (WorkUnit wk : user.getWorkUnits()) {
				if (wk.getDate().getYear() == year) {

					if (!projectList.contains(wk.getProject())) {
						projectList.add(wk.getProject());

					}
				}

			}
		}

		for (Project project : projectList) {
			int total = 0;
			for (User user : users) {
				int totalPerUser = 0;
				for (WorkUnit wk : user.getWorkUnits()) {

					if (project.getName().equals(wk.getProject().getName()) && wk.getDate().getYear() == year) {
						totalPerUser += wk.getHours();
					}
				}
				total = total + totalPerUser;
			}
			hmap.put(project, total);
		}

		SortedSet<Project> keys = new TreeSet<Project>(hmap.keySet());
		System.out.println("RAPORT 2:");
		System.out.println("Projekt\tGODZINY");
		for (Project key : keys) {
			String name = key.getName();
			Integer value = hmap.get(key);
			System.out.println(name + "\t" + value);
		}

	}
	
	
	//metoda używana do statystyki nr 4 
	@SuppressWarnings("deprecation")
	public HashMap<Project, Integer> getHashMap(HashSet<User> users, int year) {

		List<Project> projectList = new ArrayList<Project>();
		HashMap<Project, Integer> hmap = new HashMap<Project, Integer>();
		int totalHours = 0;
		year = year - 1900;
		for (User user : users) {

			// wczytywanie projektów do listy
			for (WorkUnit wk : user.getWorkUnits()) {
				if (wk.getDate().getYear() == year) {

					if (!projectList.contains(wk.getProject())) {
						projectList.add(wk.getProject());

					}
				}

			}
		}

		for (Project project : projectList) {
			int total = 0;
			for (User user : users) {
				int totalPerUser = 0;
				for (WorkUnit wk : user.getWorkUnits()) {

					if (project.getName().equals(wk.getProject().getName()) && wk.getDate().getYear() == year) {
						totalPerUser += wk.getHours();
					}
				}
				total = total + totalPerUser;
			}
			hmap.put(project, total);
		}


		return hmap;
	}
	
	
	
}
