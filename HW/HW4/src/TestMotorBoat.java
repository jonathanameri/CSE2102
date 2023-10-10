import java.util.Scanner;

public class TestMotorBoat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the capacity of the fuel tank: ");
        double capacity = sc.nextDouble();
        System.out.print("Enter the amount of fuel in the tank: ");
        double fuel = sc.nextDouble();
        System.out.print("Enter the maximum speed: ");
        double maxSpeed = sc.nextDouble();
        System.out.print("Enter the current speed: ");
        double currentSpeed = sc.nextDouble();
        System.out.print("Enter the efficiency (percentage): ");
        double eff = sc.nextDouble();
        System.out.print("Enter the total distance traveled so far: ");
        double totalDistance = sc.nextDouble();
        sc.nextLine();

        MotorBoat boat1 = new MotorBoat(capacity, fuel, maxSpeed, currentSpeed, eff, totalDistance);
        System.out.print("\nFuel amount: "+boat1.getFuelAmount());
        System.out.print("\nWould you like to add more fuel (y/n): ");
        String addFuel = sc.nextLine();
        if (addFuel.strip().equals("y")) {
            System.out.print("How much fuel would you like to add: ");
            double addAmount = sc.nextDouble();
            boat1.setFuelAmount(addAmount);
            System.out.print("Fuel amount: "+boat1.getFuelAmount());
            }
        System.out.print("\nHow long would you like to operate the boat (hours): ");
        double operateAmount = sc.nextDouble();
        boat1.operateBoat(operateAmount);
        System.out.print("\nRemaining fuel: ");
        System.out.printf("%.2f%n", boat1.getFuelAmount());
        System.out.print("Updated distance: "+boat1.getDistanceTraveled()+"\n");
        }
    }
