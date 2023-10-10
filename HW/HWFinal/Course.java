import java.util.ArrayList;

public class Course {
    //initializing variables used by the class
    private String courseNumber;
    private String courseName;
    private ArrayList<Faculty> facultyList;
    private ArrayList<Staff> taList;
    private ArrayList<Undergraduate> undergradList;
    private ArrayList<Graduate> gradList;
    public Course() {
        //empty constructor, initializing each variable as empty
        facultyList = new ArrayList<Faculty>();
        taList = new ArrayList<Staff>();
        undergradList = new ArrayList<Undergraduate>();
        gradList = new ArrayList<Graduate>();
        courseName = "";
        courseNumber = "";

    }
    public Course(String initialCourseNumber, String initialCourseName) {
        //constructor with attributes, ArrayLists still initialized as empty
        courseNumber = initialCourseNumber;
        courseName = initialCourseName;
        facultyList = new ArrayList<Faculty>();
        taList = new ArrayList<Staff>();
        undergradList = new ArrayList<Undergraduate>();
        gradList = new ArrayList<Graduate>();
    }
    //mutator methods for name/number
    public void setCourseNumber(String newCourseNumber) {
        courseNumber = newCourseNumber;
    }
    public void setCourseName(String newCourseName) {
        courseName = newCourseName;
    }
    //accessor methods for name/number
    public String getCourseNumber() {
        return courseNumber;
    }
    public String getCourseName() {
        return courseName;
    }
    public void addFaculty(Faculty newFaculty) {
        //the conditions of which to add a new faculty must be met in order to add a faculty member
        if ((facultyList.size() < 2) && (!facultyList.contains(newFaculty))){
            facultyList.add(newFaculty);
        }
        else {
            //if the conditions are not met, print an error message
            System.out.println("Cannot add instructor, course may not have more than 2 instructors.");
        }
    }
    //same procedure as addFaculty, refer to those comments
    public void addTA(Staff newStaff) {
        if ((taList.size() < 5) && (!taList.contains(newStaff))){
            taList.add(newStaff);
        }
        else {
            System.out.println("Cannot add TA, course may not have more than 5 teaching assistants.");
        }
    }
    //next two methods add Grad/Undergrad students to their respective lists
    public void addGradStudent(Graduate newGraduate) {
        gradList.add(newGraduate);
    }
    public void addUndergradStudent(Undergraduate newUndergrad) {
        undergradList.add(newUndergrad);
    }
    //accessor methods
    public int getNumStudents() {
        return gradList.size() + undergradList.size();
    }
    public int getNumTAs() {
        return taList.size();
    }
    public int getNumInstructors() {
        return facultyList.size();
    }
    public int getNumEmployees() {
        return facultyList.size() + taList.size();
    }
    public int getNumGradStudents() {
        return gradList.size();
    }
    public int getNumUndergradStudents() {
        return undergradList.size();
    }
    public ArrayList<Faculty> getFacultyList() {
        return facultyList;
    }
    public ArrayList<Staff> getTaList() {
        return taList;
    }
    public ArrayList<Undergraduate> getUndergradList() {
        return undergradList;
    }
    public ArrayList<Graduate> getGradList() {
        return gradList;
    }
    //iterates through the number of grad students that are in the grad program
    //and then checks each studentProgram to see if its equal to the doctoral program
    public int getNumDoctoral() {
        int numDocs = 0;
        for (Graduate grad : gradList) {
            if (grad.getStudentProgram().name().equals("DOCTORAL")) {
                numDocs += 1;
            }
        }
        return numDocs;
    }
    //iterates through the number of grad students that are in the grad program
    //and then checks each studentProgram to see if its equal to the masters program
    public int getNumMasters() {
        int numMasters = 0;
        for (Graduate grad : gradList) {
            if (grad.getStudentProgram().name().equals("MASTERS")) {
                numMasters += 1;
            }
        }
        return numMasters;
    }
    //iterates through the number of undergrad students that are in the undergrad program
    //and then checks each studentLevel to see if its equal to the freshman enum value
    public int getNumFreshman() {
        int numFresh = 0;
        for (Undergraduate s : undergradList) {
            if (s.getStudentLevel().name().equals("FRESHMAN")) {
                numFresh += 1;
            }
        }
        return numFresh;
    }
    //iterates through the number of undergrad students that are in the undergrad program
    //and then checks each studentLevel to see if its equal to the sophomore enum value
    public int getNumSophomores() {
        int numSoph = 0;
        for (Undergraduate s : undergradList) {
            if (s.getStudentLevel().name().equals("SOPHOMORE")) {
                numSoph += 1;
            }
        }
        return numSoph;
    }
    //iterates through the number of undergrad students that are in the undergrad program
    //and then checks each studentLevel to see if its equal to the junior enum value
    public int getNumJuniors() {
        int numJuniors = 0;
        for (Undergraduate s : undergradList) {
            if (s.getStudentLevel().name().equals("JUNIOR")) {
                numJuniors += 1;
            }
        }
        return numJuniors;
    }
    //iterates through the number of undergrad students that are in the undergrad program
    //and then checks each studentLevel to see if its equal to the senior enum value
    public int getNumSeniors() {
        int numSeniors = 0;
        for (Undergraduate s : undergradList) {
            if (s.getStudentLevel().name().equals("SENIOR")) {
                numSeniors += 1;
            }
        }
        return numSeniors;
    }

}
