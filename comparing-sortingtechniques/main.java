package assignment3.ds;
import java.util.Arrays;
import java.util.Random;
public class Assignment3DS {
public static void main(String args[]){
        int size = 10000;
        int[] randomArray = RandomArray(size);
        int[] sortedArray = SortedArray(size);
        int[] inverselySortedArray = InverselySortedArray(size);
        System.out.println("Arrays before sorting: ");
        System.out.println("Random Array: " + Arrays.toString(randomArray));
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Inversely Sorted Array: " + Arrays.toString(inverselySortedArray));
        System.out.println();
        
        System.out.println("Quick Sort: ");
        quickSort(randomArray, 0, randomArray.length - 1);
        System.out.print("Random Array: ");
        System.out.println(Arrays.toString(randomArray));
        quickSort(sortedArray, 0, sortedArray.length - 1);
        System.out.print("Sorted Array: ");
        System.out.println(Arrays.toString(sortedArray));
        quickSort(inverselySortedArray, 0, inverselySortedArray.length - 1);
        System.out.print("Inversely sorted Array: ");
        System.out.println(Arrays.toString(inverselySortedArray));
        System.out.println();
        
        System.out.println("Bubble Sort: ");
        bubbleSort(randomArray);
        System.out.println("Random Array: "+Arrays.toString(randomArray));
        bubbleSort(sortedArray);
        System.out.println("Sorted Array: "+Arrays.toString(sortedArray));
        bubbleSort(inverselySortedArray);
        System.out.println("Inversely Sorted Array: "+Arrays.toString(inverselySortedArray));
        System.out.println();
        
        System.out.println("Radix Sort: ");
        radixSort(randomArray);
        System.out.println("Random Array:  "+Arrays.toString(randomArray));
        radixSort(sortedArray);
        System.out.println("Sorted Array:  "+Arrays.toString(sortedArray));
        radixSort(inverselySortedArray);
        System.out.println("Inversely Sorted Array:  "+Arrays.toString(inverselySortedArray));
        System.out.println();
        
        compareSortingTechniques("Sorted Array", sortedArray);
        compareSortingTechniques("Random Array", randomArray);
        compareSortingTechniques("Inversely Sorted Array", inverselySortedArray);
        
    }

    public static int[] RandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = Math.abs(random.nextInt());
        }
        return array;
    }

    public static int[] SortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] InverselySortedArray(int size) {
        int[] array = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            array[size - 1 - i] = i;
        }
        return array;
    }

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    public static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            incrementComparisons();
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
                incrementInterchanges();
            }
        }
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        incrementInterchanges();
        return i + 1;
    }
    
    public static void bubbleSort(int arr[]) {
      int n = arr.length;
      for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            incrementComparisons();
          if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            incrementInterchanges();
          }
        }
      }
    }
    
    public static void radixSort(int arr[]) {
      int max = getMax(arr);
      int exp = 1;
      while (max / exp > 0) {
        int[] output = new int[arr.length];
        int[] count = new int[10]; 
        for (int i : arr) {
          count[(i / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
          count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
          output[count[(arr[i] / exp) % 10] - 1] = arr[i];
          count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
        exp *= 10;
      }
    }
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    private static void compareSortingTechniques(String arrayType, int[] array) {
        System.out.println("Array Type: " + arrayType);
        
        long startTime, endTime, runTime;
        int[] tempArray;
        
        // Radix Sort
        tempArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        radixSort(tempArray);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Radix Sort - Run Time: " + runTime + " ns, Comparisons: " + getComparisons() + ", Interchanges: " + getInterchanges());
        
        // Bubble Sort
        tempArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        bubbleSort(tempArray);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Bubble Sort - Run Time: " + runTime + " ns, Comparisons: " + getComparisons() + ", Interchanges: " + getInterchanges());
        
        // Quick Sort
        tempArray = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        quickSort(tempArray, 0, tempArray.length - 1);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Quick Sort - Run Time: " + runTime + " ns, Comparisons: " + getComparisons() + ", Interchanges: " + getInterchanges());
        
        System.out.println();
    }
    
    // Utility methods to keep track of comparisons and interchanges
    
    private static long comparisons;
    private static long interchanges;
    
    private static void resetCounters() {
        comparisons = 0;
        interchanges = 0;
    }
    
    private static long getComparisons() {
        long count = comparisons;
        return count;
    }
    
    private static long getInterchanges() {
        long count = interchanges;
        return count;
    }
    
    private static void incrementComparisons() {
        comparisons++;
    }
    
    private static void incrementInterchanges() {
        interchanges++;
    }

}
