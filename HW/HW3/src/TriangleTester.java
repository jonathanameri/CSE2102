import java.util.Scanner;


public class TriangleTester {
    public static void main(String[] args) {
        //get user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first length: ");
        int side1 = sc.nextInt();
        System.out.print("Enter the second length: ");
        int side2 = sc.nextInt();
        System.out.print("Enter the third length: ");
        int side3 = sc.nextInt();

        //check conditions and print
        if((side1+side2>side3) && (side1+side3>side2) && (side2+side3>side1)){
            System.out.print("These lengths can form a triangle");
            if(Math.pow(side1,2)+Math.pow(side2,2)==Math.pow(side3,2)){
                System.out.println("\nIt is a right triangle");
            }
            else if(Math.pow(side1,2)+Math.pow(side2,2)<Math.pow(side3,2)){
                System.out.println("\nIt is a obtuse triangle");
            }
            else{
                System.out.println("\nIt is a acute triangle");
            }
        }
        else{
            System.out.println("These lengths cannot form a triangle");
        }
    }
}
