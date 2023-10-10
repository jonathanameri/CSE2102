import java.util.Scanner;
import java.lang.Math.*;

public class ChocolateBars {

    public static void main(String[] args)
    {
        //instantiate scanner object
        Scanner sc = new Scanner(System.in);
        //get user input
        System.out.print("Enter the weight in pounds: ");
        int weight = sc.nextInt();
        System.out.print("Enter the height in inches: ");
        int height = sc.nextInt();
        System.out.print("Enter the age in years: ");
        int age = sc.nextInt();
        System.out.print("Enter M for man, W for woman: ");
        char gender = sc.next().charAt(0);
        System.out.print("Enter S for sedentary, O for occasionally, A for active, H for highly active: ");
        char exercise = sc.next().charAt(0);

        double bmr;

        //calculate
        if(gender == 'M'){
            bmr=Math.floor((66+(6.3*weight)+(12.9*height)-(6.8*age))/230);
        }
        else if (gender == 'W'){
            bmr=Math.floor((655+(4.3*weight)+(4.7*height)-(4.7*age))/230);
        }
        
        //print result
        System.out.println("\n\nNumber of chocolate bars for woman is "+(int)woman);
        System.out.println("Number of chocolate bars for man is "+(int)man);

    }
}
