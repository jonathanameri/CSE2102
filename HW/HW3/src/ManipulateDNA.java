import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math.*;
import java.lang.*;

public class ManipulateDNA {

    public static void main(String[] args)
    {
        //instantiate scanner object
        Scanner sc = new Scanner(System.in);

        //Get name of input file
        System.out.print("Enter the name of the input file: ");
        String inputFile = sc.nextLine();

        //Initialize variables
        Scanner inputStream = null;
        String line;
        String reverse;
        String complement;
        String complementReverse;
        char curChar;
        char complementChar;
        int number = 1;

        //Try to open input file
        try{
            inputStream = new Scanner(new File(inputFile));
        }
        //If file can't be opened, print error and exit program
        catch(FileNotFoundException e){
            System.out.println("Error opening the file " + inputFile);
            System.exit(0);
        }

        //Iterate through each line of input file
        while (inputStream.hasNextLine())
        {
            complement = "";
            //Scan current line
            line = inputStream.nextLine();
            //Determine the reverse of the input
            reverse = new StringBuffer(line).reverse().toString();

            //Iterate through each character of line
            for(int i = 0; i < line.length(); i++)
            {
                curChar = line.charAt(i);
                //Initialize complementChar as curChar in case it is entered incorrectly
                complementChar = curChar;
                //For each possible case, determine the complement
                if (curChar == 'A') complementChar = 'T';
                if (curChar == 'T') complementChar = 'A';
                if (curChar == 'C') complementChar = 'G';
                if (curChar == 'G') complementChar = 'C';
                complement += complementChar;
            }
            //Determine the complement reverse
            complementReverse = new StringBuffer(complement).reverse().toString();

            //Print all the results for the sequence
            System.out.println("\nSequence Number: " + number);
            System.out.println("Input Sequence: " + line);
            System.out.println("Reverse Sequence: " + reverse);
            System.out.println("Complement: " + complement);
            System.out.println("Reverse Complement: " + complementReverse);
            //Increment the number
            number++;
        }
        //Close input stream
        inputStream.close();
    }
}