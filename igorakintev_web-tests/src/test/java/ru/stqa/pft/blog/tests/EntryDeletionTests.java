package ru.stqa.pft.blog.tests;

import org.testng.annotations.Test;

/**
 * Created by Sunny on 30.09.2019.
 */
public class EntryDeletionTests extends TestBase{

  @Test
  public void testEntryDeletion() {
    app.goTo().blogPage();
    app.entry().selectEntry();
    app.entry().deleteEntry();
    app.entry().submitDeletion();
  }

}
