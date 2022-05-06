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

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestDefinis {

	WebDriver driver;

	@Given("^le navigateur s ouvre sur la page de connexion de quizz$")
	public void le_navigateur_s_ouvre_sur_la_page_de_connexion_de_quizz() {
		System.out.println("-----@Given-----");
		System.out.println("Le navigateur s'ouvre sur le site Quizz");

		Map<String, Object> vars;
		JavascriptExecutor js;

		// ----------------------------------------------------[Attention de ne pas
		// oublier de rajouter son propre chemin de
		// chromedriver]------------------------------------!
		//
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrateur\\Desktop\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrateur\\Desktop\\geckodriver.exe");
		// --------------------------------------------------------------------------------[fin]-------------------------------------------------------------------------------!

		System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrateur\\Desktop\\msedgedriver.exe");
		// driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver = new EdgeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		driver.get("https://quizz.fr/");
		driver.manage().window().maximize();
		System.out.println("Page testing.bzh atteinte");

	}

	@When("^le formateur entre son identifiant et son mot de passe$")
	public void le_formateur_entre_son_identifiant_et_son_mot_de_passe() {
		System.out.println("-----@When-----");
		// click et input du champs identifiants
		driver.findElement(By.id("session_key")).click();
		driver.findElement(By.id("session_key")).sendKeys("identifiant@domaine.fr");
		// click et input du champs password
		driver.findElement(By.id("session_password")).click();
		driver.findElement(By.id("session_password")).sendKeys("motDePasse");
		// click sur le bouton connexion
		driver.findElement(By.cssSelector(".sign-in-form__submit-button")).click();

	}

	@Then("^il arrive sur la page d accueil et peut administrer$")
	public void il_arrive_sur_la_page_d_accueil_et_peut_administrer() {
		System.out.println("-----@Then-----");
		assertThat(driver.getTitle(), is("Accueil-Quizz"));
		driver.findElement(By.id("admin_button")).click();
		assertThat(driver.getTitle(), is("Administration-Quizz"));

	}

	@When("^le formateur entre un identifiant ou un mot de passe errone$")
	public void le_formateur_entre_un_identifiant_ou_un_mot_de_passe_errone() {
		System.out.println("-----@When-----");
		// click et input du champs identifiants
		driver.findElement(By.id("session_key")).click();
		driver.findElement(By.id("session_key")).sendKeys("identifiant@domaine.fr");
		// click et input du champs password
		driver.findElement(By.id("session_password")).click();
		driver.findElement(By.id("session_password")).sendKeys("motDePasseErrone");
		// click sur le bouton connexion
		driver.findElement(By.cssSelector(".sign-in-form__submit-button")).click();

	}

	@Then("^la page affiche un message d erreur$")
	public void la_page_affiche_un_message_d_erreur() {
		System.out.println("-----@When-----");
		List<WebElement> elements = driver.findElements(By.id("error-for-username"));
		assert (elements.size() > 0);

	}

	@When("^le stagiaire entre son identifiant et son mot de passe$")
	public void le_stagiaire_entre_son_identifiant_et_son_mot_de_passe() {
		System.out.println("-----@When-----");
		// click et input du champs identifiants
		driver.findElement(By.id("session_key")).click();
		driver.findElement(By.id("session_key")).sendKeys("identifiant@domaine.fr");
		// click et input du champs password
		driver.findElement(By.id("session_password")).click();
		driver.findElement(By.id("session_password")).sendKeys("motDePasse");
		// click sur le bouton connexion
		driver.findElement(By.cssSelector(".sign-in-form__submit-button")).click();

	}

	@Then("^il arrive sur la page d accueil et ne peut pas administrer$")
	public void il_arrive_sur_la_page_d_accueil_et_ne_peut_pas_administrer() {
		System.out.println("-----@Then-----");
		assertThat(driver.getTitle(), is("Accueil-Quizz"));
		List<WebElement> elements = driver.findElements(By.id("admin_button"));
		assert (elements.size() == 0);

	}

	@When("^le stagiaire entre un identifiant ou un mot de passe errone$")
	public void le_stagiaire_entre_un_identifiant_ou_un_mot_de_passe_errone() {
		System.out.println("-----@When-----");
		// click et input du champs identifiants
		driver.findElement(By.id("session_key")).click();
		driver.findElement(By.id("session_key")).sendKeys("identifiant@domaine.fr");
		// click et input du champs password
		driver.findElement(By.id("session_password")).click();
		driver.findElement(By.id("session_password")).sendKeys("motDePasseErrone");
		// click sur le bouton connexion
		driver.findElement(By.cssSelector(".sign-in-form__submit-button")).click();

	}
}
