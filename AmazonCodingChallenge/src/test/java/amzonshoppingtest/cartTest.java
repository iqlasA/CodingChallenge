package amzonshoppingtest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

public class cartTest extends TestBase {
	@Test
	public void TestWebsiteLaunch() {
		TestBase.initialization();

		WebElement SearchBox =  driver.findElement(By.id("twotabsearchtextbox"));
		SearchBox.sendKeys("Headphones");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		List<WebElement> HeadPhonesList = new ArrayList<WebElement>();
		HeadPhonesList = driver.findElements(By.xpath("//span[text()='Best Seller']//following::div[8]//h2"));

		ArrayList<String> headphones = new ArrayList<String>();
		for (WebElement Element : HeadPhonesList)
		{
			headphones.add(Element.getText());
		}

		for (String headphone : headphones)
		{
			
			WebElement SearchHeadphone =  driver.findElement(By.xpath("//*[@id=\'twotabsearchtextbox\']"));
			SearchHeadphone.clear();
			SearchHeadphone.sendKeys(headphone);
			driver.findElement(By.xpath("//input[@value='Go']")).click();
			String a = "(//*[contains(text(),'" + headphone + "')])[2]";;
			driver.findElement(By.xpath(a)).click();
			driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
			try {
				driver.findElement(By.xpath("//*[@id='uss-sheet-view']/div[2]")).click();
			}
			catch (Exception NoSuchElementException)
			{
				driver.findElement(By.xpath("//*[@id='attach-close_sideSheet-link']")).click();
			} 
		}
		driver.quit();
	}
}
