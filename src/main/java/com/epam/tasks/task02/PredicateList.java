package com.epam.tasks.task02;

import com.epam.tasks.task03.Convertible;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Komarov Vasiliy on 30.09.2017.
 */

public class PredicateList<E> implements List<E> {
    private static final int DEFAULT_SIZE = 10;

    private int elementsCount;

    private Object[] elements;
    private Predicate<E> predicate;

    public PredicateList(Collection<? extends E> c, Predicate<E> predicate){
        elements = c.toArray();
        elementsCount = elements.length;
        if (elementsCount == 0){
            this.elements = new Object[DEFAULT_SIZE];
        }
        this.predicate = predicate;
    }

    @Override
    public int size() {
        return elementsCount;
    }

    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < elementsCount; i++)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = 0; i < elementsCount; i++)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = elementsCount - 1; i >= 0; i--)
                if (elements[i]==null)
                    return i;
        } else {
            for (int i = elementsCount - 1; i >= 0; i--)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, elementsCount);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < elementsCount)
            return (T[]) Arrays.copyOf(elements, elementsCount, a.getClass());
        System.arraycopy(elements, 0, a, 0, elementsCount);
        if (a.length > elementsCount)
            a[elementsCount] = null;
        return a;
    }

    E elementData(int index) {
        return (E) elements[index];
    }

    @Override
    public E get(int index) {
        indexCheck(index);
        return elementData(index);
    }

    private void indexCheck(int index) {
        if (index >= elementsCount || index < 0)
            throw new IndexOutOfBoundsException();
    }


    @Override
    public E set(int index, E element) {
        indexCheck(index);
        E oldValue = elementData(index);
        elements[index] = element;
        return oldValue;
    }

    @Override
    public boolean add(E e) {
        checkAdd(e);
        sizeCheck(elementsCount + 1);
        elements[elementsCount++] = e;
        return true;
    }

    private void checkAdd(E e){
        if (predicate.test(e)){
            throw new IllegalArgumentException("Can't add element: " + e);
        }
    }

    private void sizeCheck(int requiredSize){
        int oldSize = elements.length;
        if (requiredSize > oldSize){
            int newSize = (int)(oldSize * 1.5 + 1);
            if (requiredSize < DEFAULT_SIZE){
                newSize = DEFAULT_SIZE;
            }
            if (newSize < requiredSize){
                newSize = requiredSize;
            }
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    @Override
    public void add(int index, E element) {
        indexCheckSecond(index);
        checkAdd(element);
        sizeCheck(elementsCount + 1);
        System.arraycopy(elements, index, elements, index + 1, elementsCount - index);
        elements[index] = element;
        elementsCount++;
    }

    private void indexCheckSecond(int index) {
        if (index > elementsCount || index < 0)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        checkCollectionForAdd(c);
        Object[] cArray = c.toArray();
        int newElementsCount = cArray.length;
        sizeCheck(elementsCount + newElementsCount);
        System.arraycopy(cArray, 0, elements, elementsCount, newElementsCount);
        elementsCount += newElementsCount;
        return !(newElementsCount == 0);
    }

    private void checkCollectionForAdd(Collection<? extends E> c){
        for (E element : c){
            checkAdd(element);
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        indexCheckSecond(index);
        checkCollectionForAdd(c);
        Object[] cArray = c.toArray();
        int newElementsCount = cArray.length;
        sizeCheck(elementsCount + newElementsCount);

        int numMoved = elementsCount - index;
        if (numMoved > 0)
            System.arraycopy(elements, index, elements, index + newElementsCount,
                    numMoved);

        System.arraycopy(cArray, 0, elements, index, newElementsCount);
        elementsCount += newElementsCount;
        return !(newElementsCount == 0);
    }

    @Override
    public E remove(int index) {
        indexCheck(index);
        E oldValue = elementData(index);
        checkRemove(index);
        doRemove(index);
        return oldValue;
    }

    private void checkRemove(int index){
        if (predicate.test(elementData(index))){
            throw new IllegalArgumentException("Can't remove, index: " + index);
        }
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < elementsCount; index++)
                if (elements[index] == null) {
                    checkRemove(index);
                    doRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < elementsCount; index++)
                if (o.equals(elements[index])) {
                    checkRemove(index);
                    doRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void doRemove(int index) {
        int numMoved = elementsCount - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index,
                    numMoved);
        elementsCount--;
        elements[elementsCount] = null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;

        if (c == null){
            return result;
        }
        for (int i = 0; i < elementsCount; i++){
            if (c.contains(elements[i])){
                remove(elements[i]);
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = false;

        if (c == null){
            return result;
        }
        for (int i = 0; i < elementsCount; i++){
            if (!c.contains(elements[i])){
                remove(elements[i]);
                result = true;
            }
        }

        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < elementsCount; i++){
            elements[i] = null;
        }
        elementsCount = 0;
    }


    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            if (cursor < elementsCount){
                for (int i = cursor; i < elementsCount; i++) {
                    if (predicate.test(elementData(i))){
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override
        public E next() {
            if (cursor >= elementsCount){
                throw new NoSuchElementException();
            }
            for (int i = cursor; i < elementsCount; i++) {
                if (predicate.test(elementData(i))){
                    cursor = i;
                    break;
                }
            }
            cursor++;
            return elementData(cursor - 1);
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        indexCheckSecond(index);
        return new ListItr(index);
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    private class ListItr extends Itr implements ListIterator<E> {
        int lastRet = -1;

        public ListItr(int index) {
            super();
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            if (cursor > 0){
                for (int i = cursor - 1; i >= 0; i--) {
                    if (predicate.test(elementData(i))){
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override
        public E previous() {
            if (cursor < 0){
                throw new NoSuchElementException();
            }
            for (int i = cursor - 1; i >= 0; i--) {
                if (predicate.test(elementData(i))){
                    cursor = i;
                    break;
                }
            }
            return elementData(cursor);
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
        if ( fromIndex < 0 || toIndex > elementsCount){
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
