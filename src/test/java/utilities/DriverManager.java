package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverManager {

	public static WebDriver driver;

	public static void main(String[] args) {

		try {
			System.setProperty("WebDriver.chrome.driver", "src/test/resources/drivers/chromedriver_mac_m1m2");

			
			ChromeOptions chromeOptions = new ChromeOptions();

			chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");

			driver = new ChromeDriver(chromeOptions);
			
			driver.get("https://boratech-practice-app.onrender.com/");
			driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
