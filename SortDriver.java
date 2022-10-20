import java.util.Scanner;
import java.util.Random;


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
    //test
	// Driver method
	public static void main(String args[]) {
		int sortType = getSortType();
		int numOfIntValues = getNumOfIntValues();
		int[] randomNumbers = randomValues(numOfIntValues);
	}
}