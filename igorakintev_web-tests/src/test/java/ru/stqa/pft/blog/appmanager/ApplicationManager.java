package ru.stqa.pft.blog.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;


/**
 * Created by Sunny on 30.09.2019.
 */
public class ApplicationManager {

  WebDriver driver;
  //private SessionHelper sessionHelper;
 // private NavigationHelper navigationHelper;
 // private GroupHelper groupHelper;
//  private ContactHelper contactHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {

    if (browser.equals(BrowserType.FIREFOX)) {
      driver = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      driver = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      driver = new InternetExplorerDriver();

    }
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    //driver.manage().window().maximize();
    driver.get("https://igorakintev.ru/admin/");
    //groupHelper = new GroupHelper(driver);
    //navigationHelper = new NavigationHelper(driver);
    //contactHelper = new ContactHelper(driver);
    //sessionHelper = new SessionHelper(driver);
   // sessionHelper.login("admin", "secret");
  }


  public void stop() {
    driver.quit();
  }



}
