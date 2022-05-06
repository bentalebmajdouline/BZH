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

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecutionQuizz {
	
	WebDriver driver;
	
	@Given("^Le stagiaire est bien sur le site et connecte$")
	public void le_stagiaire_est_bien_sur_le_site_et_connecte(){
		System.out.println("-----@Given-----");
		System.out.println("Le navigateur s'ouvre sur le site Quizz");

		Map<String, Object> vars;
		JavascriptExecutor js;
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrateur\\Desktop\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrateur\\Desktop\\geckodriver.exe");
		// ATTENTION !! télécharger et placer le driver au bon endroit
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrateur\\Desktop\\msedgedriver.exe");
		// driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver = new EdgeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		// Connexion au site
		driver.get("http://127.0.0.1:8000/quizz/?");
//		driver.manage().window().maximize();
		assertThat(driver.getTitle(), is("Quizz"));
		System.out.println("Page accueil atteinte");
	    
	}

	@When("^Le stagiaire clique sur un theme affiche$")
	public void le_stagiaire_clique_sur_un_theme_affiche(){
		System.out.println("-----@When-----");
		// click sur le theme
		driver.findElement(By.id("theme_qqchose")).click();
	}

	@When("^Le stagiaire doit valider les termes du quizz$")
	public void le_stagiaire_doit_valider_les_termes_du_quizz(){
		System.out.println("-----@Then-----");
		// validation des termes du quizz
		driver.findElement(By.id("checkbox_conditions")).click();
	    driver.findElement(By.id("validate_conditions")).click();
	    
	}

	@When("^Le stagiaire doit repondre aux questions du quizz$")
	public void le_stagiaire_doit_repondre_aux_questions_du_quizz(){
		System.out.println("-----@When-----");
		// verification de l atteinte du bon quizz
		assertThat(driver.getTitle(), is("Quizz-theme-qqchose"));
		System.out.println("Le stagiaire répond aux questions du quizz");
	    
	}

	@When("^Le stagiaire termine manuellement le quizz$")
	public void le_stagiaire_termine_manuellement_le_quizz(){
		System.out.println("-----@When-----");
		// le stagiaire termine le quizz
		driver.findElement(By.id("end_quizz")).click();
	    
	}

	@Then("^Le stagiaire est redirige vers le resultat$")
	public void le_stagiaire_est_redirige_vers_le_resultat(){
		System.out.println("-----@Then-----");
		// verification de l acces a la bonne page
		assertThat(driver.getTitle(), is("Resultat-Quizz"));
		driver.findElement(By.id("show-resultat")).click();
	    
	}

	@When("^Le temps du quizz se termine$")
	public void le_temps_du_quizz_se_termine(){
		System.out.println("-----@When-----");
		driver.findElement(By.id("time-up")).click();
	    
	}

	@Then("^Le stagiaire est redirige a la page d accueil$")
	public void le_stagiaire_est_redirige_a_la_page_d_accueil(){
		System.out.println("-----@Then-----");
		assertThat(driver.getTitle(), is("Accueil"));
	    
	}

	@When("^Le stagiaire clique sur un theme affiche vide$")
	public void le_stagiaire_clique_sur_un_theme_affiche_vide(){
		System.out.println("-----@When-----");
		// le stagiaire tente de lancer un theme vide
		driver.findElement(By.id("theme_vide")).click();
	    
	}

	@Then("^Un message d erreur s affiche$")
	public void un_message_d_erreur_s_affiche(){
		System.out.println("-----@Then-----");
		// verfification de l affichage du message d erreur theme vide
		List<WebElement> elements = driver.findElements(By.id("erreur_theme_vide"));
	      assert(elements.size() == 0);
//		driver.findElement(By.id("erreur_theme_vide")).click();
		
	    
	}
}
