import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseReport {
    private static final Course course = new Course(); //creating the course class instance to be used in this report class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:"); //getting file name
        String reportFile = scanner.nextLine();
        readInfo(reportFile); //calling the info to fill the course instance with the info from the file
        //condition is always true, loop continues until manually broken
        while(true) {
            printOptions(); //to reduce clutter, separate method that prints the menu options is called
            int num = Integer.parseInt(scanner.nextLine()); //getting user input
            //the following three are pretty simple, call the accessor method that pertains to the specified option
            if (num == 1) {
                System.out.println("Name of the course: " + course.getCourseName());
            }
            else if (num == 2) {
                System.out.println("Number of the course: " + course.getCourseNumber());
            }
            else if (num == 3) {
                System.out.println("Number of employees: " + course.getNumEmployees());
            }
            else if (num == 4) {
                System.out.println("The following are the instructors for this course: ");
                //retrieving facultyList stored in the course class
                ArrayList<Faculty> facultyList = course.getFacultyList();
                //for each faculty in the list, call the writeOutput method
                for (Faculty f : facultyList) {
                    f.writeOutput();
                }
            }
            else if (num == 5) {
                System.out.println("The following are the teaching instructors for this course: ");
                //this is the same as the facultyList, just with methods that correspond to the TAs
                ArrayList<Staff> taList = course.getTaList();
                for (Staff ta : taList) {
                    ta.writeOutput();
                }
            }
            //again, next couple are just calling specified accessor methods
            else if (num == 6) {
                System.out.println("Number of instructors: " + course.getNumInstructors());
            }
            else if (num == 7) {
                System.out.println("Number of teaching assistants: " + course.getNumTAs());
            }
            else if (num == 8) {
                System.out.println("Number of students: " + course.getNumStudents());
            }
            else if (num == 9) {
                System.out.println("Number of graduate students: " + course.getNumGradStudents());
            }
            else if (num == 10) {
                System.out.println("Number of undergraduate students: " + course.getNumUndergradStudents());
            }
            else if (num == 11) {
                System.out.println("Number of freshmen: " + course.getNumFreshman());
                System.out.println("Number of sophomores: " + course.getNumSophomores());
                System.out.println("Number of juniors: " + course.getNumJuniors());
                System.out.println("Number of seniors: " + course.getNumSeniors());
            }
            else if (num == 12) {
                System.out.println("Number of masters students: " + course.getNumMasters());
                System.out.println("Number of doctoral students: " + course.getNumDoctoral());
            }
            else if (num == 13) {
                System.out.println("Would you like to find the student based on the name or number? Enter name for name or number for number.");
                String resp = scanner.nextLine();
                //getting user response on whether they want to search based on name or num
                if (resp.equals("name")) {
                    System.out.println("What is the name of the student you'd like to find?");
                    String studName = scanner.nextLine(); //retrieves the name of the student to search for
                    for (Undergraduate undergrad : course.getUndergradList()) {
                        //iterate through the entire undergrad list and if the name matches write the output
                        //if it doesn't find an undergrad with that name, it will just move onto the grad students
                        if (studName.equals(undergrad.getName())) {
                            undergrad.writeOutput();
                        }
                    }
                    //iterate through the grad list as well, and if the name matches write the output
                    //if there is a student with the desired name in both undergrad and grad, it will print the output of both
                    for (Graduate grad : course.getGradList()) {
                        if (studName.equals(grad.getName())) {
                            grad.writeOutput();
                        }
                    }
                }
                else if (resp.equals("number")) {
                    System.out.println("What is the number of the student you'd like to find?");
                    int studNum = Integer.parseInt(scanner.nextLine()); //retrieve student number
                    //same method as the name option, iterate through both the grad and undergrad lists and write the output
                    //if there's a match
                    for (Undergraduate undergrad : course.getUndergradList()) {
                        if (studNum == undergrad.getStudentNumber()) {
                            undergrad.writeOutput();
                        }
                    }
                    for (Graduate grad : course.getGradList()) {
                        if (studNum == grad.getStudentNumber()) {
                            grad.writeOutput();
                        }
                    }
                }

            }
            else {
                //this just makes exiting easier, if anything is typed other than 'e' it continues to run the while loop
                System.out.println("Do you wish to exit, or see the options again? Type e for exit or anything else to see the options again.");
                String ans = scanner.next();
                if (ans.equals("e")) {
                    break; //break the loop and exit the program
                }
            }
        }
    }

    public static void readInfo(String f) {
        String removeTitle; //creating this string to be used later
        try {
            File courseRecords = new File(f); //creates new file with the file name we're using for this assignment
            Scanner recordScanner = new Scanner(courseRecords); //creates a new scanner with the file as the input
            while (recordScanner.hasNextLine()) { //while not EOF
                String line = recordScanner.nextLine(); //read each line
                //all of the lines in the file we're given are labeled as Number: Name: etc so these if / else if statements are checking what we should do
                //with each line
                if (line.contains("Number")) {
                    //this split separates "Number: " with the actual information we want to draw from it
                    course.setCourseNumber(line.split(": ")[1]);
                }
                //do the same thing with each different option
                else if (line.contains("Name")) {
                    course.setCourseName(line.split(": ")[1]);
                }
                else if (line.contains("Instructor")) {
                    //this removeTitle string removes the title with the actual information we want
                    removeTitle = line.split(": ")[1];
                    String[] facultyInfo = removeTitle.split("; "); //splits up the info into a list so we can create a faculty class instance from it
                    //creating the faculty class instance
                    Faculty tempFaculty = new Faculty(facultyInfo[0], Integer.parseInt(facultyInfo[3].strip()), Double.parseDouble(facultyInfo[2].strip().replace(",", "")), facultyInfo[1], facultyInfo[4]);
                    ArrayList<Faculty> facultyList = course.getFacultyList(); //getting the faculty list from the course
                    //if the faculty isnt in the list yet, add it. otherwise just move on
                    boolean contains = false;
                    //the .contains method doesn't quite work in this instance, so to fix that we iterated through the arraylist
                    //and individually checked. we made a custom equals method for each class, so it correctly checks if every class attribute
                    //is equal and therefore the class instances themselves are equal.
                    for (Faculty fac : facultyList) {
                        if (fac.equals(tempFaculty)) {
                            contains = true;
                        }
                    }
                    if (facultyList.size() == 0) {
                        //if the list is empty, add the first faculty member
                        course.addFaculty(tempFaculty);
                    }
                    //if we didn't find a match earlier, add the faculty member to the list
                    else if (!contains){
                        course.addFaculty(tempFaculty);
                    }
                }
                //the same procedure for the faculty instances are repeated for staff/Tas, undergrads, and grads so I'm not going to comment them all
                else if (line.contains("Staff")) {
                    removeTitle = line.split(": ")[1];
                    String[] staffInfo = removeTitle.split("; ");
                    Staff tempStaff = new Staff(staffInfo[0], Integer.parseInt(staffInfo[3].strip()), Double.parseDouble(staffInfo[2].strip().replace(",","")), staffInfo[1], Integer.parseInt(staffInfo[4].strip()));
                    ArrayList<Staff> taList = course.getTaList();
                    boolean contains = false;
                    for (Staff ta : taList) {
                        if (ta.equals(tempStaff)) {
                            contains = true;
                        }
                    }
                    if (taList.isEmpty()) {
                        course.addTA(tempStaff);
                    }
                    else if (!contains){
                        course.addTA(tempStaff);
                    }
                }
                //again, it's the same as the faculty method just with different method names and stuff to correspond with each class
                else if (line.contains("Undergraduate")) {
                    removeTitle = line.split(": ")[1];
                    String[] undergradInfo = removeTitle.split("; ");
                    Undergraduate tempUndergrad = new Undergraduate(undergradInfo[0], Integer.parseInt(undergradInfo[1].strip()), Undergraduate.level.valueOf(undergradInfo[2].strip()));
                    ArrayList<Undergraduate> undergradList = course.getUndergradList();
                    boolean contains = false;
                    for (Undergraduate ug : undergradList) {
                        if (ug.equals(tempUndergrad)) {
                            contains = true;
                        }
                    }
                    if (undergradList.isEmpty()) {
                        course.addUndergradStudent(tempUndergrad);
                    }
                    else if (!contains){
                        course.addUndergradStudent(tempUndergrad);
                    }
                }
                //the procedure here is ALSO the same as the faculty one
                else if (line.contains("Graduate")) {
                    removeTitle = line.split(": ")[1];
                    String[] gradInfo = removeTitle.split("; ");
                    Graduate tempGrad = new Graduate(gradInfo[0], Integer.parseInt(gradInfo[1].strip()), Graduate.program.valueOf(gradInfo[2]));
                    ArrayList<Graduate> gradList = course.getGradList();
                    boolean contains = false;
                    for (Graduate gs : gradList) {
                        if (gs.equals(tempGrad)) {
                            contains = true;
                        }
                    }
                    if (gradList.isEmpty()) {
                        course.addGradStudent(tempGrad);
                    }
                    else if (!contains){
                        course.addGradStudent(tempGrad);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found"); //if file isn't found / reachable, return this error
            e.printStackTrace();
        }
    }
    //creating this separate method, so it doesn't clutter our main method
    public static void printOptions() {
        //just prints all the menu options for the user to read every time it's called within the main method
        System.out.println("What would you like to know?");
        System.out.println("1. Name of the course.");
        System.out.println("2. Number of the course.");
        System.out.println("3. How many employees?");
        System.out.println("4. Who are the instructors?");
        System.out.println("5. Who are the teaching assistants?");
        System.out.println("6. How many instructors are teaching?");
        System.out.println("7. How many teaching assistants?");
        System.out.println("8. How many students?");
        System.out.println("9. How many graduate students?");
        System.out.println("10. How many undergraduate students?");
        System.out.println("11. How many freshman/sophomore/juniors/seniors?");
        System.out.println("12. How many masters/doctoral students?");
        System.out.println("13. Find a specific student, either based on the student's name or student number.");
        System.out.println("Enter any other integer greater than 13 to be given the option to exit");
    }
}



