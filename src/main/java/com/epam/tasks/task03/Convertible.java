package com.epam.tasks.task03;

/**
 * Created by Komarov Vasiliy on 07.10.2017.
 */
public interface Convertible<E, T> {
    T map(E element);
}
