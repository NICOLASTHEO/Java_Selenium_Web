import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.host.Window;

import javafx.scene.chart.ValueAxis;
import junit.framework.Assert;

public class TesteCompoTreinamento {
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
	public void textfield() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Theo Araujo");
		assertEquals("Theo Araujo", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit();
	}
	@Test
	public void interagircomtextarea() {
		driver.findElement(By.name("elementosForm:sugestoes")).sendKeys("Um texto qualquer.\nOutro texto.");
		assertEquals("Um texto qualquer.\nOutro texto.", driver.findElement(By.name("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}
	@Test
	public void interagircomRadioButton() {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	@Test
	public void interagircomCheckBox() {
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		driver.quit();
	}
	@Test
	public void interagircomComboBox() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//combo.selectByIndex(3);
		//combo.selectByValue("especializacao");
		combo.selectByVisibleText("1o grau incompleto");
		assertEquals("1o grau incompleto", combo.getFirstSelectedOption().getText());
		//driver.quit();
	}	
	@Test
	public void verificaComboBoxValues() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Opcao qualquer"));
			encontrou = true;
			break;
		}
		assertTrue(encontrou);
		
	}	

}