package nl.hva.ict.ss;

import java.util.LinkedList;

public class AdvancedSorts {

    /**
     * Implement quicksort using LinkedList only! Usage of anything but
     * LinkedList will result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> LinkedList<E> quickSort(LinkedList<E> unsorted) {
        if(unsorted.size() == 0){
            return unsorted;
        }else{
            return sort(unsorted, 0, unsorted.size() - 1);
        }
    }

    /**
     * Implement quicksort using arrays only! Usage of anything but arrays will
     * result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> E[] quickSort(E[] unsorted) {
        if(unsorted.length == 0){
            return unsorted;
        }else{
            return sort(unsorted, 0, unsorted.length - 1);
        }
    }

    public static <E extends Comparable<E>> E[] sort(E[] a, int lo, int hi) {
        if (hi <= lo) {
            return a;
        }
        int j = partition(a, lo, hi); 
        sort(a, lo, j - 1);              
        sort(a, j + 1, hi);   
        return a;
    }

    public static <E extends Comparable<E>> LinkedList<E> sort(LinkedList<E> a, int lo, int hi) {
        if (hi <= lo) {
            return a;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
        return a;
    }

    private static <E extends Comparable<E>> int partition(E[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;            // left and right scan indices
        E v = a[lo];            // partitioning item
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;

    }

    private static <E extends Comparable<E>> int partition(LinkedList<E> a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;            // left and right scan indices
        E v = a.get(lo);            // partitioning item
        while (true) {
            while (less(a.get(++i), v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a.get(--j))) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;

    }

    private static <E extends Comparable<E>> boolean less(E v, E w) {
        return v.compareTo(w) < 0;
    }

    private static <E extends Comparable<E>> void exch(E[] a, int i, int j) {
        E t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static <E extends Comparable<E>> void exch(LinkedList<E> a, int i, int j) {
        E t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }
}
