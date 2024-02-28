package Maven.Create;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		// open the browser

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		// sycronization
		driver.manage().window().maximize();
		// Maximize the window
		driver.findElement(By.name("q")).sendKeys("ipad");
		// finding the search box and seding the ipad data
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='_3D0G9a'][1]"))).click();
		// Sychroniztaion waiting the upto webelement visibility will happen
		driver.findElement(By.xpath("//div[.='Internal Storage']")).click();
		/*
		 * As per testcase steps online online only filter not available so its an
		 * defect while to check end end senorio i took filter as internal store and
		 * filter it for 64-127.9GB
		 */
		driver.findElement(By.xpath("//div[@title='64 - 127.9 GB']")).click();
		// searching for the element of filter condition
		driver.findElement(By.xpath("//div[text()='Apple iPhone 11 (Purple, 64 GB)']")).click();
		// with result i picked up radom data and clicked on it.
		Set<String> handle = driver.getWindowHandles();
		// By using get window handle method we handle another window by iterator
		Iterator<String> it = handle.iterator();
		// it searching for next window and our control move on to child window
		String Pid = (String) it.next();
		// this is parent window address
		String Cid = (String) it.next();
		// this is child window address
		driver.switchTo().window(Cid);
		// By using child window address control take place in child windoe
		driver.findElement(By.xpath("//li[@class='col col-6-12'][1]")).click();
		// after switching window we are adding to cart

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")).click();
		// after adding cart we are checkout the material and click on it

		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("mdbbalamaka@gmail.com");
		// Finding the element and sercing text field of email and sending data in the
		// Emailid textfield
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		// after sending details of email id clicking on submitbutton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
		// hence it is hidden element we should wait until the elemnt should be
		// visisbility in webpage
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("8073485508");
		// sending the contact no details by using locaters
		driver.findElement(By.cssSelector("button[type='submit']")).submit();
		// it will submit the further process after enter mailid and contact no
		driver.quit();
	}
}
