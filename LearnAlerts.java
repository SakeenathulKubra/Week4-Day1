package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leafground.com/pages/Alert.html");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
	Thread.sleep(3000);
	Alert alert = driver.switchTo().alert();
	String text = alert.getText();
	//alert.sendKeys("ABC");
	System.out.println(text);
	alert.accept();
	Alert alert2 = driver.switchTo().alert();
	alert2.dismiss();
}
}
