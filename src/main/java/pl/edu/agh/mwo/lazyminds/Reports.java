package pl.edu.agh.mwo.lazyminds;

import java.util.Scanner;

public class Reports {

	public static void main(String[] args) {

		System.out.println("Witamy w systemie raportowania czasu pracy");

		try (Scanner scanner = new Scanner(System.in)) {
			String input = "";
			String submenu = "";
			while (true) {

				// Menu g³ówne u¿ytkownika
				System.out.println("Podaj numer operacji lub wpisz 'exit' jeœli chcesz zakoñczyæ program.");
				System.out.println("1\tRoczny raport godzin dla pracowników.");
				System.out.println("2\tRoczny raport godzin dla projektów.");
				System.out.println("3\tRaport projektów pracownika.");
				System.out.println("4\tRaport nak³adu pracy na projekt dla pracowników.");
				System.out.println("5\tRaport pracowników w danym projekcie");

				// odczyt opcji menu u¿ytkownika
				input = scanner.nextLine();
				System.out.println(input);
				
				
				// rozpoznanie zakoñczenia programu
				
				if(input.equals("exit")) {
					System.out.println("Program poprawnie zakoñczy³ pracê. Zapraszamy ponownie.");
					break;
				}
				

				int option;
				try {
					option = Integer.parseInt(input);
				} catch (NumberFormatException e) {
					System.out.println("Podaj liczbê z menu!");
					continue;
				}

				// obs³uga opcji menu
				switch (option) {
				case 1:
					System.out.println("Raport 1");
					System.out.println("Czy wyeksportowaæ raport do PDF? Jeœli tak, wpisz 't'.");
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
