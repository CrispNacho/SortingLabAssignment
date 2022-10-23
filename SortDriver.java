import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class SortDriver {

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
            SelectionSort ob = new SelectionSort();
		    ob.selecionSort(randomNumbers);

        }else if(sortType == 2){
            SortDriver ob = new SortDriver();
			ob.sort(randomNumbers, 0, numOfIntValues - 1); //user input array goes here instead

        }else if(sortType == 3){
            SortDriver ob = new SortDriver();
            ob.insertionSort(randomNumbers);
        }else if(sortType == 4){
            quickSort(randomNumbers, 0, numOfIntValues - 1);
            System.out.println("Sorted array: ");  
        }
        long postSort = System.currentTimeMillis();
        System.out.println(postSort - preSort);
        //printArray(randomNumbers, numOfIntValues);
        
	}
}