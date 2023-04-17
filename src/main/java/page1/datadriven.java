package page1;


import java.io.FileInputStream;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven {
	
	static String path="C:\\Users\\winni\\eclipse-workspace\\ApiRestAssured\\excelutility\\emplyeedata.xlsx";

	
    public static Object[][] excelDataReader(String path,String excelsheet) throws IOException {
	FileInputStream fis = new FileInputStream(path);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet(excelsheet);
	XSSFRow row = sheet.getRow(0);
	int noOfRows = sheet.getPhysicalNumberOfRows();
	int noOfCols = row.getPhysicalNumberOfCells();
	
	Object data[][] = new Object[noOfRows-1][noOfCols];
	
	for(int i=1; i<noOfRows; i++) {
		 for(int j = 0; j<noOfCols;j++) {
			Object cellData=sheet.getRow(i).getCell(j).getStringCellValue();
			 data[i-1][j] = cellData; 
			 System.out.println("Data "+data[i-1][j]);
		 }
		 System.out.println();
	}
	
	return data;
}
    
}
