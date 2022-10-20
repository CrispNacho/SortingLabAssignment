import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class SortDriver {
	// Evan
	public static int getSortType(){
        while(true){
        Scanner reader = new Scanner(System.in);
        System.out.println("Select a sorting algorithm from the following: 1:Selection Sort 2:Insertion Sort 3:Merge/Heap Sort 4:Quick Sort");
        String sortType = reader.nextLine();
        int x = 0;
        try{x = Integer.parseInt(sortType);

        }catch(Exception numberformatException){
            System.out.println("Enter number");
            continue;
        }
        if(x < 5 && x > 0){        
        return x;
        }
        System.out.println("Enter number within range");
        }
        
    }
    public static int getNumOfIntValues(){
        while(true){
            Scanner reader = new Scanner(System.in);
            System.out.println("How many integer values would you like to sort(-1 for preset amount):");
            String numOfIntegers = reader.nextLine();
            int x = 0;
            try{x = Integer.parseInt(numOfIntegers);
    
            }catch(Exception numberformatException){
                System.out.println("Enter number");
                continue;
            }
            if(x > 0 || x == -1){        
            return x;
            }
            System.out.println("Enter number above 0");
            }
    }
    public static int getValueFromSet(){
        while(true){
        Scanner reader = new Scanner(System.in);
        System.out.println("Select a number from the following: 1:10000 2:20000 3:40000 4:80000 5:160000");
        String sortType = reader.nextLine();
        int x = 0;
        try{x = Integer.parseInt(sortType);

        }catch(Exception numberformatException){
            System.out.println("Enter number");
            continue;
        }
        if(x == 1){
            return 10000;
        }else if(x==2){
            return 20000;
        }else if(x==3){
            return 40000;   
        }else if(x==4){
            return 80000;    
        }else if(x==5){
            return 160000;
        }
        System.out.println("Enter number within range");
        }
        
    }
	
	//--------------------------------------------------------------------------//
	/**
	 * Creates an array a certain length depend on parameter
	 * fills the array with random numbers from 0 to 2147483647
	 * @param numOfIntegers //length of the array
	 * @return //the array
	 */
	public static int[] randomValues(int numOfIntegers){
		Random rand = new Random();
		int arr[] = new int[numOfIntegers];
		for(int i = 0; i < arr.length; i++){
			arr[i] =  rand.nextInt(2147483647);
		}
		return arr;
	}
    //Quick sort methods
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  
    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {
  
        // pivot
        int pivot = arr[high];
  
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
  
        for (int j = low; j <= high - 1; j++) {
  
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {
  
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
  
    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
  
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
  
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    //Insertion sort method
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
  
    // Function to print an array
    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
  
        System.out.println();
    }
	// Driver method
	public static void main(String args[]) {
		int sortType = getSortType();
		int numOfIntValues = getNumOfIntValues();
        if(numOfIntValues == -1){
            numOfIntValues = getValueFromSet(); 
        }
        int[] randomNumbers = randomValues(numOfIntValues);
        long preSort = System.currentTimeMillis();
        if(sortType == 1){

        }else if(sortType == 2){

        }else if(sortType == 3){
        SortDriver ob = new SortDriver();
        ob.sort(randomNumbers);
        }else if(sortType == 4){
        quickSort(randomNumbers, 0, numOfIntValues - 1);
        System.out.println("Sorted array: ");  
        }
        long postSort = System.currentTimeMillis();
        System.out.println(postSort - preSort);
        //printArray(randomNumbers, numOfIntValues);
        
	}
}