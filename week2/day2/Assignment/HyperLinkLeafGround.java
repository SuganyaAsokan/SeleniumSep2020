package week2.day2;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinkLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Link.html");
		
		driver.findElementByLinkText("Go to Home Page").click();
		driver.findElementByXPath("//a[@href = 'pages/Link.html']").click();
		
		String url = driver.findElementByLinkText("Find where am supposed to go without clicking me?").getAttribute("href");
		System.out.println("Find where am supposed to go without clicking me? : "+url);
       
        driver.findElementByXPath("(//a[text() = 'Go to Home Page'])[2]").click();
        driver.findElementByXPath("//a[@href = 'pages/Link.html']").click();
        
        driver.findElementByLinkText("Verify am I broken?").click();       
        String title = driver.getTitle();
        if (title.equals("HTTP Status 404 – Not Found")) {
			System.out.println("Page is broken");
		}
        else
        {
        	System.out.println("Page is not broken");
        }

 		driver.close();
	
		
		
	}

}
