package dynamicSeleniumElements;

import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpathHaldle {

	@Test
	public void checkTable() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2021/08/webtable-in-html.html");
		List<WebElement> allColum = driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println(allColum.size());

		Assert.assertEquals(allColum.size(), 5);
		boolean status =false;
		for (WebElement ele : allColum) {
			String value = ele.getText();
			System.out.println(value);
			if(value.contains("Country")) {
				status=true;
				System.out.println("value is found");
				//break;
			}

		}
		//commit to check
		Assert.assertTrue(status);
		Thread.sleep(2000);
		driver.close();		
	}

}
