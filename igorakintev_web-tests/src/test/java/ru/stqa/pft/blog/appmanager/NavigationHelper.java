package ru.stqa.pft.blog.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Sunny on 30.09.2019.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void adminPage() {
    if (isElementPresent(By.tagName("h1"))
            && driver.findElement(By.tagName("h1")).getText().equals("Панель управления")) {
      return;
    }
    click(By.xpath("(//a[contains(@href, '/admin/')])[3]"));
  }

}
