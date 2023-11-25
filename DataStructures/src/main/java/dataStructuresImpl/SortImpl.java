package dataStructuresImpl;

import dataStructures.Sort;

import java.util.Arrays;

/**
 * implementing different sort strategies, general information for each sort is provided in interface class
 */
public class SortImpl implements Sort {

    @Override
    public void bubbleSort(int[] arr) {
        // starting from the last element, and move all item from the start to the top if their value is greater than the
        // previous one
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void selectionSort(int[] arr) {
        // starting by the lowest index and keeping track of the lowest value index
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int minIndex = i;
            while (j < arr.length) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            // if it's not equal, will swap the value, so we have low at the right while we go through
            // the list
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    @Override
    public void insertionSort(int[] arr) {
        // starting from start, go util the end and for each element while it is less than the previous one, move it unless
        // it places at the right order
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i - 1; j > -1; j--) {
                if (arr[k] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;
                    k = j;
                }
            }
        }
    }

    @Override
    public int[] mergeSort(int[] arr) {
        // if it was 1, then it will be our breaking point, return the array
        if (arr.length == 1) return arr;

        int midIndex = arr.length / 2;

        // passing the half of arrays, one left and one right
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

        // finally, merge all arrays through the call stack to build sorted array
        return merge(left, right);
    }

    /**
     * merge function is sub function for merge sort, it merges two passed array in sorted way
     * @param a
     * @param b
     * @return
     */
    private int[] merge(int[] a, int[] b) {
        // create an array with length of two array we want to merge
        int[] combined = new int[a.length + b.length];
        int index = 0;
        int i = 0;
        int j =0;

        // start to add items to merge array until it reaches to the end of one of the arrays
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                combined[index] = a[i];
                index++;
                i++;
            } else {
                combined[index] = b[j];
                index++;
                j++;
            }
        }

        // here if first array still has items and second one is empty, simply add the remaining items
        while (i < a.length){
            combined[index] = a[i];
            index++;
            i++;
        }
        // here if second array still has items and first one is empty, simply add the remaining items
        while (j < b.length){
            combined[index] = b[j];
            index++;
            j++;
        }
        return combined;
    }

    @Override
    public void quickSort(int[] arr) {
        // start the quick sort recursively by setting the left index from 0 and right index to last index
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * passing the left and right to quickSort to complete function recursively
     * @param arr
     * @param left
     * @param right
     */
    private void quickSort(int[] arr, int left, int right) {
        // check whether left is less than right, to see if left and right reached or not
        if (left < right) {
            // sort based on the pivot and return the pivot
            int swapIndex = pivot(arr, left, right);
            // call quickSort recursively from left to before swap index to completely sort the array
            quickSort(arr, left, swapIndex - 1);
            // call quickSort recursively from after swap index to right to completely sort the array
            quickSort(arr, swapIndex + 1, right);
        }
    }

    /**
     * pivot function takes pivot index and the index that it should sort the array to
     * @param arr
     * @param pivotIndex
     * @param endIndex
     * @return
     */
    private int pivot(int[] arr, int pivotIndex, int endIndex) {
        // set swapIndex
        int swapIndex = pivotIndex;
        // go from after pivot to the end and swap whenever an element that swapIndex is on is less than the pivot, swap it with
        // swapIndex and move swapIndex to one forward and continue to iterate in the list
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (arr[i] < arr[pivotIndex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, swapIndex, pivotIndex);

        return swapIndex;
    }

    /**
     * swap is helper function to simply swap array elements
     * @param arr
     * @param swapIndex
     * @param i
     */
    private void swap(int[] arr, int swapIndex, int i) {
        int temp = arr[swapIndex];
        arr[swapIndex] = arr[i];
        arr[i] = temp;
    }
}
