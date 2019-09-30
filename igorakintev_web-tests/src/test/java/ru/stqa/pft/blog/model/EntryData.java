package ru.stqa.pft.blog.model;

public class EntryData {

  private String title;
  private String slug;
  private String markdown;
  private String text;

  public EntryData withTitle(String title) {
    this.title = title;
    return this;
  }

  public EntryData withSlug(String slug) {
    this.slug = slug;
    return this;
  }

  public EntryData withMarkdown(String markdown) {
    this.markdown = markdown;
    return this;
  }

  public EntryData withText(String text) {
    this.text = text;
    return this;
  }


  public String getTitle() {
    return title;
  }

  public String getSlug() {
    return slug;
  }

  public String getMarkdown() {
    return markdown;
  }

  public String getText() {
    return text;
  }
}
