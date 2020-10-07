package week4.day2;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.switchTo().frame(0);
		driver.findElementById("Click").click();
		
		driver.switchTo().defaultContent(); // to come out from first frame
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElementById("Click1").click();
		
		driver.switchTo().defaultContent(); // to come out from nested frame
		
		int frameSize = driver.findElementsByTagName("iframe").size();
		System.out.println(frameSize);
		
		int count=frameSize;
		
		for (int i = 0; i < frameSize; i++) {
			
			driver.switchTo().frame(i);
			count = count+driver.findElementsByTagName("iframe").size();
			driver.switchTo().defaultContent();
			
		}
		
		System.out.println("Total number of frames : "+count);
		
		driver.close();

	}

}
