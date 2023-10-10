import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamAverager {
    public static void main(String[] args){
        //Initiate variables
        Scanner sc = new Scanner(System.in);
        int inputVal = 0;
        double average;
        int sum;
        Boolean done = Boolean.FALSE;
        String aboveBelowAverage;


        System.out.println("This program computes the average of a list of (nonnegative) exam scores.");

        //Main loop - program doesn't end until 'n' is entered
        while(done != Boolean.TRUE){
            //We use an array that is refreshed with each run of the program
            List<Integer> l1 = new ArrayList<Integer>();
            System.out.println("Enter all the scores to be averaged.");
            System.out.println("Enter a negative number after you have entered all the scores.");
            //Sum variable must be reset each subsequent run
            sum = 0;
            //Inner loop - finishes when a negative number is entered
            while (inputVal >= 0){
                inputVal = sc.nextInt();
                if(inputVal < 0){
                    break;
                }
                //If entered number is non-negative, add it to the array
                l1.add(inputVal);
            }
            //Calculate average
            int length = l1.size();
            for(int i = 0; i < length; i++){
                sum += l1.get(i);
            }
            average = sum/length;

            System.out.println("The average is " + average);

            //Iterate through the ArrayList and print results for each score
            for(int f = 0; f < length; f++){
                double scoreDiff = l1.get(f) - average;
                if(scoreDiff > 0) aboveBelowAverage = "Above average";
                else if (scoreDiff < 0) aboveBelowAverage = "Below average";
                else aboveBelowAverage = "Average";

                System.out.println("Score #" + f + ": " + l1.get(f) + " -- " + aboveBelowAverage);
            }

            //Check if user wants to input more exam scores
            System.out.println("Want to average another exam?");
            System.out.println("Enter yes or no: ");
            char cont = sc.next().charAt(0);

            //Finish loop if user inputs 'n'
            if(cont == 'n' || cont == 'N') done=Boolean.TRUE;
            else if (cont == 'y' || cont == 'Y') {
                inputVal = 0;
            }
        }
    }
}