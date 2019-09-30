package ru.stqa.pft.blog.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.blog.model.EntryData;
import ru.stqa.pft.blog.model.RandomInput;

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
    login("selenium", "super_password");
  }

  private void login(String username, String password) {
    driver.findElement(By.id("id_username")).click();
    driver.findElement(By.id("id_username")).clear();
    driver.findElement(By.id("id_username")).sendKeys(username);
    driver.findElement(By.id("id_password")).click();
    driver.findElement(By.id("id_password")).clear();
    driver.findElement(By.id("id_password")).sendKeys(password);
    driver.findElement(By.xpath("//input[@value='Войти']")).click();
  }

  @Test
  public void testEntryCreation() throws Exception {
    initEntryCreation();
    fillEntryForm(new EntryData(RandomInput.getAlphaNumericString(5), RandomInput.getAlphaNumericString(7), RandomInput.getAlphaNumericString(9), RandomInput.getAlphaNumericString(2)));
    submitEntryCreation();
    blogPage();
  }

  private void blogPage() {
    driver.findElement(By.linkText("Blog")).click();
  }

  private void submitEntryCreation() {
    driver.findElement(By.name("_save")).click();
  }

  private void fillEntryForm(EntryData entryData) {
    driver.findElement(By.id("id_title")).click();
    driver.findElement(By.id("id_title")).clear();
    driver.findElement(By.id("id_title")).sendKeys(entryData.getTitle());
    driver.findElement(By.id("id_slug")).clear();
    driver.findElement(By.id("id_slug")).sendKeys(entryData.getSlug());
    driver.findElement(By.id("id_text_markdown")).click();
    driver.findElement(By.id("id_text_markdown")).clear();
    driver.findElement(By.id("id_text_markdown")).sendKeys(entryData.getMarkdown());
    driver.findElement(By.id("id_text")).click();
    driver.findElement(By.id("id_text")).clear();
    driver.findElement(By.id("id_text")).sendKeys(entryData.getText());
  }

  private void initEntryCreation() {
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Entries'])[2]/following::span[1]")).click();
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
