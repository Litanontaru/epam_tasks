package com.epam.tasks.task04.ex2;

import java.util.List;

/**
 * Created by Komarov Vasiliy on 13.10.2017.
 */
public class Book {
    private String title;
    private int yearOfIssue;
    private List<Author> authors;

    public Book(String title, int yearOfIssue, List<Author> authors) {
        this.title = title;
        this.yearOfIssue = yearOfIssue;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String toString() {
        StringBuilder lineAuthors = new StringBuilder();
        getAuthors().stream().forEach(a -> lineAuthors.append(a.getName() + " "));
        return String.format("Title: %-10s year of issue: %-4s authors: %s"
                , getTitle()
                , getYearOfIssue()
                , lineAuthors);
    }
}
