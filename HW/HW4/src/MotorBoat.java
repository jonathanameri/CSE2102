import java.math.BigDecimal;
import java.util.Scanner;

public class MotorBoat {

    private double capacity;
    private double fuelAmount;
    private double maxSpeed;
    private double currentSpeed;
    private double efficiency;
    private double distanceTraveled;
    private Scanner sc = new Scanner(System.in);


    public MotorBoat(){
        capacity=0;
        fuelAmount=0;
        maxSpeed=0;
        currentSpeed=0;
        efficiency=0;
        distanceTraveled=0;
    }

    public MotorBoat(double cap, double amt, double mS, double cS,double eff, double distT ){
        //Check each input
        //Create scanner for user to re-enter values

        //Check capacity of tank
        while(cap <= 0 || cap > 250){
            System.out.print("Tank capacity must be between 0-250\nRe-enter the capacity of the fuel tank: ");
            cap = sc.nextDouble();
        }

        //Check fuel amount
        while(amt <= 0 || amt > cap) {
            System.out.print("Fuel must be positive and less than the capacity\nRe-enter the amount of fuel in the tank: ");
            amt = sc.nextDouble();
        }

        //Check maximum speed
        while(mS <= 0 || mS > 50){
            System.out.print("Max speed must be positive and less than or equal to 50\nRe-enter the maximum speed: ");
            mS = sc.nextDouble();
        }

        //Check current speed **************
        while(cS <= 0 || cS > mS) {
            System.out.print("Speed must be positive and less than max speed\nRe-enter the current speed: ");
            cS = sc.nextDouble();
        }

        //Check efficiency
        while (eff <= 0 || eff > 100) {
            System.out.print("Efficiency must be between 0-100\nRe-enter the efficiency (percentage): ");
            eff = sc.nextDouble();
        }

        //Check distance traveled input
        while(distT <= 0) {
            System.out.print("Distance traveled must be positive\nRe-enter the total distance traveled so far: ");
            double totalDistance = sc.nextDouble();
        }

        sc.nextLine();


        capacity=cap;
        fuelAmount=amt;
        maxSpeed=mS;
        currentSpeed=cS;
        efficiency=eff;
        distanceTraveled=distT;
    }

    public void setCurrentSpeed(double cS){
        while(cS<= 0 || cS > maxSpeed) {
            System.out.print("Speed must be positive and less than max speed\nRe-enter the current speed: ");
            cS = sc.nextDouble();
        }
        currentSpeed=cS;
    }

    public void setFuelAmount(double additionalFuel){
        fuelAmount+=additionalFuel;
    }

    public double getFuelAmount (){
        return fuelAmount;
    }

    public double getDistanceTraveled(){
        return distanceTraveled;
    }

    public void operateBoat(double amountOfTime){
        double fuelBurn = (Math.pow(currentSpeed,2)* efficiency *amountOfTime)/100;
        if (fuelBurn<fuelAmount){
            System.out.print("\nOperating the motorboat\n");
            fuelAmount-=fuelBurn;
            //BigDecimal x = new BigDecimal(fuelAmount);
            //BigDecimal y = new BigDecimal(fuelBurn);
            //x = x.subtract(y);
            //fuelAmount=x;
            distanceTraveled+=currentSpeed*amountOfTime;
        }
        else{
            System.out.print("\nNot enough fuel, cannot operate the motorboat\n");
        }
    }

}
