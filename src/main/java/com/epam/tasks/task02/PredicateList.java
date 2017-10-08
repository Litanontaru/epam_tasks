package com.epam.tasks.task02;

import com.epam.tasks.task03.Convertible;
import com.epam.tasks.task03.Reducible;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Komarov Vasiliy on 30.09.2017.
 */

public class PredicateList<E> implements List<E> {
    private ArrayList<E> elements;
    private Predicate<E> predicate;

    public PredicateList(Collection<? extends E> c, Predicate<E> predicate){
        this.elements = new ArrayList<>(c);
        this.predicate = predicate;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int indexOf(Object o) {
        return elements.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return elements.indexOf(o);
    }

    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return elements.toArray(a);
    }

    E elementData(int index) {
        return elements.get(index);
    }

    @Override
    public E get(int index) {
        return elements.get(index);
    }

    @Override
    public E set(int index, E element) {
        return elements.set(index, element);
    }

    @Override
    public boolean add(E e) {
        if (predicate.test(e)) return false;
        else return elements.add(e);
    }

    @Override
    public void add(int index, E element) {
        if (!predicate.test(element)) {
            elements.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return elements.addAll(getCollectionWithoutPredicate(c));
    }

    private Collection<E> getCollectionWithoutPredicate (Collection<? extends E> c){
        List<E> newCollection = new ArrayList<>();
        if (c.size() != 0){
            for (E element : c){
                if (!predicate.test(element)) {
                    newCollection.add(element);
                }
            }
        }
        return newCollection;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return elements.addAll(index, getCollectionWithoutPredicate(c));
    }

    @Override
    public E remove(int index) {
        if (predicate.test(elementData(index))){
            return elementData(index); // without removing
        }
        return elements.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        if (elements.contains(o)){
            removeE((E) o);
        }
        return false;
    }

    private boolean removeE(E element){
        if (predicate.test(element)){
            return false;
        }
        return elements.remove(element);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, true);
    }

    private boolean batchRemove(Collection<?> c, boolean complement){
        boolean modified = false;
        for (E element : this){
            if (c.contains(element) == complement){
                if (removeE(element)){
                    modified = true;
                }
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, false);
    }

    @Override
    public void clear() {
        elements.clear();
    }


    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        int cursor = 0;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            if (cursor < elements.size()){
                if (getNextIndex() >= 0) return true;
            }
            return false;
        }

        private int getNextIndex(){
            for (int i = cursor; i < elements.size(); i++) {
                if (!predicate.test(elementData(i))){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public E next() {
            if (cursor >= elements.size()){
                throw new NoSuchElementException();
            }
            cursor = lastRet = getNextIndex();
            cursor++;
            return elementData(lastRet);
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > elements.size())
            throw new IndexOutOfBoundsException("Index: " + index);
        return new ListItr(index);
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    private class ListItr extends Itr implements ListIterator<E> {

        public ListItr(int index) {
            super();
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            if (cursor > 0){
                if (getPreviousIndex() >= 0) return true;
            }
            return false;
        }

        private int getPreviousIndex(){
            for (int i = cursor - 1; i >= 0; i--) {
                if (!predicate.test(elementData(i))){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public E previous() {
            if (cursor < 0){
                throw new NoSuchElementException();
            }
            cursor = lastRet = getPreviousIndex();
            return elementData(lastRet);
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            PredicateList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }

        @Override
        public void set(E e) {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            PredicateList.this.set(lastRet, e);
        }

        @Override
        public void add(E e) {
            PredicateList.this.add(cursor, e);
            cursor++;
            lastRet = -1;
        }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if ( fromIndex < 0 || toIndex > elements.size()){
            throw new IndexOutOfBoundsException();
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
        List<E> tmpList = new ArrayList<>();
        for (int i = fromIndex; i <= toIndex; i++) {
            tmpList.add(elementData(i));
        }
        return new PredicateList<>(tmpList ,predicate);
    }

    public <T> List<T> map(Convertible<E, T> function){
        int capacity = size();
        if (capacity == 0){
            throw new NoSuchElementException();
        }
        else {
            List<T> resultList = new ArrayList<>();
            for (int i = 0; i < capacity; i++){
                resultList.add(function.map(elementData(i)));
            }
            return resultList;
        }
    }

    public E reduce (Reducible<E> function){
        int capacity = size();
        if (capacity == 0){
            throw new NoSuchElementException();
        }
        else if (capacity == 1) {
            return elementData(0);
        }
        else {
            E result = elementData(0);
            for (int i = 1; i < capacity; i++) {
                result = function.reduce(result, elementData(i));
            }
            return result;
        }
    }
}
