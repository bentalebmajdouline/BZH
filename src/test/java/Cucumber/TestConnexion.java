package Cucumber;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestConnexion {

	WebDriver driver;

	@Given("^le navigateur s ouvre sur la page de connexion de quizz$")
	public void le_navigateur_s_ouvre_sur_la_page_de_connexion_de_quizz() {
		System.out.println("-----@Given-----");
		System.out.println("Le navigateur s'ouvre sur le site Quizz");

		Map<String, Object> vars;
		JavascriptExecutor js;
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrateur\\Desktop\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrateur\\Desktop\\geckodriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrateur\\Desktop\\msedgedriver.exe");
		// driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver = new EdgeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		driver.get("http://127.0.0.1:8000/quizz");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Page connexion atteinte");

	}

	@When("^le formateur entre son identifiant et son mot de passe$")
	public void le_formateur_entre_son_identifiant_et_son_mot_de_passe() {
		System.out.println("-----@When-----");
		// click et input du champs identifiants
		driver.findElement(By.id("id_username")).click();
		driver.findElement(By.id("id_username")).sendKeys("admin");
		// click et input du champs password
		driver.findElement(By.id("id_password")).click();
		driver.findElement(By.id("id_password")).sendKeys("admin");
		// click sur le bouton connexion
		driver.findElement(By.id("connect")).click();

	}

	@Then("^il arrive sur la page d accueil et peut administrer$")
	public void il_arrive_sur_la_page_d_accueil_et_peut_administrer() {
		System.out.println("-----@Then-----");
		assertThat(driver.getTitle(),
				is("Bienvenue sur l'interface d'administration de Quizz pour un champion ! | QPUC - Admin"));

		driver.findElement(By.xpath("//a[contains(@href, '/admin/auth/group/add/')]")).click();

		assertThat(driver.getTitle(), is("Ajout de groupe | QPUC - Admin"));
		driver.quit();

	}

	@When("^le formateur entre un identifiant ou un mot de passe errone$")
	public void le_formateur_entre_un_identifiant_ou_un_mot_de_passe_errone() {
		System.out.println("-----@When-----");
		// click et input du champs identifiants
		driver.findElement(By.id("id_username")).click();
		driver.findElement(By.id("id_username")).sendKeys("admin");
		// click et input du champs password
		driver.findElement(By.id("id_password")).click();
		driver.findElement(By.id("id_password")).sendKeys("motDePasseErrone");
		// click sur le bouton connexion
		driver.findElement(By.id("connect")).click();

	}

	@Then("^la page affiche un message d erreur$")
	public void la_page_affiche_un_message_d_erreur() {
		System.out.println("-----@When-----");
		assertThat(driver.getTitle(), is("prend ton titre"));
		List<WebElement> elements = driver.findElements(By.id("roizil"));
		assert (elements.size() > 0);
		driver.quit();

	}

	@When("^le stagiaire entre son identifiant et son mot de passe$")
	public void le_stagiaire_entre_son_identifiant_et_son_mot_de_passe() {
		System.out.println("-----@When-----");
		// click et input du champs identifiants
		driver.findElement(By.id("id_username")).click();
		driver.findElement(By.id("id_username")).sendKeys("tristan");
		// click et input du champs password
		driver.findElement(By.id("id_password")).click();
		driver.findElement(By.id("id_password")).sendKeys("tristantristan");
		// click sur le bouton connexion
		driver.findElement(By.id("connect")).click();

	}

	@Then("^il arrive sur la page d accueil et ne peut pas administrer$")
	public void il_arrive_sur_la_page_d_accueil_et_ne_peut_pas_administrer() {
		System.out.println("-----@Then-----");
		assertThat(driver.getTitle(), is("Title"));
		List<WebElement> elements = driver.findElements(By.id("admin_button"));
		assert (elements.size() == 0);
		driver.quit();

	}

	@When("^le stagiaire entre un identifiant ou un mot de passe errone$")
	public void le_stagiaire_entre_un_identifiant_ou_un_mot_de_passe_errone() {
		System.out.println("-----@When-----");
		// click et input du champs identifiants
		driver.findElement(By.id("id_username")).click();
		driver.findElement(By.id("id_username")).sendKeys("tristan");
		// click et input du champs password
		driver.findElement(By.id("id_password")).click();
		driver.findElement(By.id("id_password")).sendKeys("motDePasseErrone");
		// click sur le bouton connexion
		driver.findElement(By.id("connect")).click();

	}

	// scénario automatisé
	@Given("^Je demarre un scenario de connexion d un  utilisateur$")
	public void je_demarre_un_scenario_de_connexion_d_un_utilisateur() {
		System.out.println("-----@Given-----(automatisé");
		System.out.println("Le navigateur s'ouvre sur le site Quizz");

		Map<String, Object> vars;
		JavascriptExecutor js;
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrateur\\Desktop\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrateur\\Desktop\\geckodriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrateur\\Desktop\\msedgedriver.exe");
		// driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver = new EdgeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		driver.get("http://127.0.0.1:8000/quizz");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Page connexion atteinte");
	}

	@When("^j entre dans le formulaire son \"([^\"]*)\" et son \"([^\"]*)\" et je valide$")
	public void j_entre_dans_le_formulaire_son_et_son_et_je_valide(String arg1, String arg2) throws Throwable {
		System.out.println("-----@When-----(automatisé)");
		// click et input du champs identifiants
		driver.findElement(By.id("id_username")).click();
		driver.findElement(By.id("id_username")).sendKeys(arg1);
		// click et input du champs password
		driver.findElement(By.id("id_password")).click();
		driver.findElement(By.id("id_password")).sendKeys(arg2);
		// click sur le bouton connexion
		driver.findElement(By.id("connect")).click();
	}

	@Then("^je verifie que nous sommes sur \"([^\"]*)\"$")
	public void je_verifie_que_nous_sommes_sur(String arg1) {
		System.out.println("-----@Then-----(automatisé)");
		assertThat(driver.getTitle(), is(arg1));
	}

}
