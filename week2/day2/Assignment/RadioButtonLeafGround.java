package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/radio.html");
		
		driver.findElementByXPath("//label[@for = 'yes']").click();
		
		boolean defaultStatus = driver.findElementByXPath("//label[text() = 'Find default selected radio button']/following::input[2]").isSelected();
		System.out.println("Is radiobutton is selected : "+defaultStatus);

		//driver.findElementByXPath("(//input[@name = 'age'])[1]").click();
		
		WebElement locateAge = driver.findElementByXPath("(//input[@name = 'age'])[2]");
		
		if (locateAge.isSelected()) {
			System.out.println("Age already selected");
		}
		else
		{
			locateAge.click();
			System.out.println("Age selected");
		}
		driver.close();
	}

}
