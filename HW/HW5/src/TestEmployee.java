import java.util.Scanner;

public class TestEmployee {
    public static void main(String[] args) {
        //Create scanner
        Scanner sc = new Scanner(System.in);
        //Gather input data for employee 1
        System.out.println("Employee 1");
        System.out.print("Enter employee name: ");
        String e1n = sc.nextLine();
        System.out.print("Enter employee id: ");
        String e1i = sc.nextLine();
        System.out.print("Enter employee salary: ");
        double e1s = sc.nextDouble();
        System.out.print("Enter date (year ) of hire: ");
        int e1y = sc.nextInt();

        //Extra sc.nextLine() is required to deal with line skipping bug
        //Without this, the following nextLine() is skipped
        sc.nextLine();

        //Create instance of employee 1
        Employee e1 = new Employee(e1n, e1y, e1s, e1i);

        //Display data for employee 1
        e1.writeOutput();


        //Get new data for employee 1 name and salary
        System.out.print("Enter new name for employee #1: ");
        String e1nn = sc.nextLine();
        System.out.print("Enter new salary for employee #1: ");
        double e1ns = sc.nextDouble();

        //Extra sc.nextLine() is required to deal with line skipping bug
        //Without this, the following nextLine() is skipped
        sc.nextLine();

        //Use e1's built in mutator methods to reset values for name and salary
        e1.setName(e1nn);
        e1.setSalary(e1ns);

        //Display data for employee 1 again
        e1.writeOutput();

        //Gather input data for employee 2
        System.out.println("Employee 2");
        System.out.print("Enter employee name: ");
        String e2n = sc.nextLine();
        System.out.print("Enter employee id: ");
        String e2i = sc.nextLine();
        System.out.print("Enter employee salary: ");
        double e2s = sc.nextDouble();
        System.out.print("Enter date (year ) of hire: ");
        int e2y = sc.nextInt();

        //Create instance of employee 2
        Employee e2 = new Employee(e2n, e2y, e2s, e2i);

        //Display data for employee 2
        e2.writeOutput();
        e1.writeOutput();

        boolean sameEmployee = e1.equals(e2);
        if (sameEmployee){
            System.out.println("They are the same employee");
        }
        else{
            System.out.println("They are not the same employee");
        }
    }
}