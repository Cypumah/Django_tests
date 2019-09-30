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

  public void submitEntryCreation() {
    driver.findElement(By.name("_save")).click();
  }

  public void fillEntryForm(EntryData entryData) {
    type(By.id("id_title"), entryData.getTitle());
    type(By.id("id_slug"), entryData.getSlug());
    type(By.id("id_text_markdown"), entryData.getMarkdown());
    type(By.id("id_text"), entryData.getText());
  }

  public void initEntryCreation() {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Entries'])[2]/following::span[1]"));
  }

  public void submitDeletion() {
    click(By.cssSelector("input[type=\"submit\"]"));
  }

  public void deleteEntry() {
    click(By.linkText("Удалить"));
  }

  public void selectEntry() {
    click(By.linkText("Entry Q3ngb"));
  }
}
