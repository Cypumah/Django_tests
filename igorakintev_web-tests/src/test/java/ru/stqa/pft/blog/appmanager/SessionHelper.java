package ru.stqa.pft.blog.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Sunny on 30.09.2019.
 */
public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver driver) {
    super(driver);
  }

  public void login(String username, String password) {
    type(By.id("id_username"), username);
    type(By.id("id_password"), password);
    click(By.xpath("//input[@value='Войти']"));
  }
}