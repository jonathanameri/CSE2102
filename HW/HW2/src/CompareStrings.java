import java.util.Scanner;
public class CompareStrings {
    public static void main(String[] args){
        //instantiate scanner object
        Scanner sc = new Scanner(System.in);
        //prompts user for input
        System.out.print("Enter the first string:");
        String s1 = sc.nextLine();
        System.out.print("Enter the second string:");
        String s2 = sc.nextLine();
        //compares strings and prints results
        if(s1.equals(s2)){
            System.out.println("\nThe two strings are equal");
        }
        else{
            System.out.println("\nThe two strings are not equal");
            if(s1.equalsIgnoreCase(s2)){
                System.out.println("But the two strings are equal, ignoring case");
            }
            else{
                System.out.println("The two strings are not equal, even ignoring case");
            }
        }


    }
}
