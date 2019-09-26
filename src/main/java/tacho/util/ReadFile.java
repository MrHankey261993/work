package tacho.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tacho.model.Driver;

public class ReadFile {
	private static FileInputStream fis;
	
	
	public static ObservableList<Driver> getListDriver() {
		try {
			ObservableList<Driver> drivers = FXCollections.observableArrayList();
			FileInputStream fis = new FileInputStream(new File("C:/demo/ТахографВодители.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Driver driver = new Driver();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
					if(cell.getColumnIndex() == 0) {
						StringProperty name = new SimpleStringProperty(cell.getStringCellValue());
						driver.setNameProperty(name);
					} else {
						switch (cell.getCellTypeEnum()) {
						case STRING:						
							StringProperty interval = new SimpleStringProperty(""+cell.getStringCellValue());
							driver.getIntervals().add(interval.get());
							break;
						case NUMERIC:
							interval = new SimpleStringProperty(""+cell.getNumericCellValue());
							driver.getIntervals().add(interval.get());
							break;
						case BLANK:
							break;
						}
					}
					 
				}
				drivers.add(driver);
			}
			workbook.close();
			return drivers;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		

		

	}
	
	public static void addDriver(String name) throws IOException {
	//	Driver driver = new Driver();
	//	driver.setName(name);
	//	drivers.add(driver);
		fis = new FileInputStream(new File("C:/demo/ТахографВодители.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getPhysicalNumberOfRows();
		Row row = sheet.createRow(++lastRow);
		row.createCell(0).setCellValue(name);
		fis.close();
		
		FileOutputStream fos = new FileOutputStream("C:/demo/ТахографВодители.xlsx");
		workbook.write(fos);
		fos.close();
        
	}
}
