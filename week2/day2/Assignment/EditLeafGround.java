package week2day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.findElementById("email").sendKeys("Test@gmail.com");
		driver.findElementByXPath("(//input[@type = 'text'])[2]").sendKeys("SampleText");
		
		String defaultText = driver.findElementByXPath("//input[@name = 'username' and @value = 'TestLeaf']").getAttribute("value");
		System.out.println("Default text is : "+defaultText);
		
	    WebElement clearText = driver.findElementByXPath("//input[@name = 'username' and @value = 'Clear me!!']");
	    clearText.clear();
	    clearText.sendKeys("Text Cleared");
	    
		boolean textboxStatus = driver.findElementByXPath("(//input[@type = 'text'])[5]").isDisplayed();
		System.out.println("Text box is : "+textboxStatus);
		
		driver.close();
		
	}

}
