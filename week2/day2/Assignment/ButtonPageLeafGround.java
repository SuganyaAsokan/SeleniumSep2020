package week2day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPageLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Button.html");
		
		driver.findElementById("home").click();
		driver.findElementByXPath("//a[@href = 'pages/Button.html']").click();
		
	    WebElement position = driver.findElementById("position");
	    System.out.println("Button position : "+position.getLocation());
	    
	    WebElement color = driver.findElementById("color");
	    System.out.println("Button color : "+color.getCssValue("background-color"));
	    
	    WebElement size = driver.findElementById("size");
	    System.out.println("Button Size : "+size.getSize());
	    
	    driver.close();

	}

}
