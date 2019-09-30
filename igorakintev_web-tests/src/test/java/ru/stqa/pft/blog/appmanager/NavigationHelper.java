package ru.stqa.pft.blog.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Sunny on 30.09.2019.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void adminPage() {
    if (isElementPresent(By.tagName("h1"))
            && driver.findElement(By.cssSelector("h1.dashboard-title")).getText().equals("Панель управления")) {
      return;
    }
    click(By.xpath("(//a[contains(@href, '/admin/')])[3]"));
  }

  public void checkTitle(String locator) {
    try {
      String x = driver.findElement(By.cssSelector("#content > h1")).getText();
      Assert.assertEquals(x, locator);
    } catch (NoSuchElementException ex) {
    } return;
  }

  public void blogPage() {
    driver.get("https://igorakintev.ru/admin/blog/");
  }
}
