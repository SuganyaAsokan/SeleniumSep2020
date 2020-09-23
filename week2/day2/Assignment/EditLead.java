package week2day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElementByXPath("( //div[@class = 'x-form-item x-tab-item']//input)[2]").sendKeys("Suganya");
		driver.findElementByXPath("( //div[@class = 'x-form-item x-tab-item']//input)[3]").sendKeys("Asokan");
		
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		
		Thread.sleep(2000);
		
		driver. findElementByXPath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		  
		String title = driver.getTitle(); 
		//boolean verifyTitle =title.contains("View Lead | opentaps CRM"); 
		boolean verifyTitle =title.contentEquals("View Lead | opentaps CRM"); 
		System.out.println("Verify the title of the page is [View Lead | opentaps CRM] : "+verifyTitle);
		  
		driver.findElementByLinkText("Edit").click();
		WebElement companyName = driver.findElementById("updateLeadForm_companyName");
		companyName.clear();
		companyName.sendKeys("IVTL");		
		driver.findElementByName("submitButton").click();
		
		String confirmCompanyName = driver.findElementById("viewLead_companyName_sp").getText();
		//boolean updatedcompanyName = confirmCompanyName.contains("IVTL");
		//String updatedCompanyName = "IVTL";
		if (confirmCompanyName.contains("IVTL")) {
			System.out.println("Company name is updated");
		}
		/*
		 * if (confirmCompanyName == updatedCompanyName) {
		 * System.out.println("Company name is updated");
		 * 
		 * }
		 */
		else
		{
			System.out.println("Company name is not updated");
		}
		
		driver.close();

	}

}
