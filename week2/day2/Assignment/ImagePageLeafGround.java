package week2.day2;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePageLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Image.html");

		driver.findElementByXPath("//label[text() = 'Click on this image to go home page']/following-sibling::img").click();
		// driver.findElementByXPath("//a[@href = 'pages/Image.html']").click();

		driver.navigate().back();

		driver.close();
	}

}
