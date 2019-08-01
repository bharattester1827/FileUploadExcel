package testUploadFile;

//import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestingFileUPload {
	
	public static void main (String [] args ) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\BharatP\\eclipse-workspace\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        String baseUrl = "https://portal.leadforensics.com/DataManager/ImportData";
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        
        driver.get(baseUrl);
        driver.findElement(By.id("UserName")).sendKeys("lfoptimise");
        driver.findElement(By.id("Password")).sendKeys("ravinia2015");
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='outerBlock']/div[1]/div[1]/button")).click();
        
        Thread.sleep(5000);
        
        WebElement uploadElement = driver.findElement(By.id("FileUploader"));       
        
     // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\BharatP\\Documents\\TestUploadfile.xlsx");
        

	}
      

}
	
	
