package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {
	
	public static WebDriver driver;
	public static Actions a;
	public static JavascriptExecutor js;
	public static TakesScreenshot ss;
	public static Robot r;
	
	public static void launch() {
		
		driver=new ChromeDriver();

	}
	
	public static String siteGet(String path) {
		
		driver.get(path);
		
		return path;

	}
	
	public static void toMax() {
		
		driver.manage().window().maximize();

	}
	
	public static void toWait() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	public static void titleAndurl() {
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	} 
	
	public static void sendKeys(WebElement element,String element1) {
		
		element.sendKeys(element1);

	}
	
	public static void getText(String element1,WebElement element) {
		 
		System.out.println(element1+element.getText());

	}
	
	//ACTIONS METHODS
	
	public static void acIntialize() {
		
		if(a==null) {
			a=new Actions(driver);
		}

	}
	
	public static void acMove(WebElement element) {
		
		if(a==null) {
			acIntialize();
		}
		
		a.moveToElement(element).perform();
	}
	
	public static void acSendkeys(WebElement element,String element1) {
		
		if(a==null) {
			acIntialize();
		}
		
		a.sendKeys(element, element1).perform();

	}
	
	public static void acClick(WebElement element) {
		
		if(a==null) {
			acIntialize();
		}
		
		a.click(element).perform();

	}
	
	public static void acDoubleclick(WebElement element) {
		
		if(a==null) {
			acIntialize();
		}
		
		a.doubleClick(element).perform();

	}
	
	public static void acContextclick(WebElement element) {
		
		if(a==null) {
			acIntialize();
		}
		
		a.contextClick(element).perform();

	}
	
	//JAVASCRIPT METHODS
	
	public static void jsIntialize() {
		
		if(js==null) {
			js=(JavascriptExecutor)driver;
		}

	}
	
	public static void jsSetattribute(WebElement element,String element1) {
		
		if(js==null) {
			jsIntialize();
		}
		
		js.executeScript("arguments[0].setAttribute('value',arguments[1])", element,element1);

	}
	
	public static void jsClick(WebElement element) {
		
		if(js==null) {
			jsIntialize();
		}
		
		js.executeScript("arguments[0].click()", element);

	}
	
	public static void jsScrolldown(WebElement element) {
		
		if(js==null) {
			jsIntialize();
		}
		
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}
	
	public static void jsScrollup(WebElement element) {
		
		if(js==null) {
			jsIntialize();
		}
		
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}
	
	//TAKE SCREENSHOT
	
	public static void screenShot(String path) throws IOException {
		
		if(ss==null) {
			ss=(TakesScreenshot)driver;
		}
		
		File src = ss.getScreenshotAs(OutputType.FILE);
		
		File des=new File(path);
		
		FileUtils.copyFile(src, des);

	}
	
	
	//ROBOT
	
	public static void robIntialize() throws AWTException {
		
		if(r==null) {
			r=new Robot();
		}

	}
	
	public static void robControl() throws AWTException {
		
		if(r==null) {
			robIntialize();
		}
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);

	}
	
	public static void robDown() throws AWTException {
		
		if(r==null) {
			robIntialize();
		}
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}
	
	
	public static void robEnter() throws AWTException {
		
		if(r==null) {
			robIntialize();
		}
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		

	}
	
	public static String excel(String path, String sheetName, int rowNo, int cellNo) throws IOException {
		
		File f=new File(path);
		
		FileInputStream fin=new FileInputStream(f);
		
		Workbook book=new XSSFWorkbook(fin);
		
		Sheet sheet = book.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNo);
		
		Cell cell = row.getCell(cellNo);
		
		int cellType = cell.getCellType();
		
		String name="";
		
		if(cellType==1) {
			
			name = cell.getStringCellValue();
			System.out.println(name);
			
		}
		else if(DateUtil.isCellDateFormatted(cell)) {
			
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat("dd/MMM/yyyy");
			
		}
		
		else {
			
			double numericCellValue = cell.getNumericCellValue();
			long l=(long)numericCellValue;
			String valueOf = String.valueOf(l);
			System.out.println(valueOf);
			
		}
		
		return name;
		
	}
	
	
	
	
	
	
	
	
}
