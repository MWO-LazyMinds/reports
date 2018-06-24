package pl.edu.agh.mwo.lazyminds.reports;

import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

import pl.edu.agh.mwo.lazyminds.model.User;
import pl.edu.agh.mwo.lazyminds.model.WorkUnit;

public class ReportHoursOnProjectByEmployee {

	public void generate(HashSet<User> users, int year) {

		HashMap<User, WorkUnit> hmap = new HashMap<User, WorkUnit>();

		for (User user : users) {

			for (WorkUnit wk : user.getWorkUnits()) {

			}

		}
	}
}
