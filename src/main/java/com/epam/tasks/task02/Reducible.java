package com.epam.tasks.task02;

/**
 * Created by Komarov Vasiliy on 07.10.2017.
 */
public interface Reducible<E> {
    E reduce (E element1, E element2);
}
