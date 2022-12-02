import static org.junit.Assert.assertEquals;

import java.awt.Frame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Window;

import junit.framework.Assert;

public class TesteFrameEJanelas {
	private WebDriver driver;
	
	@Before
	public void inicializa(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.get("file:///C:/Users/Theo%20Araujo/Desktop/Private%20Theo/QA%20Theo/ESTUDOS/automacoes/Java/campo_treinamento/componentes.html");
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	@After
	public void finaliza() {
		driver.quit();
	}
	@Test
	public void iframe() {
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		assertEquals("Frame OK!", msg);
		alert.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(msg);
		
	}
	@Test
	public void Janela() {
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Texto na janela");
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Texto pág. principal");
		
	}
	@Test
	public void JanelaGenerico() {
		driver.findElement(By.id("buttonPopUpHard")).click();
//		System.out.println(driver.getWindowHandle());
//		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]); 
		driver.findElement(By.tagName("textarea")).sendKeys("Texto na janela HARD");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("Texto na pg principal");
		
	}
}