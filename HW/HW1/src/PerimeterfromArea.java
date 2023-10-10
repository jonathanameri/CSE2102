//Problem A
public class PerimeterFromArea {
    public static void main(String[] args){
        double inputNum = Double.parseDouble(args[0]);

        double sideLength = Math.sqrt(inputNum);
        double perimeter = 4*sideLength;
        System.out.println("The perimeter is: " + String.format("%.2f", perimeter));
    }
}
