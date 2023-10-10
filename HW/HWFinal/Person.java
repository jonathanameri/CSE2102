public class Person {
    private String name; //initializing class variable
    public Person() {
        //empty constructor
        name = "";
    }
    public Person(String initialName) {
        name = initialName;
    } //constructor including name parameter
    public void setName(String newName) {
        name = newName;
    } //mutator method
    public String getName() {
        return name;
    } //accessor method
    public void writeOutput() {
        System.out.println("Name: " + name);
    } //formats output of attributes
    //if one person obj has the same name as the other, return true
    public boolean hasSameName(Person otherPerson) {
        return this.name.equalsIgnoreCase(otherPerson.name);
    }
}
