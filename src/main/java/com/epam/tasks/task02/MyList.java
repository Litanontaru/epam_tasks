package com.epam.tasks.task02;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Komarov Vasiliy on 30.09.2017.
 */

public class MyList<E> implements List<E> {
    private static final int DEFAULT_SIZE = 10;

    private int elemntsCount;

    private Object[] elements;
    private Predicate<E> predicate;

    public MyList(Collection<? extends E> c, Predicate<E> predicate){
        elements = c.toArray();
        elemntsCount = elements.length;
        if (elemntsCount == 0){
            this.elements = new Object[DEFAULT_SIZE];
        }
        this.predicate = predicate;
    }

    @Override
    public int size() {
        return elemntsCount;
    }

    @Override
    public boolean isEmpty() {
        return elemntsCount == 0;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < elemntsCount; i++)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = 0; i < elemntsCount; i++)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = elemntsCount - 1; i >= 0; i--)
                if (elements[i]==null)
                    return i;
        } else {
            for (int i = elemntsCount - 1; i >= 0; i--)
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
        return Arrays.copyOf(elements, elemntsCount);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < elemntsCount)
            return (T[]) Arrays.copyOf(elements, elemntsCount, a.getClass());
        System.arraycopy(elements, 0, a, 0, elemntsCount);
        if (a.length > elemntsCount)
            a[elemntsCount] = null;
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
        if (index >= elemntsCount || index < 0)
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
        sizeCheck(elemntsCount + 1);
        elements[elemntsCount++] = e;
        return true;
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
        sizeCheck(elemntsCount + 1);
        System.arraycopy(elements, index, elements, index + 1,elemntsCount - index);
        elements[index] = element;
        elemntsCount++;
    }

    private void indexCheckSecond(int index) {
        if (index > elemntsCount || index < 0)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] cArray = c.toArray();
        int newElementsCount = cArray.length;
        sizeCheck(elemntsCount + newElementsCount);
        System.arraycopy(cArray, 0, elements, elemntsCount, newElementsCount);
        elemntsCount += newElementsCount;
        return !(newElementsCount == 0);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        indexCheckSecond(index);
        Object[] cArray = c.toArray();
        int newElementsCount = cArray.length;
        sizeCheck(elemntsCount + newElementsCount);

        int numMoved = elemntsCount - index;
        if (numMoved > 0)
            System.arraycopy(elements, index, elements, index + newElementsCount,
                    numMoved);

        System.arraycopy(cArray, 0, elements, index, newElementsCount);
        elemntsCount += newElementsCount;
        return !(newElementsCount == 0);
    }

    @Override
    public E remove(int index) {
        indexCheck(index);
        E oldValue = elementData(index);
        doRemove(index);
        return oldValue;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < elemntsCount; index++)
                if (elements[index] == null) {
                    doRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < elemntsCount; index++)
                if (o.equals(elements[index])) {
                    doRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void doRemove(int index) {
        int numMoved = elemntsCount - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index,
                    numMoved);
        elemntsCount--;
        elements[elemntsCount] = null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;

        if (c == null){
            return result;
        }
        for (int i = 0; i < elemntsCount; i++){
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
        for (int i = 0; i < elemntsCount; i++){
            if (!c.contains(elements[i])){
                remove(elements[i]);
                result = true;
            }
        }

        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < elemntsCount; i++){
            elements[i] = null;
        }
        elemntsCount = 0;
    }


    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            if (cursor < elemntsCount){
                for (int i = cursor; i < elemntsCount; i++) {
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
            if (cursor >= elemntsCount){
                throw new NoSuchElementException();
            }
            for (int i = cursor; i < elemntsCount; i++) {
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
            MyList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }

        @Override
        public void set(E e) {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            MyList.this.set(lastRet, e);
        }

        @Override
        public void add(E e) {
            MyList.this.add(cursor, e);
            cursor++;
            lastRet = -1;
        }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if ( fromIndex < 0 || toIndex > elemntsCount){
            throw new IndexOutOfBoundsException();
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
        List<E> tmpList = new ArrayList<>();
        for (int i = fromIndex; i <= toIndex; i++) {
            tmpList.add(elementData(i));
        }
        return new MyList<>(tmpList ,predicate);
    }
}
