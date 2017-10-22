package com.epam.tasks.task04.ex2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Komarov Vasiliy on 13.10.2017.
 */
public class Demonstration {
    public static final int RETIREMENT_AGE_OF_MEN = 65;
    public static final int RETIREMENT_AGE_OF_WOMEN = 63;

    public static void start(){
        List<Author> authors = new ArrayList<>();
        List<Book> books = new ArrayList<>();

        FillData.fillDate(authors, books);

        printAverageAge(authors);
        printAuthorsSortedByAge(authors);
        printPensioners(authors);
        printBookAndAge(books);
        printCoAuthorship(books);
        printAuthorAndBooks(books);
    }

    private static void printAverageAge(List<Author> authors){
        System.out.println("-- Average age of authors --");
        double averageAge = authors
                .stream()
                .mapToInt(Author::getAge)
                .average()
                .getAsDouble();
        System.out.println(Math.round(averageAge) + " years");
    }

    private static void printAuthorsSortedByAge(List<Author> authors){
        System.out.println("-- List of authors sorted by age --");
        authors.stream()
                .sorted(Comparator.comparing(Author::getAge))
                .forEach(System.out::println);
    }

    private static void printPensioners(List<Author> authors){
        System.out.println("-- Pensioners on 2017 --");
        authors.stream()
                .filter(a -> a.getDateOfDeath() == null
                        && ((a.getSex() == Sex.MAN && a.getAge() >= RETIREMENT_AGE_OF_MEN)
                        || (a.getSex() == Sex.WOMAN && a.getAge() >= RETIREMENT_AGE_OF_WOMEN)))
                .forEach(System.out::println);
    }

    private static void printBookAndAge(List<Book> books){
        System.out.println("-- Book & Age --");
        Calendar currentDate = new GregorianCalendar();
        books.forEach(b -> System.out.printf("Title: %-10s age: %-3s%n"
                , b.getTitle()
                , (currentDate.get(Calendar.YEAR) - b.getYearOfIssue())));
    }

    private static void printCoAuthorship(List<Book> books){
        System.out.println("-- Co-authorship --");
        books.stream()
                .flatMap(b -> b.getAuthors().stream().filter(a -> b.getAuthors().size() > 1))
                .distinct()
                .forEach(System.out::println);
    }

    private static void printAuthorAndBooks(List<Book> books){
        System.out.println("-- Author & Books --");
        books.stream()
                .flatMap(b -> b.getAuthors()
                        .stream()
                        .map(a -> new HashMap.SimpleEntry<>(a.getName(), b.getTitle())))
                .collect(Collectors.groupingBy(HashMap.Entry::getKey
                        , Collectors.mapping(HashMap.Entry::getValue, Collectors.joining(", "))))
                .entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
