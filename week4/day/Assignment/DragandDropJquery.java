package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDropJquery {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		WebElement dragItem = driver.findElementById("draggable");
		WebElement dropItem = driver.findElementById("droppable");
		
		Actions builder = new Actions(driver);
		
		int xOffset = dropItem.getLocation().getX();
		int yOffset = dropItem.getLocation().getY();
		
		builder.dragAndDropBy(dragItem, xOffset, yOffset).release().perform();
		
		Thread.sleep(2000);
		

		driver.close();
	}

}
