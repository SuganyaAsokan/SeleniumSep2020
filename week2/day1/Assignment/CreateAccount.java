package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Accounts").click();
		driver.findElementByLinkText("Create Account").click();
		driver.findElementByXPath("//input[@id = 'accountName']").sendKeys("Debit Limited Account");
		driver.findElementByXPath("//textarea[@name = 'description']").sendKeys("Selenium Automation Tester");
		driver.findElementByXPath("//input[@id = 'groupNameLocal']").sendKeys("TestName");
		driver.findElementByXPath("//input[@id = 'officeSiteName']").sendKeys("TestSite");
		driver.findElementByXPath("(//input[@class = 'inputBox'])[5]").sendKeys("5000000");

		WebElement industry = driver.findElementByName("industryEnumId");
		Select industryType = new Select(industry);
		industryType.selectByVisibleText("Computer Software");

		WebElement ownership = driver.findElementByName("ownershipEnumId");
		Select ownershipType = new Select(ownership);
		ownershipType.selectByVisibleText("S-Corporation");

		WebElement source = driver.findElementById("dataSourceId");
		Select sourceType = new Select(source);
		sourceType.selectByValue("LEAD_EMPLOYEE");
		
		WebElement marketing = driver.findElementById("marketingCampaignId");
		Select marketingType = new Select(marketing);
		marketingType.selectByIndex(6);
	
		WebElement state = driver.findElementByName("generalStateProvinceGeoId");
		Select stateName = new Select(state);
		stateName.selectByValue("TX");

		driver.findElementByXPath("//input[@class = 'smallSubmit']").click();
		
	}

}
