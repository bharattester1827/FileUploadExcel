package testUploadFile;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetFares {
	
	@SuppressWarnings("unlikely-arg-type")
	public static void main (String [] args ) throws InterruptedException {

	System.setProperty("webdriver.gecko.driver", "C:\\Users\\BharatP\\eclipse-workspace\\geckodriver-v0.24.0-win64\\geckodriver.exe");
    String baseUrl = "https://test-dti.evolviuat.com/logon.aspx";
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    String selfprint = " SelfPrint ";
    String mobileticket = " MobileTicket ";
    
    
    driver.get(baseUrl);
    driver.findElement(By.id("ctl00_MasterContent_LogonWebPart_Email")).sendKeys("bharat.patel@evolvi.co.uk");
    driver.findElement(By.id("ctl00_MasterContent_LogonWebPart_Password")).sendKeys("Evolvi27@");
    driver.findElement(By.id("ctl00_MasterContent_LogonWebPart_SubmitButton")).click();
    driver.findElement(By.id("IsUkRailSingleLabel")).click();
    driver.findElement(By.id("ctl00_MasterContent_JourneySearchWebPart_UkRailWebPart_FromStationTextBox_Station")).sendKeys("Newcastle");
    driver.findElement(By.id("ctl00_MasterContent_JourneySearchWebPart_UkRailWebPart_ToStationTextBox_Station")).sendKeys("Edinburgh");
    driver.findElement(By.id("ctl00_MasterContent_JourneySearchWebPart_UkRailWebPart_SearchButton")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("#SelfPrint")).click();
    
    ////div[@id='ctl00_MasterContent_FareOptionsWebPart_FareFiltering']/div[2]/div[1]/div[4]/input
    //driver.findElement(By.id("IsUkRailSingleLabel")).click();
    //driver.findElement(By.id("IsUkRailSingleLabel")).click();
    
    WebElement table = driver.findElement(By.xpath("//div[@class='rowFareOptionDetail SingleFares']"));  
    List <WebElement> aa = table.findElements(By.xpath("//div[starts-with(@data-fulfilment, 'ToD Kiosk SelfPrint ') | (@data-fulfilment, 'ToD Kiosk SelfPrint MobileTicket ')]"));
    System.out.println(aa.size());
    
    JavascriptExecutor jse2 = (JavascriptExecutor)driver;
    jse2.executeScript("window.scrollBy (0,1500)", aa); 
    
   //"//input[substring(@id, string-length(@id) - string-length('_PHONE$1') +1) = '_PHONE$1']"




    
    
    
    for (WebElement nn : aa) {
    	
    	
    	
    	
    	if (nn.equals(selfprint)) {
    		nn.click();
    		break;
    	} else if (nn.equals(mobileticket)) {
    		nn.click();
    		break;
    	} else {
    		System.out.println(" No SelfPrint and Mobile Ticket available. ");
    	}
    	
    	
    	
    }
    
    
    
    
    /*for (WebElement nn : aa) {
    	System.out.println(nn.getText());
    	if (nn.isDisplayed()) {
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
   		 executor.executeScript("arguments[0].click();", nn);
    	break;
    	} else {
    		System.out.println(" No SelfPrint ticket available. ");
    	}
    }*/   
    											
    //Boolean isPresent = driver.findElements(By.xpath("//*[contains (text(), '" + selfprint + "')]"));
    
    //Thread.sleep(10000);
    //driver.findElement(By.xpath(".//*[@class='leftButton icon-link']/li[6]/a")).click();
	}
}

