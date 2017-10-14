package com.epam.tasks.task04.ex2;

import java.util.*;

/**
 * Created by Komarov Vasiliy on 13.10.2017.
 */
public class Demonstration {
    public static List<Author> authors;
    public static List<Book> books;

    public static void start(){
        authors = FillData.fillAuthors();
        books = FillData.fillBooks(authors);

        System.out.println("-- Average age of authors --");
        double averageAge = authors
                .stream()
                .mapToInt(Author::getAge)
                .average()
                .getAsDouble();
        System.out.println(Math.round(averageAge) + " years");

        System.out.println();

        System.out.println("-- List of authors sorted by age --");
        authors.stream()
                .sorted(Comparator.comparing(Author::getAge))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("-- Pensioners on 2017 --");
        authors.stream()
                .filter(a -> a.getDateOfDeath() == null
                        && ((a.getSex() == Sex.MAN && a.getAge() >= 65)
                        || (a.getSex() == Sex.WOMAN && a.getAge() >= 63)))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("-- Book & Age --");
        Calendar currentDate = new GregorianCalendar();
        books.stream()
                .forEach(b -> System.out.printf("Title: %-10s age: %-3s%n"
                        , b.getTitle()
                        , (currentDate.get(Calendar.YEAR) - b.getYearOfIssue())));

        System.out.println();

        System.out.println("-- Co-authorship --");
        List<Author> coAuthorship = new ArrayList<>();
        books.stream()
                .filter(b -> (b.getAuthors().size() > 1))
                .forEach(b -> coAuthorship.addAll(b.getAuthors()));
        coAuthorship.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("-- Author & Books --");
        authors.stream()
                .forEach(a -> {
                    System.out.print(a.getName() + ": ");
                    books.stream()
                            .filter(b -> b.getAuthors().contains(a))
                            .forEach(b -> System.out.print(b.getTitle() + " "));
                    System.out.println();
                });
    }
}
