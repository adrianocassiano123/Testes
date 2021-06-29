package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformacoesUsuarioTest {

	private WebDriver navegador;

	@Before
	public void setUp() {

		// Abrindo o navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LHSPC\\Drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Define a quantidade de segundos para a
																			// pagina carregar

		// Navegando para a página do Taskit
		navegador.get("http://www.juliodelima.com.br/taskit");
		
		// clicar no texto que possui "Sign in"
				navegador.findElement(By.linkText("Sign in")).click();

				// Identificando o formulário de login
				// clicar no campo com name "login" que está dentro do formulário de id
				// "signinbox"
				WebElement formularioSignInbox = navegador.findElement(By.id("signinbox"));

				// Digitar no campo com name "login" que está dentro do formulário de id
				// "signinbox" o texto "adrsilva"
				formularioSignInbox.findElement(By.name("login")).sendKeys("adrsilva");

				// clicar no campo com name "password" que está dentro do formulário de id
				// "signinbox" o texto "12345"
				formularioSignInbox.findElement(By.name("password")).sendKeys("12345");

				// clicar no link com o texto "SIGN IN"
				navegador.findElement(By.linkText("SIGN IN")).click();
				
				
				// Clicar em um link que possui a class "me"
		        navegador.findElement(By.className("me")).click();
				
				// Clicar em um link que poossui o texto "MORE DATA ABOUT YOU"
		        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

	}

	@Test
	@Ignore
	public void testAdicionarUmaInformaçãoAdicionalDoUsuario() {

		
		// validar se dentro do elemento com class "me" tem o texto "Hi, Adriano
		
//		WebElement me = navegador.findElement(By.className("me"));// (By.cssSelector("ul> li:nth-child(1)"));
//		String textoNoElementoMe = me.getText();
//
//		System.out.println(textoNoElementoMe);
//
//		assertEquals("Hi, Adriano", textoNoElementoMe);

        
        // Clicar no botão através do seu xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a popup onde está o formulário de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        // Na combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");   //Acessando a combobox

        // No campo de name "contact" digitar "+5511999999999"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511323239898");

        // Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added!", mensagem);
        
        
        
        
	}
	
	
	@Test
	public void removerUmContatoDeUsuario() {
		// Clicar no elemento pelo seu xpath //span[text()="+551133334444"]/following-sibling::a
        navegador.findElement(By.xpath("//span[text()=\"" + "" + "\"]/following-sibling::a")).click();

        // Confirmar a janela javascript
        navegador.switchTo().alert().accept(); // switchTo().alert() PEGA O JS

        // Validar que a mensagem apresentada foi Rest in peace, dear phone!
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals(mensagem, mensagem);

//        String screenshotArquivo = "/Users/julio.lima/test-report/taskit/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
//        Screenshot.tirar(navegador, screenshotArquivo);

        // Aguardar até 10 segundos para que a janela desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador, 10); // 	ESPERA EXPLICITA - Espera 10 segundos  o  elemento desaparecer para fechar a tela nesse caso
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        // Clicar no link com texto "Logout"
        navegador.findElement(By.linkText("Logout")).click();
	}

	@After

	public void tearDown() {
		// Fechar o navegador
		// navegador.quit();
	}

}
