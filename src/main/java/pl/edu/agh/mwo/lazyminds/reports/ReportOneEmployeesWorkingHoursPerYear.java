package pl.edu.agh.mwo.lazyminds.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import pl.edu.agh.mwo.lazyminds.model.User;
import pl.edu.agh.mwo.lazyminds.model.WorkUnit;

public class ReportOneEmployeesWorkingHoursPerYear {

	public void generate(HashSet<User> users, int year) {

		HashMap<User, Integer> hmap = new HashMap<User, Integer>();

		for (User user : users) {
			int totalHours = 0;
			List<WorkUnit> workunits = user.getWorkUnits();
			if (workunits != null) {
				for (WorkUnit wk : workunits) {
					totalHours += wk.getHours();
				}
			}
			hmap.put(user, totalHours);
		}
		SortedSet<User> keys = new TreeSet<User>(hmap.keySet());
		System.out.println("RAPORT 1:");
		System.out.println("IMIE\tNAZIWSKO\tGODZINY");
		for (User key : keys) {
			String name = key.getName();
			String surname = key.getSurname();
			Integer value = hmap.get(key);
			System.out.println(name + "\t" + surname + "\t" + value);
		}
	}
}
