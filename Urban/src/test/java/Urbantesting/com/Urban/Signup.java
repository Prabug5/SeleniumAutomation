package Urbantesting.com.Urban;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
public class Signup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe");

		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com/");
		
		Thread.sleep(1000);
		WebElement hover=driver.findElement(By.xpath("//span[@class='header-icon-link user-profile-icon']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]"));
		Actions action=new Actions(driver);
		action.moveToElement(hover).build().perform();
		
		
		        Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[normalize-space()='Sign Up'])[1]")).click();
		//driver.findElement(By.xpath("(//a[normalize-space()='Sign Up'])[1]")).click();
		
		WebElement Register=driver.findElement(By.xpath("(//input[@id='spree_user_email'])[1]"));
		Register.sendKeys("prabumani9751@gmail.com");
		Register.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Password*'])[2]")).sendKeys("Hello@123");
		//WebElement Password=driver.findElement(By.xpath("(//input[@id='spree_user_password'])[2]"));
		//Actions hello=new Actions(driver);
		//hello.moveToElement(Password).sendKeys("Hello123");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Sign Up'])[1]")).click();
		
		Thread.sleep(2000);
		WebElement checker=driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/section[3]/ul/li[2]/span/svg"));
		Actions profile=new Actions(driver);
		profile.moveToElement(checker).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/section[3]/ul/li[2]/span/ul/li[1]/a"));
		 
		

	}

}
