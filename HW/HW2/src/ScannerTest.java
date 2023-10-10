import java.util.Scanner;
public class ScannerTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter gender (M or F): ");
        char gender = sc.next().charAt(0);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.println("Your name is "+name+" and your gender is "+gender+" and you are "+age+" years old.");

    }
}
