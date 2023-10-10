import java.util.Scanner;
import java.lang.Math.*;
import java.lang.*;

    public class ManipulateDNA {

        public static void main(String[] args)
        {
            //instantiate scanner object
            Scanner sc = new Scanner(System.in);
            //get user input
            System.out.print("Enter the DNA Sequence: ");
            String DNA = sc.nextLine();

            //print result
            String reverse = new StringBuffer(DNA).reverse().toString();
            System.out.println("Length of the input sequence is "+ DNA.length());
            System.out.println("\nReverse sequence is: "+ reverse);
        }
    }


