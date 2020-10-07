package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/Window.html");
		
		driver.findElementById("home").click();
		
		Set<String> windowReference = driver.getWindowHandles();  // get all the window reference id and store it in set
		
		List<String> windowList = new ArrayList<String>(windowReference); // to get single reference store it in list
		String secondWindow = windowList.get(1);
		driver.switchTo().window(secondWindow);
		
		driver.findElementByXPath("(//img[@class='wp-categories-icon svg-image'])[2]").click();
		
		driver.close(); // closing current opened window
		
		//Find the number of opened windows
        String firstWindow = windowList.get(0);
		driver.switchTo().window(firstWindow);
		
		driver.findElementByXPath("//button[text() = 'Open Multiple Windows']").click();
		
		Set<String> windowReference1 = driver.getWindowHandles();
		List<String> windowList1 = new ArrayList<String>(windowReference1);
		
		int window = 0;
		
		for (String eachwindow : windowReference1) {
			
			driver.switchTo().window(eachwindow);
						
			window++;
			
		}
		
		System.out.println("Total number of windows opened : "+window);
		
		String mulWindow1 = windowList1.get(1);
		driver.switchTo().window(mulWindow1);
		driver.close();
		
		String mulWindow2 = windowList1.get(2);
		driver.switchTo().window(mulWindow2);
		driver.close();
		
		//Close all except this window
        String mulWindow = windowList.get(0);
        driver.switchTo().window(mulWindow);
		
		driver.findElementById("color").click();
		
		Set<String> windowReference2 = driver.getWindowHandles();
		List<String> windowList2 = new ArrayList<String>(windowReference2);
		
		String closeWindow1 = windowList2.get(1);
		driver.switchTo().window(closeWindow1);
		driver.close();
		
		String closeWindow2 = windowList2.get(2);
		driver.switchTo().window(closeWindow2);
		driver.close();
		
		//Wait for 2 new Windows to open
		String closeWindow3 = windowList2.get(0);
		driver.switchTo().window(closeWindow3);
		
		driver.findElementByXPath("//button[text()='Wait for 5 seconds']").click();
		Thread.sleep(5000);
		
		driver.quit();
	}

}
