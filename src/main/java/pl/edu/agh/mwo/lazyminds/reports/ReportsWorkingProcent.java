package pl.edu.agh.mwo.lazyminds.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import pl.edu.agh.mwo.lazyminds.model.User;
import pl.edu.agh.mwo.lazyminds.model.WorkUnit;

public class ReportsWorkingProcent {

    public void project2(HashSet<User> users) {

		ArrayList<User> reportUsers = new ArrayList<User>();
		ArrayList<Integer> hours = new ArrayList<Integer>();

		for (User user : users) {
			int totalHours = 0;
			for (WorkUnit wk : user.getWorkUnits()) {
				totalHours += wk.getHours();
			}
			reportUsers.add(user);
			hours.add(totalHours);
		}

		for (User user : reportUsers) {
			// index usera do czytania ilosci czasu
			int index=reportUsers.indexOf(user);
			// cazas usera w projektach
			HashMap<String, Integer> hoursInProject = new HashMap<String, Integer>();
			// zbieranie czasu
			for (WorkUnit wk : user.getWorkUnits()) {
				String projectName = wk.getProject().getName();

				if (hoursInProject.containsKey(projectName)) {
					// update wartosci
					hoursInProject.put(projectName, hoursInProject.get(projectName) + wk.getHours());
				} else {
					// stworz nowa wartosc
					hoursInProject.put(projectName, wk.getHours());

				}

			}
			// koniec zbierania czasu

			// raport:
			System.out.println("USER:"+user.getName()+" "+user.getSurname());
			for (String k: hoursInProject.keySet()) {
				double procent=(double)hoursInProject.get(k)*100.00/hours.get(index);
				System.out.println("\t"+"PROJEKT: "+k+", LICZBA GODZIN: "+procent+"%");
			}
			
			// koniec operacji na jednym userze
		}
	}
}