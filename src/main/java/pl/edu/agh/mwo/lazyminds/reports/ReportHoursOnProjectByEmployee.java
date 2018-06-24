package pl.edu.agh.mwo.lazyminds.reports;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

import pl.edu.agh.mwo.lazyminds.model.Project;
import pl.edu.agh.mwo.lazyminds.model.User;
import pl.edu.agh.mwo.lazyminds.model.WorkUnit;

public class ReportHoursOnProjectByEmployee {

	@SuppressWarnings("deprecation")
	public void generate(HashSet<User> users, int year, String employee) {
		
		HashMap<Project, Integer> projectAndHours = new HashMap<Project,Integer>();
		HashMap<Project, Date> projectAndDates = new HashMap<Project,Date>();
		
		String[] splitted = employee.split("_");
		String surname = splitted[0];
		String name  =splitted[1];
		//System.out.println(name+" "+surname);
		for (User user : users) {
			
			if (user.getName().equals(name)&&user.getSurname().equals(surname)){
				//System.out.println(user.getName()+" "+user.getSurname());
				
				for (WorkUnit wk : user.getWorkUnits()) {
					//System.out.println(wk.getDate());
					//System.out.println(wk.getDate().getYear());
					if (wk.getDate().getYear()==year-1900){
						System.out.println(wk.getProject().getName());
						projectAndDates.put(wk.getProject(),wk.getDate());
						projectAndHours.put(wk.getProject(),wk.getHours());
				
			}
	
			
				
				
				
			
			}
			
			}

		}
		//System.out.println(projectAndDates.size());
	}
}