package week2.day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		WebElement dropdown1 = driver.findElementById("dropdown1");
		Select index = new Select(dropdown1);
		index.selectByIndex(1);
		
		WebElement dropdown2 = driver.findElementByName("dropdown2");
		Select text = new Select(dropdown2);
		text.selectByVisibleText("Selenium");

		WebElement dropdown3 = driver.findElementById("dropdown3");
		Select value = new Select(dropdown3);
		value.selectByValue("1");

		WebElement dropdown = driver.findElementByClassName("dropdown");
		Select dropdownSize = new Select(dropdown);
		List<WebElement> options = dropdownSize.getOptions();
		System.out.println("Number of dropdown options : "+options.size());
		
		driver.findElementByXPath("//option[text() = 'You can also use sendKeys to select']/..").sendKeys("Selenium");		
		
		WebElement multiSelect = driver.findElementByXPath("(//select)[6]");
		Select dropdownValue = new Select(multiSelect);
		dropdownValue.selectByVisibleText("Selenium");
		dropdownValue.selectByVisibleText("Appium");
		
        driver.close();
		


	}

}
