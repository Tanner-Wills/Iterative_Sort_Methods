import java.util.Arrays;
import java.util.Comparator;

public class SortTesting {
    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            int comparisons;
            int swaps;
            public int compare(Integer o1, Integer o2) {
                comparisons ++;
                if(o1-o2 > 0)
                    swaps++;
                System.out.println("Comparisons: " + comparisons);
                System.out.println("Swaps: " + swaps);
                return o1 - o2;
            }
        };

        Integer[] testArray = {5,6,7,8,1,2,3,4};
        //Integer[] testArray = {2,3,4,5,1};


        Sorting.insertionSort(testArray, comparator);
        //Sorting.selectionSort(testArray,comparator);
        System.out.println(Arrays.toString(testArray));


    }
}
