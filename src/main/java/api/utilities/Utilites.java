package api.utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Utilites {
	
	public Utilites() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isEmpty(String strElementValue)
	{   
        System.out.print("\n"+strElementValue);
        if(strElementValue != "" && strElementValue!= null && !strElementValue.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
	}
	
	
	@DataProvider(name="getAllData")	
	public Object[][] getSheetData() {
		Workbook book;
		Sheet sheet = null;

		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\dhava\\eclipse-workspace\\RestAssuredAutomation\\testData\\userData.xls");
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet("Sheet1");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;
	}
	 
	 @DataProvider(name = "provideLoginData")
	  
		 public Object[][] provideLoginData() {

				Object[][] data = new Object[4][2];

				// 1st row
				data[0][0] = "mngr57651";
				data[0][1] = "EmEpypa";
				//2nd row
				data[1][0] = "mngr576516";
				data[1][1] = "EmEpyp";
				//3rd row
				data[2][0] = "mngr57651";
				data[2][1] = "EmEpyp";
				//4th row
				data[3][0] = "mngr576516";
				data[3][1] = "EmEpypa";
				return data;
			}

	 

}
	 
