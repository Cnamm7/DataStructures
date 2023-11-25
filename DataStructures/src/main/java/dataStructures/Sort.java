package dataStructures;
/**
 * implementing array sorting different methods
 */
public interface Sort {
    /**
     * basic sorting algorithm, starting by moving the greatest value to the end, and do the same for other elements
     * time complexity = O (n ^ 2)
     * @param arr
     */
    public void bubbleSort(int[] arr);

    /**
     * start from the index zero and go through the length of array, will keep the record of the index of lower value
     * and then swap it with current index, in this case our list will start to sort from right to left low to high
     * time complexity = O (n ^ 2)
     * @param arr
     */
    public void selectionSort(int[] arr);

    /**
     * this sort starts from beginning and continue sorting by comparing each element by previous ones, unless putting each element
     * at the right place
     * time complexity = O (n ^ 2)
     * @param arr
     */
    public void insertionSort(int[] arr);

    /**
     * Breaking the array into half until it has one element which is sorted by default,
     * then it starts to merge arrays to finally create a sorted array
     * time complexity = O (n * log(n))
     * @param arr
     * @return
     */
    public int[] mergeSort(int[] arr);

    /**
     * in quick sort we are going to get a pivot, starting from the first index, go through the array and sort all the items according
     * to the pivot until the end, and at the end of itteration, all the items in the array are either less than pivot to left side
     * and or more than pivot to the right sid, then we change the pivot with the last item to put pivot to the correct place, this
     * action will continue recursively until we reach a point that we have a sorted array
     * time complexity = O (n * log(n))
     * @param arr
     */
    public void quickSort(int[] arr);
}
