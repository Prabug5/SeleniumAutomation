package Urbantesting.com.Urban;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
public class Addtocart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe");

		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com");
		
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Table");
		driver.findElement(By.xpath("//span[@class='search-icon icofont-search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Close']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='Stacking Table Furniture Ratua Table Mat (Rust)']")).click();
		
		String ParentWindowHandler=driver.getWindowHandle();
		//System.out.println("ParenWindowhandler"+ParentWindowHandler);
		
		Thread.sleep(3000);
		for(String childTab:driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='large-4 columns btn_wrap']//a[@class='continueshop'][normalize-space()='Continue shopping']")).click();
		Thread.sleep(2000);
		WebElement cart=driver.findElement(By.xpath("(//*[name()='path'])[7]"));
		Actions con=new Actions(driver);
		con.moveToElement(cart).click().perform();
		
		String Head="//body/div[@class='container']/div[@id='wrapper']/div[@id='content']/div[@class='cart_container']/div[@class='cart clearfix']/form[@id='update-cart']/div[@data-hook='inside_cart_form']/div[@data-hook='cart_items']/div[@id='line_items']/div[1]/div[1]/div[2]/div[1]/div[1]";
		String Title=driver.findElement(By.xpath(Head)).getText();
		//System.out.println(Title);
		
		String price="/html/body/div[1]/div[1]/div[2]/div/div[2]/form/div/div[5]/div[2]/div/div[4]/div/div[1]/div/div[1]/div[2]";
		String cost=driver.findElement(By.xpath(price)).getText();
		System.out.println(Title+cost);
	}

}
