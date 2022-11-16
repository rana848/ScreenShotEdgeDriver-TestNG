package edgedriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class edgedriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "D:\\Edgedriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/index.html");
		// ----------Take a screenshot and save them in mypicture folder in edgedriver
	//	Date currentDate = new Date();
		//String actualDate = currentDate.toString().replace(":", "-");

		//TakesScreenshot src = ((TakesScreenshot) driver);
		//File SrcFile = src.getScreenshotAs(OutputType.FILE);
	//	File Dest = new File(".\\mypictures/" + actualDate + ".png");
		//FileUtils.copyFile(SrcFile, Dest);
		
		
		//------print the total number of items
		
		
		List<WebElement> theStudent =driver.findElements(By.tagName("option"));
		int theTotalStudent=theStudent.size();
		System.out.println(theTotalStudent+"this the total student number");
		
		
		// ---------delete 3 items in the website
		int HowManyItem = 10;
		System.out.println(HowManyItem+"this the items i want remove");
		for (int i = 0; i < HowManyItem; i++) {
			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();}
		//---------delete all items
		//for (int i = 0; i < theStudent.size(); i++) {
			//driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();}
		
		List<WebElement> theStudentafterremoved =driver.findElements(By.tagName("option"));
		int actual=theStudentafterremoved.size();
		System.out.println(actual+"this the student num after removed");
		
		int expectedItem=theTotalStudent-HowManyItem;
		System.out.println(expectedItem+"this the ecpected item");
		Assert.assertEquals(actual, expectedItem);
	
		

	}

}
