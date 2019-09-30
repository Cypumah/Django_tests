package ru.stqa.pft.blog.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.blog.model.EntryData;
import ru.stqa.pft.blog.model.RandomInput;

public class EntryTests extends TestBase {

  @Test
  public void testEntryCreation() throws Exception {
    app.goTo().adminPage();
    app.entry().initEntryCreation();
    EntryData entry = new EntryData()
            .withTitle(RandomInput.getAlphaNumericString(5)).withSlug(RandomInput.getAlphaNumericString(7)).withMarkdown(RandomInput.getAlphaNumericString(9)).withText(RandomInput.getAlphaNumericString(2));
    app.entry().fillEntryForm(entry);
    app.entry().submitEntryCreation();
    app.goTo().blogPage();
    app.entry().selectEntry(entry);
    app.entry().deleteEntry();
    app.entry().submitDeletion();
  }

}
