package dataStructuresImpl;

import dataStructures.Sort;

import java.util.Arrays;

public class SortImpl implements Sort {

    @Override
    public void bubbleSort(int[] arr) {
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

        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int minIndex = i;
            while (j < arr.length) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    @Override
    public void insertionSort(int[] arr) {
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
        if (arr.length == 1) return arr;

        int midIndex = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

        return merge(left, right);
    }

    private int[] merge(int[] a, int[] b) {
        int[] combined = new int[a.length + b.length];
        int index = 0;
        int i = 0;
        int j =0;

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

        while (i < a.length){
            combined[index] = a[i];
            index++;
            i++;
        }

        while (j < b.length){
            combined[index] = b[j];
            index++;
            j++;
        }
        return combined;
    }

    @Override
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int swapIndex = pivot(arr, left, right);
            quickSort(arr, left, swapIndex - 1);
            quickSort(arr, swapIndex + 1, right);
        }
    }
    private int pivot(int[] arr, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (arr[i] < arr[pivotIndex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, swapIndex, pivotIndex);

        return swapIndex;
    }

    private void swap(int[] arr, int swapIndex, int i) {
        int temp = arr[swapIndex];
        arr[swapIndex] = arr[i];
        arr[i] = temp;
    }
}
