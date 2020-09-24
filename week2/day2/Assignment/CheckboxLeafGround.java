package week2.day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
		
		driver.findElementByXPath("(//div/input)[1]").click();
		
		WebElement checkboxStatus = driver.findElementByXPath("//label[text() = 'Confirm Selenium is checked']/following::input[1]");
		if (checkboxStatus.isSelected()) {
			System.out.println("Selenium is checked ");
		}
		else
		{
			System.out.println("Selenium is not checked ");
		}

		WebElement locateCheckbox = driver.findElementByXPath("//label[text() = 'DeSelect only checked']/following::input[2]");
        if (locateCheckbox.isSelected()) {
        	locateCheckbox.click();
        	System.out.println("deselected the checkbox");
		}

        List<WebElement> checkList = driver.findElementsByXPath("(//*[text() = 'Select all below checkboxes ']/following::input)");
        System.out.println("Number of checkbox present in the webpage : "+checkList.size());
        for (int i = 0; i < checkList.size() ; i++) {
        	checkList.get(i).click();
		}
        
        driver.close();
	}

}
