package ru.stqa.pft.blog.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.blog.appmanager.ApplicationManager;

/**
 * Created by Sunny on 30.09.2019.
 */
public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }


  @AfterMethod
  public void tearDown() throws Exception {
    app.stop();
  }
}
