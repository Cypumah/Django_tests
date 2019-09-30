package ru.stqa.pft.blog.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.blog.model.EntryData;

/**
 * Created by Sunny on 30.09.2019.
 */
public class EntryHelper extends HelperBase{

  public EntryHelper(WebDriver driver) {
    super (driver);
  }

  public void blogPage() {
    driver.findElement(By.linkText("Blog")).click();
  }

  public void submitEntryCreation() {
    driver.findElement(By.name("_save")).click();
  }

  public void fillEntryForm(EntryData entryData) {
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

  public void initEntryCreation() {
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Entries'])[2]/following::span[1]")).click();
  }

  public void submitDeletion() {
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
  }

  public void deleteEntry() {
    driver.findElement(By.linkText("Удалить")).click();
  }

  public void selectEntry() {
    driver.findElement(By.linkText("Entry Title234234234")).click();
  }
}
