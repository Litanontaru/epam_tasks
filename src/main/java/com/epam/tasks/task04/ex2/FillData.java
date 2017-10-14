package com.epam.tasks.task04.ex2;

import java.util.*;

/**
 * Created by Komarov Vasiliy on 13.10.2017.
 */
public class FillData {
    public static List<Author> fillAuthors(){
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Author-01"
                , new GregorianCalendar(1955, 6, 19)
                , Sex.MAN));
        authors.add(new Author("Author-02"
                , new GregorianCalendar(1915, 2, 7)
                , new GregorianCalendar(1991, 3, 8)
                , Sex.MAN));
        authors.add(new Author("Author-03"
                , new GregorianCalendar(1975, 11, 23)
                , Sex.WOMAN));
        authors.add(new Author("Author-04"
                , new GregorianCalendar(1948, 6, 10)
                , Sex.MAN));
        authors.add(new Author("Author-05"
                , new GregorianCalendar(1953, 12, 2)
                , Sex.WOMAN));
        authors.add(new Author("Author-06"
                , new GregorianCalendar(1894, 3, 3)
                , new GregorianCalendar(1952, 8, 30)
                , Sex.MAN));
        authors.add(new Author("Author-07"
                , new GregorianCalendar(1925, 10, 7)
                , new GregorianCalendar(2002, 4, 1)
                , Sex.WOMAN));
        authors.add(new Author("Author-08"
                , new GregorianCalendar(1953, 7, 21)
                , Sex.WOMAN));
        authors.add(new Author("Author-09"
                , new GregorianCalendar(1948, 1, 5)
                , new GregorianCalendar(1999, 5, 13)
                , Sex.MAN));
        authors.add(new Author("Author-10"
                , new GregorianCalendar(1953, 12, 2)
                , Sex.WOMAN));

        return authors;
    }

    public static List<Book> fillBooks(List<Author> authors){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Title-01", 1970, Arrays.asList(authors.get(1))));
        books.add(new Book("Title-02", 1992, Arrays.asList(authors.get(0))));
        books.add(new Book("Title-03", 1974, Arrays.asList(authors.get(3), authors.get(4))));
        books.add(new Book("Title-04", 1951, Arrays.asList(authors.get(5))));
        books.add(new Book("Title-05", 1956, Arrays.asList(authors.get(5), authors.get(6))));
        books.add(new Book("Title-06", 1989, Arrays.asList(authors.get(7))));
        books.add(new Book("Title-07", 2000, Arrays.asList(authors.get(2))));
        books.add(new Book("Title-08", 1971, Arrays.asList(authors.get(9))));
        books.add(new Book("Title-09", 1971, Arrays.asList(authors.get(8))));
        books.add(new Book("Title-10", 1983, Arrays.asList(authors.get(8), authors.get(4))));

        return books;
    }
}
