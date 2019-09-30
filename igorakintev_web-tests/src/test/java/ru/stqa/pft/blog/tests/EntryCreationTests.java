package ru.stqa.pft.blog.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.blog.model.EntryData;
import ru.stqa.pft.blog.model.RandomInput;

public class EntryCreationTests extends TestBase {

  @Test
  public void testEntryCreation() throws Exception {
    app.goTo().adminPage();
    app.entry().initEntryCreation();
    app.goTo().checkTitle("Добавить entry");
    app.entry().fillEntryForm(new EntryData(RandomInput.getAlphaNumericString(5), RandomInput.getAlphaNumericString(7), RandomInput.getAlphaNumericString(9), RandomInput.getAlphaNumericString(2)));
    app.entry().submitEntryCreation();
    app.goTo().blogPage();
  }

}
