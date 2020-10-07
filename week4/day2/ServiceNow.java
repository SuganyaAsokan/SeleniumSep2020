package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://dev68594.service-now.com/");
		
		//wait added
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//switching to frame to enter username and password
		driver.switchTo().frame("gsft_main");
		
		//enter user name , password , login button click and type incident in filter field
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		driver.findElementById("filter").sendKeys("incident");
		
		Thread.sleep(3000);

		//locate All filed and click all field using actions
		WebElement all = driver.findElementByXPath("(//div[text()='All'])[2]");
		Actions builder = new Actions(driver);
		builder.moveToElement(all).click().perform();
		
		//switching to frame to select new button
		driver.switchTo().frame("gsft_main");
		
		//click new button and selecting caller id search icon
		driver.findElementById("sysverb_new").click();
		driver.findElementById("lookup.incident.caller_id").click();
		
		//switching to new window to select the caller id
		Set<String> windowReference = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowReference);
		String secondWindow = windowList.get(1);
		driver.switchTo().window(secondWindow);
		
		//selecting the first link
		driver.findElementByXPath("//a[@class='glide_ref_item_link']").click();
		
		//switching back to main window
		String firstWindow = windowList.get(0);
		driver.switchTo().window(firstWindow);
		
		//scrolling down
		driver.switchTo().frame("gsft_main");
		driver.findElementById("incident.short_description").sendKeys("Testing");
		
		//Read the incident number and save it a variable
		WebElement incident = driver.findElementById("incident.number");
		String incidentNumber = incident.getAttribute("value");
		System.out.println("Incident Number : "+incidentNumber);
		
		//click submit button
		driver.findElementById("sysverb_insert").click();
		
		//enter value in search field
		WebElement search = driver.findElementByXPath("//input[@class='form-control']");
		search.sendKeys(incidentNumber);
		search.sendKeys(Keys.ENTER);
		
		//get the first value
		String incidentId = driver.findElementByXPath("//table//a[@class='linked formlink']").getText();
		System.out.println("Added incident id : "+incidentId);
		
		if (incidentNumber.equals(incidentId)) {
			System.out.println("Incident is created successfully");
			
		}else {
			System.out.println("Incident is not created");
		}
		driver.close();
		

	}

}
