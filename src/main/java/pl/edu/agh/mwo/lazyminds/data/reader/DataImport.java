package pl.edu.agh.mwo.lazyminds.data.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Sheet;

import pl.edu.agh.mwo.lazyminds.model.User;
import pl.edu.agh.mwo.lazyminds.model.WorkUnit;

public class DataImport {

	public static void main(String[] args) throws IOException, ParseException {

		ArrayList<String> listOfFiles = new ArrayList<String>();
		ArrayList<User> listOfUsers = new ArrayList<User>();

		listOfFiles.add("C:\\Users\\Pawe³\\git\\reports\\resources\\reporter-dane\\2012\\01\\Kowalski_Jan.xls"); 
		listOfFiles.add("C:\\Users\\Pawe³\\git\\reports\\resources\\reporter-dane\\2012\\01\\Nowak_Piotr.xls");
		listOfFiles.add("C:\\Users\\Pawe³\\git\\reports\\resources\\reporter-dane\\2012\\02\\Kowalski_Jan.xls");

		for (String fileName : listOfFiles) {
			List<String> rawWorkUnits = new ArrayList<String>();
			WorkUnit workUnit = new WorkUnit();
			FileInputStream file = new FileInputStream(new File(fileName));
			HSSFWorkbook wb = new HSSFWorkbook(file);

			User currentUser = new User();
			int index = fileName.lastIndexOf("\\");
			String[] names = fileName.substring(index + 1).split("_");

			currentUser.setName(names[0]);
			currentUser.setSurname(names[1].replace(".xls", ""));
			// System.out.println(currentUser.getName() + " " + currentUser.getSurname());
			String name = currentUser.getName();
			String surname = currentUser.getSurname();
			if (listOfUsers.contains(currentUser)) {
				currentUser = listOfUsers.get(listOfUsers.indexOf(currentUser));
			} else {
				listOfUsers.add(currentUser);
			}

			// System.out.println(listOfUsers.size());

			int i = 0;

			while (i < wb.getNumberOfSheets()) {
				Sheet sheet = wb.getSheetAt(i);
				int j = 1;

				System.out.println("User: " + name + " " + surname + " - arkusz: " + i +"\n");

				int numberOfRows = sheet.getPhysicalNumberOfRows();
				int numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
				// System.out.print(numberOfRows + " " + numberOfColumns);
				while (j < numberOfRows) {

					int k = 0;
					String rawRow = "";
					List<String> dates = new ArrayList<String>();
					List<String> notes = new ArrayList<String>();
					List<Double> hours = new ArrayList<Double>();

					while (k <= numberOfColumns) {
						try {
							rawRow += (sheet.getRow(j).getCell(k).toString() + "|");
						} catch (NullPointerException n) {
							// System.out.println("Koniec zakresu");
						}
						k++;
					}
					rawRow += sheet.getSheetName();
					// System.out.println(rawRow);
					j++;
					String[] splitted = rawRow.split("|");
					// System.out.println(splitted.length);
					// if (splitted.length == 4) {
					// dates.add(splitted[0]);
					// notes.add(splitted[1]);
					// hours.add(Double.valueOf(splitted[2]));
					// }

					System.out.println(rawRow);
					
				}
				i++;}

		}
	}
}
