package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		
		
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list = new ArrayList<String>(windowHandles);
		String string = list.get(1);
		driver.switchTo().window(string);
		driver.close();
		driver.switchTo().window(list.get(0));
		
		
		/*driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		Thread.sleep(3000);
		System.out.println(windowHandles2);
		List<String> window2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(window2.get(1));
		String string2 = window2.get(2);
		System.out.println(string2);
		System.out.println(window2.size());
		driver.switchTo().window(string2);
		driver.close();
	*/	
		
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		System.out.println(windowHandles3);
		List<String> window3 = new ArrayList<String>(windowHandles3);
		driver.switchTo().window(window3.get(1));
		driver.switchTo().window(window3.get(0));
		//driver.quit();
		
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Set<String> windowHandles4 = driver.getWindowHandles();
		System.out.println(windowHandles4);
		List<String> window4 = new ArrayList<String>(windowHandles4);
		driver.switchTo().window(window4.get(1));
		driver.close();
		
		
	}

}
