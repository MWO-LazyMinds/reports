package pl.edu.agh.mwo.lazyminds.data.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import pl.edu.agh.mwo.lazyminds.model.User;
import pl.edu.agh.mwo.lazyminds.model.WorkUnit;

public class DataImport {

	
	public static void main(String[] args) throws IOException{
		
		ArrayList<String> listOfFiles = new ArrayList<String>();
		listOfFiles.add("Kowalski_Jan.xls");
		//listOfFiles.add("Nowak_Piotr.xls");
		
		for (String fileName : listOfFiles) {
			FileInputStream file = new FileInputStream(new File(fileName));
			
			
			HSSFWorkbook wb = new HSSFWorkbook(file);

			
			DataFormatter formatter = new DataFormatter();
		    Sheet sheet1 = wb.getSheetAt(0);
		    for (Row row : sheet1) {
		        for (Cell cell : row) {
		            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
		           
		            String text = formatter.formatCellValue(cell);
		        
		            switch (cell.getCellType()) {
		                
		            case Cell.CELL_TYPE_STRING:
		            	System.out.print(cell.getStringCellValue()+"\t");
		            	break;
		                case Cell.CELL_TYPE_NUMERIC:
		                    if (DateUtil.isCellDateFormatted(cell)) {
		                        System.out.print(cell.getDateCellValue()+"\t");
		                    } else {
		                        System.out.print(cell.getNumericCellValue()+"\t");
		                    }
		                    break;
		                case Cell.CELL_TYPE_BOOLEAN:
		                    System.out.print(cell.getBooleanCellValue()+"\t");
		                    break;
		               
		            }
		            
		        }
		    }System.out.println("\n");
			
		}	
		
		
		
		
	}
	
	public User mapPersonFromExcel(String fineName) throws IOException{
		
		FileInputStream file = new FileInputStream(new File(fineName));
		
		HSSFWorkbook wb = new HSSFWorkbook(file);
		User user = new User();
		List<WorkUnit> workUnits = user.getWorkUnits();
		workUnits= new ArrayList<WorkUnit>();
		
		DataFormatter formatter = new DataFormatter();
	    Sheet sheet1 = wb.getSheetAt(0);
	    for (Row row : sheet1) {
	        for (Cell cell : row) {
	            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
	           
	            String text = formatter.formatCellValue(cell);
	        
	            switch (cell.getCellType()) {
	                
	            case Cell.CELL_TYPE_STRING:
	            	System.out.print(cell.getStringCellValue()+"\t");
	            	break;
	                case Cell.CELL_TYPE_NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell)) {
	                        System.out.print(cell.getDateCellValue()+"\t");
	                    } else {
	                        System.out.print(cell.getNumericCellValue()+"\t");
	                    }
	                    break;
	                case Cell.CELL_TYPE_BOOLEAN:
	                    System.out.print(cell.getBooleanCellValue()+"\t");
	                    break;
	               
	            }
	            
	        }
	    }System.out.println("\n");
		return user;
		
		
	}
}


	
	
	
	

