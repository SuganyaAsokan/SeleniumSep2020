package week4.day1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableJquery {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
	
		driver.get("https://jqueryui.com/sortable/");
		
		js.executeScript("window.scrollBy(0,1000)");
		
		driver.switchTo().frame(0);

		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");
		
		Point target = item4.getLocation();
		int xOffset = target.getX();
		int yOffset = target.getY();
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(item1, xOffset, yOffset).release().perform();
		
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
