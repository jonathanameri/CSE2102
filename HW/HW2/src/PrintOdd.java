import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

public class PrintOdd {
    public static void main(String[] args){
        //Create scanner
        Scanner sc = new Scanner(System.in);

        //Get name of input file
        System.out.print("Enter the name of the input file: ");
        String inputFile = sc.nextLine();

        //Get name of output file
        System.out.print("Enter the name of the output file: ");
        String outputFile = sc.nextLine();

        //Define variables
        Scanner inputStream = null;
        String line;
        String newLine = null;

        //Try to open input file
        try{
            inputStream = new Scanner(new File(inputFile));
        }
        //If file can't be opened, print error and exit program
        catch(FileNotFoundException e){
            System.out.println("Error opening the file " + inputFile);
            System.exit(0);
        }
        //Try opening output file
        PrintWriter outputStream = null;
        try{
            outputStream = new PrintWriter(outputFile);
        }
        //If file can't be opened, print error and exit program
        catch(FileNotFoundException e){
            System.out.println("Error opening the file " + outputFile);
            System.exit(0);
        }

        //If both files CAN be opened, begin reading input file

        //Iterate through each line of input file
        while (inputStream.hasNextLine())
        {
            line = inputStream.nextLine();
            //Iterate through each character of line
            //Start at index 1 because the
            // first space will appear as early as index 1
            for(int i = 1; i < line.length(); i++)
            {
                //Once the first space is reached,
                // the new line should be every remaining
                // character on the line
                //Character BEFORE space must be a non-space character
                // to ensure that we don't only delete blank space
                if (line.charAt(i) == ' ' && line.charAt(i-1) != ' ')
                {
                    newLine = line.substring(i+1);
                    //Print this new line to the output file
                    outputStream.println(newLine);
                    //Break, to move on to the next line
                    break;
                }
            }
        }

        //Close both the input stream and output stream
        inputStream.close();
        outputStream.close();

    }
}
