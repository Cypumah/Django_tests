package ru.stqa.pft.blog.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.blog.appmanager.ApplicationManager;
import ru.stqa.pft.blog.model.EntryData;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by Sunny on 30.09.2019.
 */
public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
  //private WebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }



  @AfterMethod
  public void tearDown() throws Exception {
    app.stop();
  }
}
