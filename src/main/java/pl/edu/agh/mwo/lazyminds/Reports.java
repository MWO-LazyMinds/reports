package pl.edu.agh.mwo.lazyminds;

import java.util.Scanner;

public class Reports {
	
	public static void askForReport() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Czy wyeksportowaæ raport do PDF? Jeœli tak, wpisz 't'.");
		String submenu = "";
		submenu = scanner.nextLine();
		if (submenu.equals("t")) {
			System.out.println("Eksport raportu do PDF...");
		} else {
			System.out.println("Raport nie zostanie wyeksportowany do PDF. Powrót do menu g³ównego.\n");
		}
	}

	public static void main(String[] args) {

		System.out.println("Witamy w systemie raportowania czasu pracy");

		try (Scanner scanner = new Scanner(System.in)) {
			String input = "";
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
				if (input.equals("exit")) {
					System.out.println("Program poprawnie zakoñczy³ pracê. Zapraszamy ponownie.");
					break;
				}

				// rozpoznawanie czy u¿ytkownik wpisa³ poprawn¹ wartoœæ opcji z menu
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
					askForReport();
					break;
				case 2:
					System.out.println("Raport 2");
					askForReport();
					break;
				case 3:
					System.out.println("Raport 3");
					askForReport();
					break;
				case 4:
					System.out.println("Raport 4");
					askForReport();
					break;
				case 5:
					System.out.println("Raport 5");
					askForReport();
					break;
				}
			}
		}

	}

}
