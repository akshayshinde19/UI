package amazon;

import static org.testng.Assert.assertEquals;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sun.tools.javac.util.Assert;

public class iphoneSearch {

	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Desktop\\Rest\\Jio\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		List<WebElement> al = new ArrayList();
		
		al=  driver.findElements(By.xpath("//*[@data-component-type='s-search-result']//*[contains(text(),'iPhone')]"));
		
		//*[@data-component-type='s-search-result']//*[contains(text(),'iPhone')]
		
		//fun1(al);
		
		for(WebElement we : al) {
			System.out.println(we.getText());
			
			System.out.println(we.getText().equalsIgnoreCase("Apple iPhone 11 (128GB) - Purple"));
			
			
			if(we.getText().equalsIgnoreCase("Apple iPhone 11 (128GB) - Purple")) {
				String parentWinId=driver.getWindowHandle();
				System.out.println("parentWinId = "+parentWinId);
				
				we.click();
				
				Set<String> winHandeles=driver.getWindowHandles();
				
				for(String s:winHandeles) {
					System.out.println(" WinId = "+s);
					if(!s.equalsIgnoreCase(parentWinId)) {
						driver.switchTo().window(s);
						
						WebElement childWE= driver.findElement(By.xpath("(//span[@data-a-color='price']//span[@aria-hidden='true'])[3]"));
						
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
								System.out.println(childWE.getText());
								break;
					}
				}
				break;
				
			}
			
			//Assert.check(we.getText().contains("iPhone"));
			
			//Assert.assertTrue(we.getText().contains("iPhone"));
			
			//Assert.check(we.getText().contains("iPhone"));
			
			//assertEquals(we.getText().contains("iPhone"),true);
			//assertEquals(response.getStatusCode(), 200);
			
			// Assert.check(false)
		}
		
		//driver.close();
		

	}

//	@Test
//	private static void fun1(List<WebElement> al) {
//		for(WebElement we : al) {
//		System.out.println(we.getText());
//		//Assert.check(we.getText().contains("iPhone"));
//		
//		//Assert.assertTrue(we.getText().contains("iPhone"));
//		
//		Assert.check(we.getText().contains("iPhone"));
//		
//		//assertEquals(we.getText().contains("iphone"),true);
//		//assertEquals(response.getStatusCode(), 200);
//		
//		// Assert.check(false)
//	}
//	}

}
