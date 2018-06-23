package pl.edu.agh.mwo.lazyminds.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reader {
	// metoda do pobrania wszsystkich plikow
	public ArrayList<Path> getAllFiles(String path) {
		ArrayList<Path> filesPaths = new ArrayList<Path>();
		try {
			Files.walk(Paths.get(path)).filter(Files::isRegularFile).filter(p -> p.toString().endsWith(".xls"))
					.forEach(filesPaths::add);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filesPaths;
	}
	// 2. metoda do parsowania plikow Excel, t.j. zamiany na Users, WorkUnit i
	// Project - zwracanie listy wszystkich obiektow User
	
	// otwieranie excela
	public void readData(Path path) {
		// otwarcie pliku
		// ustalenie name i surname dla User
		Path newPath=path.getFileName();
		String fileName=newPath.toString().replace(".xls", "");
		String[] nameAndSurname=fileName.split("_");
		String name=nameAndSurname[0];
		String surname=nameAndSurname[1];
		// koniec ustawiania name i surname
		try {
			Workbook wb = WorkbookFactory.create(path.toFile());
			// pobranie wszystkich sheet'ow
			Iterator<Sheet> sheets=wb.sheetIterator();
			while (sheets.hasNext()) {
				Sheet sheet=sheets.next();
				String projectName=sheet.getSheetName();
				System.out.println("PROJECT:\t"+projectName);
				// pobieranie wierszy
				int numberOfRows = sheet.getPhysicalNumberOfRows();
				// bez naglowka dlatego start 1
				for (int j=1;j<numberOfRows;j++) {
					Row row = sheet.getRow(j);
					// narazie bez walidacji
					String date="";
					String note="";
					String hours="";
					for (int c = 0; c < 3; c++) {
						Cell cell = row.getCell(c);
						switch (c) {
						case 0:
							date=cell.toString();
							break;
						case 1:
							note=cell.toString();
							break;
						case 2:
							hours=cell.toString();
							break;
						}
					}
					System.out.println("imie: "+name+", nazwisko: "+surname+", projekt: "+projectName+", data: "+date+", note: "+note+", hours: "+hours);
				}
				
			}
			// utworzenie Usera
		

		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
