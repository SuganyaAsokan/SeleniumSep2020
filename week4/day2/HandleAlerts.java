package week4.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/Alert.html");
		
		driver.findElementByXPath("//button[text()='Alert Box']").click();
				
		driver.switchTo().alert().accept();
				
		driver.findElementByXPath("//button[text()='Confirm Box']").click();
				
		driver.switchTo().alert().dismiss();
				
		driver.findElementByXPath("//button[text()='Prompt Box']").click();
				
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Suganya");
		alert.accept();
				
		driver.findElementByXPath("//button[text()='Line Breaks?']").click();
				
		Alert lineAlert = driver.switchTo().alert();
		String lines = lineAlert.getText();
		System.out.println("content : "+lines);
		
		lineAlert.accept();
				
		driver.findElementById("btn").click();
			
		driver.findElementByXPath("//button[text() = 'OK']").click();
				
		driver.close();

	}

}
