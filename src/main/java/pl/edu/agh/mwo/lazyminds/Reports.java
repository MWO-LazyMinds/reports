package pl.edu.agh.mwo.lazyminds;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import pl.edu.agh.mwo.lazyminds.data.Reader;

public class Reports {

	public static void main(String[] args) {

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
			
			Reader reader=new Reader();

			ArrayList<Path> allFiles=reader.getAllFiles(args[0]);
			for (Path path: allFiles) {
				System.out.println("PLIK:\t"+path.toString());
				reader.readData(path);
			}
			
		}

		
	}

}
