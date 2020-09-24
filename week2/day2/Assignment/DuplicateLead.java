package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByXPath("//a[text() = 'Leads']").click();
		driver.findElementByXPath("//a[text() = 'Find Leads']").click();
		driver.findElementByXPath("//span[@class = 'x-tab-strip-inner']/span[text() = 'Email']").click();
		driver.findElementByName("emailAddress").sendKeys("testingtest@gmail.com");
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		
		Thread.sleep(2000);
		
		WebElement capture = driver.findElementByXPath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-firstName'])[1]/a");
		String capturedName = capture.getText();

		System.out.println("CapturedName is : " + capturedName);
		capture.click();
		
		driver.findElementByLinkText("Duplicate Lead").click();
		
		String title = driver.getTitle();
		System.out.println("Title of the page is : "+title);
		if (title.equals("Duplicate Lead | opentaps CRM")) {
			
		System.out.println("Page title is correct");
		}
		else
		{
		System.out.println("Page title is incorrect");
		}
		
		driver.findElementByName("submitButton").click();
		
		String duplicateLeadName = driver.findElementById("viewLead_firstName_sp").getText();
		
		if (duplicateLeadName.equals(capturedName)) {
			System.out.println("The duplicated lead name is same as captured name");
		}
		else
		{
			System.out.println("The duplicated lead name is not same as captured name");
		}
		
		driver.close();
		
		
	}

}
