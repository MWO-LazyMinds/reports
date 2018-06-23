package pl.edu.agh.mwo.lazyminds.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import pl.edu.agh.mwo.lazyminds.model.Project;
import pl.edu.agh.mwo.lazyminds.model.WorkUnit;

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
	public ArrayList<WorkUnit> readData(Path path) {
		// otwarcie pliku
		ArrayList<WorkUnit> workUnits=new ArrayList<WorkUnit>();
		try {
			Workbook wb = WorkbookFactory.create(path.toFile());
			// pobranie wszystkich sheet'ow
			Iterator<Sheet> sheets=wb.sheetIterator();
			while (sheets.hasNext()) {
				Sheet sheet=sheets.next();
				String projectName=sheet.getSheetName();
				// projekt
				Project project=new Project(projectName);
				//System.out.println("PROJECT:\t"+projectName);
				// pobieranie wierszy
				int numberOfRows = sheet.getPhysicalNumberOfRows();
				// bez naglowka dlatego start 1
				middle: for (int j=1;j<numberOfRows;j++) {
					Row row = sheet.getRow(j);
					// narazie bez walidacji
					Date date=null;
					String note="";
					int hours=0;
					for (int c = 0; c < 3; c++) {
						Cell cell = row.getCell(c);
						switch (c) {
						case 0:
							date=cell.getDateCellValue();
							if (date==null) {
								System.out.println("ERROR: bledna komorka");
								continue middle;
							}
							break;
						case 1:
							note=cell.getStringCellValue();
							if (note==null) {
								System.out.println("ERROR: bledna komorka");
								continue middle;
							}

							break;
						case 2:
							Double dhours=cell.getNumericCellValue();
							hours=dhours.intValue();
							if (hours < 1) {
								System.out.println("ERROR: bledna komorka");
								continue middle;
							}

							break;
						}
					}
					// na potrzeby testowe
					//System.out.println("projekt: "+projectName+", data: "+date+", note: "+note+", hours: "+hours);
					WorkUnit workunit=new WorkUnit(project, date, note, hours);
					workUnits.add(workunit);
				}
				
			}
		

		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return workUnits;
	}

}
