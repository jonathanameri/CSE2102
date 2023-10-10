public class Employee extends Person{
    private int yearHired;
    private double salary;
    private String id;
    public Employee() {

    }

    public Employee(String inputName, int inputYearHired, double inputSalary, String inputID){
        super(inputName);
        yearHired = inputYearHired;
        salary = inputSalary;
        id = inputID;
    }
    //Accessor methods
    public int getYearHired(){
        return yearHired;
    }
    public double getSalary(){
        return salary;
    }
    public String getID(){
        return id;
    }

    //Mutator methods
    public void setYearHired(int newYearHired){
        yearHired = newYearHired;
    }
    public void setSalary(double newSalary){
        salary = newSalary;
    }
    public void setID(String newID){
        id = newID;
    }

    public void writeOutput(){
        //Print all attributes, use '\n' for formatting
        System.out.println("\nName = " + getName());
        System.out.println("ID = " + getID());
        System.out.println("Salary = " + getSalary());
        System.out.println("Year of hire = " + getYearHired() + "\n");
    }
    public boolean equals(Employee otherEmployee){
        //Compare each attribute of both employees
        //For ID and name, str.equals must be used because '==' does not work with strings
        boolean idEquals = getID().equals(otherEmployee.getID());
        boolean nameEquals = getName().equals(otherEmployee.getName());
        //For other values, '==' works
        boolean yearHiredEquals = (getYearHired() == otherEmployee.getYearHired());
        boolean salaryEquals = (getSalary() == otherEmployee.getSalary());
        //Return true only if all attributes are equal
        return (idEquals && nameEquals && yearHiredEquals && salaryEquals);
    }

}

