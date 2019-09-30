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
    //проверка нахождения на нужной странице
    if (isElementPresent(By.tagName("h1"))
            && driver.findElement(By.cssSelector("h1.dashboard-title")).getText().equals("Панель управления")) {
      return;
    }
    click(By.xpath("(//a[contains(@href, '/admin/')])[3]"));
  }

  public void blogPage() {
    //проверка нахождения на нужной странице
    if (isElementPresent(By.tagName("h1"))
            && driver.findElement(By.cssSelector("#content > h1")).getText().equals("Добавить entry")) {
      return;
    }
    driver.get("https://igorakintev.ru/admin/blog/");
  }

  public void checkTitle(String locator, String selector) {
    try {
      selector = driver.findElement(By.cssSelector("#content > h1")).getText();
      Assert.assertEquals(selector, locator);
    } catch (NoSuchElementException ex) {
    } return;
  }
}
