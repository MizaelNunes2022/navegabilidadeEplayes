package teste.eplayers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testesenaieplayers {
	private WebDriver driver;

	@Before
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testNavegador() {
		driver.get("http://localhost:4200/");
		driver.findElement(By.xpath("//*[@id=\"navMenu\"]/a[5]")).click();
		// criar os elements
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement inputSubmit = driver.findElement(By.id("signin"));
		String[] listaEmails = { "individuo_um@email.com", "individuo_dois@email.com", "email sem formato",
				"mizael.nunes@nunes.com" };
		String[] listaSenhas = { "senhaum", "senhadois", "12", "12345678" };

		for (int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {
			try {
				// limpando os campos
				inputEmail.clear();
				inputSenha.clear();

				// preencher os campos
				inputEmail.sendKeys(listaEmails[tentativas]);
				inputSenha.sendKeys(listaSenhas[tentativas]);
				inputSubmit.click();

				Thread.sleep(3000);// 3 segundos

			} catch (InterruptedException error) {
				error.printStackTrace();
			}

		}
	}
	
	@After
	public void FinalizarTeste() {
		try {
			Thread.sleep(2000);
			driver.quit();
		}catch(Exception error) {
			error.printStackTrace();
		}
	}

}
