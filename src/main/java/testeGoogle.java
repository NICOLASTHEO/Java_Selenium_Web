import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.htmlunit.HtmlUnitDriver; //rodar o teste Headless
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

//import com.gargoylesoftware.htmlunit.BrowserVersion;
//public class testeGoogle {
//	public static void main(String[] args){
		//WebDriver driver = new ChromeDriver();
	//	HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersio.CHROME);
		//driver.get("https://www.google.com");
		//String title = driver.getTitle();
		 //if (title == "Google") {
			//System.out.println("Título OK");
		 //}
		 //else {
			// System.out.println("We have a problem, the title is: "+ title);
		 //}
		 //driver.close();
//}

public class testeGoogle {
	@Test
	public void teste() {
		//System.setProperty("webdriver.chrome.driver", "//C:Caminho para o arquivo do Chrome Driver");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		//HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		//driver.manage().window().setPosition(new Point(100,100));
		driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}