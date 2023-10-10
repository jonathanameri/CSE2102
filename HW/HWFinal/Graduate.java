public class Graduate extends Student {
    //creating enum of programs
    public enum program {
        MASTERS, DOCTORAL
    }
    //initializing class variables
    private program studentProgram;
    public Graduate() {
        //empty constructor
    }
    public Graduate(String initialName, int initialStudentNumber, program initialStudentProgram) {
        //put attributes that are shared with Student in super() so we have access to Student class funtionalities
        //then initialize studentProgram separately
        super(initialName, initialStudentNumber);
        studentProgram = initialStudentProgram;
    }
    //accessor method
    public program getStudentProgram() {
        return studentProgram;
    }
    //mutator method
    public void setStudentProgram(program newStudentProgram) {
        studentProgram = newStudentProgram;
    }
    //formats the output of all the attributes
    public void writeOutput() {
        System.out.println("Name: " + getName());
        System.out.println("Student Number: " + getStudentNumber());
        System.out.println("Student Program: " + getStudentProgram());
    }
    public boolean equals(Graduate otherStudent) {
        //checks if each attribute is equivalent between (this) and the otherStudent
        boolean hasName = this.hasSameName(otherStudent);
        boolean hasNum = this.getStudentNumber() == otherStudent.getStudentNumber();
        boolean hasProgram = this.getStudentProgram() == otherStudent.getStudentProgram();
        //if all three are true, then the two Undergraduate objects are equivalent
        return (hasName && hasNum && hasProgram);
    }
}
