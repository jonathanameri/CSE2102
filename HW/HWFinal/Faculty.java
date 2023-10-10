public class Faculty extends Employee {
    private String title; //initialize class variables
    public Faculty() {
        //empty class constructor
    }
    public Faculty(String inputName, int inputYearHired, double inputSalary, String inputID, String facultyTitle) {
        //putting attributes shared with Employee class into super() since it extends Employee
        super(inputName, inputYearHired, inputSalary, inputID);
        //initializing the rest of the attributes
        title = facultyTitle;
    }
    //mutator method
    public void setTitle(String newTitle) {
        title = newTitle;
    }
    //accessor method
    public String getTitle() {
        return title;
    }
    //formatting the output of the class
    public void writeOutput() {
        System.out.println("Name: " + getName());
        System.out.println("Year Hired: " + getYearHired());
        System.out.println("Salary: " + getSalary());
        System.out.println("ID: " + getID());
        System.out.println("Title: " + getTitle());
    }
    public boolean equals(Faculty otherFaculty) {
        //compares each attribute individually between (this) object and the otherFaculty object
        boolean hasName = this.hasSameName(otherFaculty);
        boolean hasYear = this.getYearHired() == otherFaculty.getYearHired();
        boolean hasTitle = this.getTitle().equals(otherFaculty.getTitle());
        boolean hasID = this.getID().equals(otherFaculty.getID());
        boolean hasSalary = this.getSalary() == otherFaculty.getSalary();
        //if all the attributes are equal, return true, otherwise false
        return (hasName && hasYear && hasTitle && hasID && hasSalary);
    }
}
