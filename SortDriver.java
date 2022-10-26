import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SortDriver {
    /**
     * Gets the sort type that the user wants 
     * @return an integer that corresponds to the sort type
     */
	public static int getSortType(){
        while(true){
        Scanner reader = new Scanner(System.in);
        System.out.println("Select a sorting algorithm from the following: 1: Selection Sort 2: Merge/Heap Sort 3: Insertion Sort 4: Quick Sort");
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
    /**
     * Gets number of integer values that a user would like to sort
     * @return the number of int values
     */
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
    public static void getValueFromSet(int sortType){
            String filePath = "predefinedArrays.csv"; 
             // first create file object for file placed at location
             // specified by filepath
             try {
                 // create FileWriter object with file as parameter
                 FileWriter outputfile = new FileWriter(filePath);
                 outputfile.append("Array Size");
                 outputfile.append(",");
                 outputfile.append("Time in milliseconds");
                 outputfile.append(",");
                 outputfile.append("Sort Type " + sortType);
                 outputfile.append("\n");
                for(int i = 0; i < 5; i++){
                    long time = getTimeToSortArray(10000 * (int)Math.pow(2,i), sortType);
                    outputfile.append(Integer.toString(10000 * (int)Math.pow(2,i)));
                    outputfile.append(",");
                    outputfile.append(Long.toString(time));
                    outputfile.append("\n");
                }
           
                 // closing writer connection
                 outputfile.close();
             }
             catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
            
        }
        

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
			arr[i] =  rand.nextInt(Integer.MAX_VALUE);
		}
		return arr;
	}
    //Quick sort methods

    /**
     * Sorts the array using selection sort method
     * @param arr array with integers to sort
     */
    void selecionSort(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
		{
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}
    
    /** 
     * Sorts the array using merge sort method
     * @param arr the array to sort
     * @param l index to start at
     * @param m middle
     * @param r ending index of the array
     */
    void mergeSort(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int [n1];
		int R[] = new int [n2];

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i)
			L[i] = arr[l + i];
		for (int j=0; j<n2; ++j)
			R[j] = arr[m + 1+ j];


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}

    // Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r)
	{
		if (l < r)
		{
			// Find the middle point
			int m = (l+r)/2;
 
			// Sort first and second halves
			sort(arr, l, m);
			sort(arr , m+1, r);

			// Merge the sorted halves
			mergeSort(arr, l, m, r);
		}
	}

    static void quickSortswap(int[] arr, int i, int j)
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
    static int quickSortPartition(int[] arr, int low, int high)
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
                quickSortswap(arr, i, j);
            }
        }
        quickSortswap(arr, i + 1, high);
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
            int pi = quickSortPartition(arr, low, high);
  
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    //Insertion sort method
    void insertionSort(int arr[])
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
    /**
     * Gets the time in milliseconds to sort in an array of a varying size
     * @param size the number of values in the array
     * @param sortType the number corresponding to sort type of the array
     * @return the long value of the time in milliseconds to sort the array
     */
    public static long getTimeToSortArray(int size, int sortType){
        int[] randomNumbers = randomValues(size);
        long preSort = System.currentTimeMillis();
        SortDriver ob = new SortDriver();
        if(sortType == 1){          
		    ob.selecionSort(randomNumbers);
        }else if(sortType == 2){       
			ob.sort(randomNumbers, 0, size - 1); //user input array goes here instead
        }else if(sortType == 3){
            ob.insertionSort(randomNumbers);
        }else if(sortType == 4){
            quickSort(randomNumbers, 0, size - 1);
        }
        long postSort = System.currentTimeMillis();

        // Print min and max values
        // min and max value

        System.out.println("Minimum Value");
        int min = randomNumbers[0];
            System.out.println(min);

        System.out.println("Maximum Value");
        int max = randomNumbers[randomNumbers.length-1];
            System.out.println(max);


        return postSort - preSort;
    }
	// Driver method
	public static void main(String args[]) {
        System.out.println("Welcome To The Sorting Machine");
		int sortType = getSortType();

		int numOfIntValues = getNumOfIntValues();
        if(numOfIntValues == -1){
            getValueFromSet(sortType);
            System.out.println("Done writing to file"); 
        }else{
            long time;
            time = getTimeToSortArray(numOfIntValues, sortType);
            System.out.print("Sort Time: " + time + " Miliseconds");
            }
            
        }

        
	}
