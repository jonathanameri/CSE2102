//Problem B
public class DispenseChange {
    public static void main(String[] args){
        int inputNum = Integer.parseInt(args[0]);
        int sum = inputNum;
        int[] coins = {25, 10, 5, 1};
        int[] results = {0, 0, 0, 0};

        for (int i = 0; i < 4; i++) {
            results[i] = inputNum / coins[i];
            inputNum = inputNum % coins[i];
        }
        System.out.println(sum + " cents in coins can be given as:");
        System.out.println(results[0] + " quarters");
        System.out.println(results[1] + " dimes");
        System.out.println(results[2] + " nickels and");
        System.out.println(results[3] + " pennies");
    }
}
