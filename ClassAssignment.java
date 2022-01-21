package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.linkText("FLIGHTS")).click();
		
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		List<String> list = new ArrayList<String>(handles);
		String string = list.get(1);
		driver.switchTo().window(string);
		String title = driver.getTitle();
		System.out.println(title);
		driver.switchTo().window(list.get(0));
		driver.close();
		
		
	}

}
