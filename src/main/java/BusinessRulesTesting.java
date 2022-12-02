import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BusinessRulesTesting {
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
	public void nameTesting() {
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "Nome eh obrigatorio");
		alert.accept();
	}
		@Test
		public void sobrenomeTesting() {
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Um Nome");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "Sobrenome eh obrigatorio");
			alert.accept();	
		}
		@Test
		public void sexTesting() {			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Um Nome");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Um Sobrenome");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "Sexo eh obrigatorio");
		}
		@Test
		public void favoriteFoodTesting() {

			driver.findElement(By.id("elementosForm:nome")).sendKeys("Um Nome");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Um Sobrenome");
			driver.findElement(By.id("elementosForm:sexo:0")).click();			
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "Tem certeza que voce eh vegetariano?");
		}
		@Test
		public void EsportesTesting() {
			
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
		}
		@Test
		public void CadastroOK() {
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Um Nome");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Um Sobrenome");
			driver.findElement(By.id("elementosForm:sexo:0")).click();				
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
			combo.selectByVisibleText("Futebol");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			String valor = driver.findElement(By.cssSelector("#resultado > span")).getText();
			assertEquals(valor, "Cadastrado!");
		}
	}