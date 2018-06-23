package pl.edu.agh.mwo.lazyminds;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import pl.edu.agh.mwo.lazyminds.data.Reader;
import pl.edu.agh.mwo.lazyminds.model.User;
import pl.edu.agh.mwo.lazyminds.model.WorkUnit;

public class Reports {

	public static void main(String[] args) {

		// SETUP glownej kolekcji
		HashSet<User> allUsers=new HashSet<User>();

		// pobieranie wszystkich plikow
		Reader reader=new Reader();
		ArrayList<Path> allFiles=reader.getAllFiles(args[0]);
		for (Path path: allFiles) {
			// na potrzeby testowe
			//System.out.println("PLIK:\t"+path.toString());
			
			// ustalenie name i surname dla User
			Path newPath=path.getFileName();
			String fileName=newPath.toString().replace(".xls", "");
			String[] nameAndSurname=fileName.split("_");
			String name=nameAndSurname[0];
			String surname=nameAndSurname[1];
			System.out.println("NAME: "+name);
			System.out.println("SURNAME: "+surname);
			// koniec ustawiania name i surname
			
			// current user
			User currentUser=null;
			// jesli ktorys user z allUsers ma takie imie i naziwko, to pobierz, jak nie to stworz
			
			for (User existingUser: allUsers) {
				if (existingUser.getName().equals(name) && existingUser.getSurname().equals(surname)) {
					currentUser=existingUser;
					break;
				}
			}
			if (currentUser==null) {
				currentUser=new User(name, surname);
				allUsers.add(currentUser);
			}
			
			// dodanie userowi kolejnych work unitow
			ArrayList<WorkUnit> newWorkUnits=reader.readData(path);
			for (WorkUnit wu: newWorkUnits) {
				currentUser.addWorkUnit(wu);
			}
		}
		
		// TEST zczytywania
		for (User user: allUsers) {
			System.out.println("USER: "+user.getName()+" "+user.getSurname());
			for (WorkUnit wk: user.getWorkUnits()) {
				System.out.println("\tPROJEKT: "+wk.getProject().getName()+", date: "+wk.getDate().toString()+", hours: "+wk.getHours());
			}
		}
		
		/// start UI 
		System.out.println("Witamy w systemie raportowania czasu pracy");

		try (Scanner scanner = new Scanner(System.in)) {
			String input = "";
			String submenu = "";
			while (true) {

				// Menu glowne uzytkownika
				System.out.println("Podaj numer operacji lub wpisz 'exit' jeśli chcesz zakończyć program.");
				System.out.println("1\tRoczny raport godzin dla pracowników.");
				System.out.println("2\tRoczny raport godzin dla projektów.");
				System.out.println("3\tRaport projektów pracownika.");
				System.out.println("4\tRaport nakładu pracy na projekt dla pracowników.");
				System.out.println("5\tRaport pracowników w danym projekcie");

				// odczytanie numeru opcji z menu 
				input = scanner.nextLine();
				System.out.println(input);
				
				
				// rozpoznanie zakonczenia programu
				
				if(input.equals("exit")) {
					System.out.println("Program poprawnie zakończył prace. Zapraszamy ponownie.");
					break;
				}
				
				int option;
				try {
					option = Integer.parseInt(input);
				} catch (NumberFormatException e) {
					System.out.println("Podaj liczbę z menu!");
					continue;
				}

				// obsluga wszystkich opcji menu
				switch (option) {
				case 1:
					System.out.println("Raport 1");
					System.out.println("Czy wyeksportować raport do PDF? Jeśli tak, wpisz 't'.");
					submenu = scanner.nextLine();
					if (submenu.equals("t")) {
						System.out.println("Eksport raportu do PDF...");
					}
					break;
				case 2:
					System.out.println("Raport 2");
					break;
				case 3:
					System.out.println("Raport 3");
					break;
				case 4:
					System.out.println("Raport 4");
					break;
				case 5:
					System.out.println("Raport 5");
					break;				

				}
			}
			
		}

		
	}

}
