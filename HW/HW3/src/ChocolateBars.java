import java.util.Scanner;
import java.lang.Math.*;
import java.io.*;
import java.lang.*;

public class ChocolateBars {

    public static void main(String[] args)
    {
        //declare variables
        String Gender1="";
        String Extent1 = "";
        double Mod =0;
        double Chocolate = 0;
        double BMR = 0;
        boolean GenderFlag=false;
        boolean ExtentFlag=false;
        boolean FirstIteration=false;
        //instantiate scanner object
        Scanner sc = new Scanner(System.in);
        //get user input
        System.out.print("Enter the weight in pounds: ");
        int weight = sc.nextInt();
        System.out.print("Enter the height in inches: ");
        int height = sc.nextInt();
        System.out.print("Enter the age in years: ");
        int age = sc.nextInt();
        //ask for user input until valid input is given
        while(true){
            if(FirstIteration==true) {
                System.out.print("Enter M for man, W for woman: ");
            }
                String Gender = sc.nextLine();
                if ((Gender.equals("M")) || (Gender.equals("W"))) {
                    Gender1 = Gender;
                    FirstIteration=false;
                    break;
                } else if (GenderFlag == true) {
                    System.out.print("Please enter M or W\n");
                }

            GenderFlag=true;
            FirstIteration = true;
        }

        while(true) {
            System.out.print("Enter S for Sendtary, O for Ocassionally, A for Active, H for Highly Active: ");
            String Extent = sc.nextLine();
            if(Extent.equals("S") || Extent.equals("O") || Extent.equals("A") || Extent.equals("H")){
                Extent1=Extent;
                FirstIteration=false;
                break;
            }
            else {
                System.out.print("Please enter S,O,A,H\n");
            }
            FirstIteration=true;
        }

        //Determine BMR modifier based on activity input
        if(Extent1.equals("S")){
             Mod = 1.2;
        }
        else if(Extent1.equals("O")) {
             Mod = 1.3;
        }
        else if(Extent1.equals("A")) {
             Mod = 1.4;
        }
        else if(Extent1.equals("H")) {
             Mod = 1.5;
        }

        //calculate BMR and Chocolate based on Gender Input
        if(Gender1=="M"){
             BMR = Mod*(66+(6.3*weight)+(12.9*height)-(6.8*age));
             Chocolate = Math.floor(BMR/230);
        }
        else{
             BMR = Mod*(655+(4.3*weight)+(4.7*height)-(4.7*age));
             Chocolate = Math.floor(BMR/230);
        }
        //output calcuations
        System.out.println("BMR adjusted for gender and lifestyle: "+String.format("%.2f",BMR));
        System.out.println("Number of chocolate bars: "+(int)Chocolate);



        /*
        //calculate
        double woman = Math.floor((655+(4.3*weight)+(4.7*height)-(4.7*age))/230);
        double man = Math.floor((66+(6.3*weight)+(12.9*height)-(6.8*age))/230);
        //print result
        System.out.println("\n\nNumber of chocolate bars for woman is "+(int)woman);
        System.out.println("Number of chocolate bars for man is "+(int)man);
        */
    }
}
