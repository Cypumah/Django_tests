package ru.stqa.pft.blog.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EntryCreationTests extends TestBase {
  private WebDriver driver;
 // private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://igorakintev.ru/admin/");
    driver.findElement(By.id("id_username")).click();
    driver.findElement(By.id("id_username")).clear();
    driver.findElement(By.id("id_username")).sendKeys("selenium");
    driver.findElement(By.id("id_password")).click();
    driver.findElement(By.id("id_password")).clear();
    driver.findElement(By.id("id_password")).sendKeys("super_password");
    driver.findElement(By.xpath("//input[@value='Войти']")).click();
  }

  @Test
  public void testEntryCreation() throws Exception {
   // driver.findElement(By.linkText("Панель управления")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Entries'])[2]/following::span[1]")).click();
    //driver.findElement(By.cssSelector("a[href='""']")).click();
    driver.findElement(By.id("id_title")).click();
    driver.findElement(By.id("id_title")).clear();
    driver.findElement(By.id("id_title")).sendKeys("Title234234234");
    driver.findElement(By.id("id_slug")).clear();
    driver.findElement(By.id("id_slug")).sendKeys("Slug3249874");
    driver.findElement(By.id("id_text_markdown")).click();
    driver.findElement(By.id("id_text_markdown")).clear();
    driver.findElement(By.id("id_text_markdown")).sendKeys("aewr32545aw");
    driver.findElement(By.id("id_text")).click();
    driver.findElement(By.id("id_text")).clear();
    driver.findElement(By.id("id_text")).sendKeys("aeraw34awaef");
    driver.findElement(By.name("_save")).click();
    driver.findElement(By.linkText("Blog")).click();
    driver.findElement(By.linkText("Entry Title234234234")).click();
    driver.findElement(By.linkText("Удалить")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
  }

  @AfterMethod
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
