public class Staff extends Employee {
    private int payGrade; //create variable within scope of all methods in the class
    public Staff() {
    }
    public Staff(String inputName, int inputYearHired, double inputSalary, String inputID, int initialPayGrade) {
        //since staff extends employee, we send all the common parameters into the super() method
        super(inputName, inputYearHired, inputSalary, inputID);
        //the one parameter that is added in Staff is initialized separately, without the super method
        payGrade = initialPayGrade;
    }
    public void setPayGrade(int newPayGrade) {
        //sets payGrade to new, user-chosen payGrade, mutator method
        payGrade = newPayGrade;
    }
    public int getPayGrade() {
        //returns payGrade, accessor method
        return payGrade;
    }
    public void writeOutput() {
        //formats the output of the Staff to be printed neatly
        System.out.println("Name: " + getName());
        System.out.println("Year Hired: " + getYearHired());
        System.out.println("Salary: " + getSalary());
        System.out.println("ID: " + getID());
        System.out.println("Pay Grade: " + getPayGrade());
    }
    public boolean equals(Staff otherStaff) {
        //compares all the different attributes of one staff ("this") and otherStaff
        boolean hasName = this.hasSameName(otherStaff);
        boolean hasYear = this.getYearHired() == otherStaff.getYearHired();
        boolean hasPayGrade = this.getPayGrade() == otherStaff.getPayGrade();
        boolean hasID = this.getID().equals(otherStaff.getID());
        boolean hasSalary = this.getSalary() == otherStaff.getSalary();
        //if ALL the attributes are equal, then it will return true. otherwise, it'll return false
        return (hasName && hasYear && hasPayGrade && hasID && hasSalary);
    }
}
