package pl.edu.agh.mwo.lazyminds.helpers;

import java.util.Comparator;

import pl.edu.agh.mwo.lazyminds.model.User;

public class SortBySurname implements Comparator<User> {

	@Override
	public int compare(User u1, User u2) {
		return u1.getSurname().compareTo(u2.getSurname());
	}

}
