import java.util.Scanner;


public class SortDriver{
    /* Java program for Merge Sort */
	// this is a test
	
 
    
    
	void merge(int arr[], int l, int m, int r)
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
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
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
            System.out.println("How many integer values would you like to sort");
            String numOfIntegers = reader.nextLine();
            int x = 0;
            try{x = Integer.parseInt(numOfIntegers);
    
            }catch(Exception numberformatException){
                System.out.println("Enter number");
                continue;
            }
            if(x > 0){        
            return x;
            }
            System.out.println("Enter number above 0");
            }
    }

	// Driver method
	public static void main(String args[])
	{
		int arr[] = {12, 11, 13, 5, 6, 7};

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length-1);

		System.out.println("\nSorted array");
		printArray(arr);
		//evan stuff
		int sortType = getSortType();
        int numOfIntValues = getNumOfIntValues();
	}
}