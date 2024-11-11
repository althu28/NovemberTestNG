package org.package2;


import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.baseclass.BaseClass;
import org.checkerframework.checker.units.qual.m2;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hello1 extends BaseClass {

	@BeforeClass
	private void bfc() {
		// TODO Auto-generated method stub
		
		launch();
		siteGet("https://www.youtube.com/");
		toMax();
		toWait();

	}
	
	@AfterClass
	private void afc() {
		
		driver.quit();

	}
	
	@BeforeMethod
	private void bfm() {
		
		Date d=new Date();
		System.out.println(d);

	}
	
	@AfterMethod
	private void afm() {
		
		Date d=new Date();
		System.out.println(d);

	}
	
	@Test(priority = 3)
	private void m_2() {
		// TODO Auto-generated method stub
		
		WebElement exitFullScreen = driver.findElement(By.xpath("//button[@title=\"Exit full screen (f)\"]"));
		acMove(exitFullScreen);
		acClick(exitFullScreen);
	

	}
	
	@Test(priority = 2)
	private void m_1() throws IOException {
		// TODO Auto-generated method stub
		
		screenShot("C:\\Users\\sheik althaf hussain\\eclipse-workspace\\AlthafMaven\\DataDrivenAlthaf\\Screenshots\\Beast Scene.png");
		

	}
	
	@Test(priority = 1)
	private void m0() throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebElement fullScreen = driver.findElement(By.xpath("//button[@title=\"Full screen (f)\"]"));
		acMove(fullScreen);
		acClick(fullScreen);
		
		Thread.sleep(60000);

	}
	
	@Test(enabled = false,priority = 0)
	private void m1() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 5; i++) {
			
			System.out.println("THIS TEST CASE NOT ENABLED!");
		}

	}
	
	@Test(priority = -1)
	private void m2() {
		// TODO Auto-generated method stub
		
		//video thumbnail
		
		WebElement thumbnail = driver.findElement(By.xpath("(//img[@style=\"background-color: transparent;\"])[21]"));
		acMove(thumbnail);
		acClick(thumbnail);

	}
	
	@Test(priority = -2)
	private void m3() throws IOException {
		
		//Searching the video
		
		WebElement search = driver.findElement(By.xpath("//input[@id=\"search\"]"));
		acSendkeys(search, excel("C:\\Users\\sheik althaf hussain\\eclipse-workspace\\AlthafMaven\\DataDrivenAlthaf\\Excel\\Youtube.xlsx", "Sheet1", 1, 0));
		
		
		//Search button click
		
		WebElement searchButton = driver.findElement(By.xpath("//button[@id=\"search-icon-legacy\"]"));
		jsClick(searchButton);

	}
	
}
