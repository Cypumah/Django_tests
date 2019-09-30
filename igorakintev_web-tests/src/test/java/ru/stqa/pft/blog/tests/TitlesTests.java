package ru.stqa.pft.blog.tests;

import org.testng.annotations.Test;

/**
 * Created by Sunny on 30.09.2019.
 */
public class TitlesTests extends TestBase{

  @Test
  public void testTitleMainPage() throws Exception {
    app.goTo().adminPage();
    app.goTo().checkTitle("Панель управления", ("h1.dashboard-title"));
  }

  @Test
  public void testTitleCreateEntryPage() throws Exception {
    app.goTo().adminPage();
    app.entry().initEntryCreation();
    app.goTo().checkTitle("Добавить entry", (("#content > h1")));
  }

}
