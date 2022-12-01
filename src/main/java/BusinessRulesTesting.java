import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BusinessRulesTesting {
	@Test
	public void nameTesting() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "Nome eh obrigatorio");
		alert.accept();
		driver.quit();
	}
		@Test
		public void sobrenomeTesting() {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Um Nome");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "Sobrenome eh obrigatorio");
			alert.accept();	
			driver.quit();
		}
		@Test
		public void sexTesting() {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Um Nome");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Um Sobrenome");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "Sexo eh obrigatorio");
			driver.quit();
		}
		@Test
		public void favoriteFoodTesting() {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Um Nome");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Um Sobrenome");
			driver.findElement(By.id("elementosForm:sexo:0")).click();			
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "Tem certeza que voce eh vegetariano?");
			driver.quit();
		}
		@Test
		public void EsportesTesting() {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Um Nome");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Um Sobrenome");
			driver.findElement(By.id("elementosForm:sexo:0")).click();				
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
			combo.selectByVisibleText("Futebol");
			combo.selectByVisibleText("O que eh esporte?");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			String msg = alert.getText();
			assertEquals(msg, "Voce faz esporte ou nao?");
			alert.accept();	
			driver.quit();
		}
		@Test
		public void CadastroOK() {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Um Nome");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Um Sobrenome");
			driver.findElement(By.id("elementosForm:sexo:0")).click();				
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
			combo.selectByVisibleText("Futebol");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			String valor = driver.findElement(By.cssSelector("#resultado > span")).getText();
			assertEquals(valor, "Cadastrado!");
			driver.quit();
		}
	}