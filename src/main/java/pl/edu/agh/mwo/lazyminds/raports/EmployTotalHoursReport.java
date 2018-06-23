package pl.edu.agh.mwo.lazyminds.raports;

import java.util.HashMap;
import java.util.List;

import pl.edu.agh.mwo.lazyminds.model.User;
import pl.edu.agh.mwo.lazyminds.model.WorkUnit;

public class EmployTotalHoursReport {
	

	public String calculate(){ 
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
		List<User> users = null;
		int totalTime = 0;
		
		for (User user: users) {
			String userdata = user.getName()+ " " + user.getSurname();
				
			for ( WorkUnit unit: user.getWorkUnits()) {
				totalTime = unit.getHours()+ totalTime;
			}
			hmap.put(userdata, totalTime);
		}
		
		System.out.println(hmap.toString());
		
		return null;
				
	}
}
	
		
		
