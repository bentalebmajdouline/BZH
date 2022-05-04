package Cucumber;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestBzh {
	private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;

  
	  @Given("acceder a https:\\/\\/testing.bzh\\/")
	  public void acceder_a_https_testing_bzh() {
	  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrateur\\Desktop\\chromedriver.exe");
	  	driver = new ChromeDriver();
	      js = (JavascriptExecutor) driver;
	      vars = new HashMap<String, Object>();
	      driver.get("https://www.testing.bzh/");

	  }
	  
	  
	  
	  @When("l utilisateur consulter le catalogue")
	  public void l_utilisateur_consulter_le_catalogue() {
	  	driver.get("https://testing.bzh/");
	  	  driver.manage().window().fullscreen();
	  	  driver.findElement(By.cssSelector(".icon-bar:nth-child(3)")).click();
	  	  driver.findElement(By.id("menu-item-972")).click();
	  	  driver.findElement(By.linkText("Formations")).click();
	  }
	  
	  @Then("l affichage de toutes les formations")
	  public void l_affichage_de_toutes_les_formations() {
	  	driver.quit();
	  }
}












