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
}
