public class Undergraduate extends Student {
    //creates enum of grade levels
    public enum level {
        FRESHMAN, SOPHOMORE, JUNIOR, SENIOR
    }
    //initializes class variable
    private level studentLevel;
    public Undergraduate() {
        //empty constructor
    }
    public Undergraduate(String initialName, int initialStudentNumber, level initialStudentLevel) {
        //filled constructor class, attributes that are in Student are included in super()
        super(initialName, initialStudentNumber);
        //the rest are initialized here
        studentLevel = initialStudentLevel;
    }
    //accessor method
    public level getStudentLevel() {
        return studentLevel;
    }
    //mutator method
    public void setStudentLevel(level newStudentLevel) {
        studentLevel = newStudentLevel;
    }
    //formatting output of the class
    public void writeOutput() {
        System.out.println("Name: " + getName());
        System.out.println("Student Number: " + getStudentNumber());
        System.out.println("Student Level: " + getStudentLevel());
    }
    public boolean equals(Undergraduate otherStudent) {
        //checks if each attribute is equivalent between (this) and the otherStudent
        boolean hasName = this.hasSameName(otherStudent);
        boolean hasNum = this.getStudentNumber() == otherStudent.getStudentNumber();
        boolean hasLevel = this.getStudentLevel() == otherStudent.getStudentLevel();
        //if all three are true, then the two Undergraduate objects are equivalent
        return (hasName && hasNum && hasLevel);
    }
}
