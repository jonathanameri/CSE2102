public class Person {
    private String name;

    public Person(){
        name = "";
    }

    public Person(String inputName){
        name = inputName;
    }

    public String getName(){
        return name;
    }

    public void setName(String inputName){
        name = inputName;
    }
}
