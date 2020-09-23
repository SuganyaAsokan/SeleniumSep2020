package week2day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElementByXPath("//span[@class = 'x-tab-strip-inner']/span[text() = 'Phone']").click();
		driver.findElementByName("phoneNumber").sendKeys("99");

//		driver.findElementByXPath("( //div[@class = 'x-form-item x-tab-item']//input)[2]").sendKeys("Suganya");
//		driver.findElementByXPath("( //div[@class = 'x-form-item x-tab-item']//input)[3]").sendKeys("Asokan");

		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(2000);

		WebElement capture = driver.findElementByXPath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		String capturedId = capture.getText();

		System.out.println("CapturedId is : " + capturedId);
		capture.click();

		driver.findElementByClassName("subMenuButtonDangerous").click();
		driver.findElementByXPath("//a[text() = 'Find Leads']").click();

		driver.findElementByXPath("//input[@name = 'id']").sendKeys(capturedId);
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();

		Thread.sleep(2000);

		WebElement text = driver.findElementByXPath("//div[@class = 'x-paging-info']");
		String deleteMessage = text.getText();

		if (deleteMessage == "No records to display") {
			System.out.println("Lead Deleted Successfully");

		} else {
			System.out.println("Lead not Deleted Successfully");
		}

		driver.close();

	}

}
