package week2.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("IVTL");
		driver.findElementById("createLeadForm_firstName").sendKeys("Suganya");
		driver.findElementById("createLeadForm_lastName").sendKeys("Asokan");
		
		WebElement source = driver.findElementById("createLeadForm_dataSourceId");
		Select sourceValue = new Select(source);
		sourceValue.selectByVisibleText("Employee");
		
		WebElement marketingCampaign = driver.findElementById("createLeadForm_marketingCampaignId");
		Select marketingValue = new Select(marketingCampaign);
		marketingValue.selectByValue("9001");
		
		WebElement Industry = driver.findElementById("createLeadForm_industryEnumId");
		Select IndustryValue = new Select(Industry);
		List<WebElement> options = IndustryValue.getOptions();
		int size = options.size();
		IndustryValue.selectByIndex(size-2);
		
		WebElement ownership = driver.findElementById("createLeadForm_ownershipEnumId");
		Select ownershipValue = new Select(ownership);
		ownershipValue.selectByIndex(5);
		
		WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
		Select india = new Select(country);
		india.selectByVisibleText("India");
		
		driver.findElementByName("submitButton").click();
		
		System.out.println("Title of the page is : "+driver.getTitle());
		
			}

}
