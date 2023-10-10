public class Interest {
    public static void main(String[] args){
        double principal;
        double rate;
        double interest;
        double amount;
        double years;

        principal = 17000;
        rate = 0.07;
        years = 2;

        amount = principal * Math.pow((1+rate), years);
        interest = amount - principal;

        System.out.println("The interest earned is");
        System.out.println("$" + interest);
        System.out.println("The total amount is ");
        System.out.println("$" + amount);
    }
}
