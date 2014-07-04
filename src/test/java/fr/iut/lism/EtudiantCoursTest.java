package fr.iut.lism;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EtudiantCoursTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/lism/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
  }

  @Test
  public void testEtudiantCours() throws Exception {
	  System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	  driver.get(baseUrl);
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("llienafa");
    driver.findElement(By.id("mdp")).clear();
    driver.findElement(By.id("mdp")).sendKeys("llienafa");
    driver.findElement(By.name("ok")).click();
    driver.findElement(By.linkText("Inscription")).click();
    driver.findElement(By.linkText("Informatique")).click();
    driver.findElement(By.linkText("En savoir plus")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Mes cours")).click();
    driver.findElement(By.linkText("Se désinscrire")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Voulez-vous vous désinscrire [\\s\\S]$"));
    driver.findElement(By.linkText("Accueil")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
