package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String fromLead = "10091";
		String toLead = "10092";
		
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByXPath("//a[text() = 'Leads']").click();
		driver.findElementByLinkText("Merge Leads").click();
		
		driver.findElementByXPath("//img[@alt='Lookup']").click();
		
		//switching to new window
		Set<String> windowReference = driver.getWindowHandles();
		
		List<String> windowList = new ArrayList<String>(windowReference);
		
		String secondWindow = windowList.get(1);
		driver.switchTo().window(secondWindow);
		
		driver.findElementByName("id").sendKeys(fromLead); // from lead
				
		driver.findElementByXPath("//button[@class='x-btn-text']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//a").click();
		
		//switching back to primary window
		String firstWindow = windowList.get(0);
		driver.switchTo().window(firstWindow);
		
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		
        Set<String> windowReference1 = driver.getWindowHandles();
		
		List<String> windowList1 = new ArrayList<String>(windowReference1);
		
		String secondWindow1 = windowList1.get(1);
		driver.switchTo().window(secondWindow1);
		
        driver.findElementByName("id").sendKeys(toLead); // to lead
		
		driver.findElementByXPath("//button[@class='x-btn-text']").click();
		Thread.sleep(2000);
       	driver.findElementByXPath("//table[@class='x-grid3-row-table']//a").click();
		
		String firstwindow1 = windowList1.get(0);
		driver.switchTo().window(firstwindow1);
		
		driver.findElementByLinkText("Merge").click();
		
		driver.switchTo().alert().accept();
		
		//clicking find leads
		driver.findElementByLinkText("Find Leads").click();
		
		driver.findElementByName("id").sendKeys(fromLead);
		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		WebElement text = driver.findElementByXPath("//div[@class = 'x-paging-info']");
		String deleteMessage = text.getText();

		if (deleteMessage.equals("No records to display")) {
			System.out.println("Records has been merged successfully");

		} else {
			System.out.println("Records is not merged properly");
		}
		
		driver.close();
		

	}

}
