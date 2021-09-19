import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {

        /** Basic Case:
         * stopIndex becomes array.length -1
         * while( stopIndex > 0){
         *     initialize inner loop index ,i
         *     while( i < stopIndex){
         *         if( array[i] > array[i+1])
         *             swap values at i and i+1
         *         increment i
         *     decrement stopIndex
         */

        /** Optimization 1 & 2 (if no swaps are needed for an entire iteration, early termination)
         * (Add swapsMade boolean variable)
         * (track index of when last swap occurred)
         * stopIndex becomes array.length -1
         * while( stopIndex > 0){
         *     initialize lastSwapped to mark swap index
         *     initialize inner loop index ,i
         *     while( i < stopIndex){
         *         if( array[i] > array[i+1])
         *             swap values at i and i+1
         *             lastSwapped = i
         *         increment i
         *     stopIndex = lastSwapped
         */

        int stopIndex = arr.length-1;
        while(stopIndex != 0){
                int i = 0; //inner loop index
                int lastSwapped = 0;
                while( i < stopIndex){
                    if (comparator.compare(arr[i], arr[i+1]) > 0){
                        T temp = arr[i+1];
                        arr[i+1] = arr[i];
                        arr[i] = temp;
                        lastSwapped = i;
                    }
                    i++;
                }
                if(lastSwapped != stopIndex)
                    stopIndex = lastSwapped;
                else
                    stopIndex --;
            }
        }


    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {

        for(int n = 0; n < arr.length; n++){
            int smallest = n;
            for (int i = n+1; i < arr.length; i++) {
                if (comparator.compare(arr[smallest], arr[i]) > 0)
                    smallest = i;
            }
            T temp = arr[n];
            arr[n] = arr[smallest];
            arr[smallest] = temp;
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        /**
         * for(int i = 0; i>arr.length; i++)
         *     int innerLoop = 0
         *     while( i != 0 && arr[i] < arr[i+1])
         *         swap values at i and i - 1
         *         decrement i
         */
        for(int outerLoop = 1; outerLoop < arr.length; outerLoop++){
            int innerLoop = outerLoop;
                while (innerLoop != 0 && comparator.compare(arr[innerLoop], arr[innerLoop - 1]) < 0) {
                    T temp = arr[innerLoop - 1];
                    arr[innerLoop - 1] = arr[innerLoop];
                    arr[innerLoop] = temp;
                    innerLoop--;
                }
        }
    }
}