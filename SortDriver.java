import java.util.Scanner;
 public class SortDriver{
    public static void main(String[] args) {
        int sortType = getSortType();
        int numOfIntValues = getNumOfIntValues();
        int y = 0;
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
    
 }