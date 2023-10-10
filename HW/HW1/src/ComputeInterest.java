//Problem D
public class ComputeInterest {
    public static void main(String[] args){
        double principal = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        double years = Double.parseDouble(args[2]);
        double amountSimple;
        double amountCompound;
        double difference;

        rate = (rate / 100.0);
        amountSimple = principal + (principal * rate * years);
        amountCompound = principal * Math.pow((1+rate), years);
        difference = amountCompound - amountSimple;

        System.out.println("The amount with simple interest is: " + String.format("%.2f", amountSimple));
        System.out.println("The amount with compound interest is: " + String.format("%.2f", amountCompound));
        System.out.println("The difference is: " + String.format("%.2f", difference));
    }
}
