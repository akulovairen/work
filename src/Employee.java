public class Employee {
    public String name;
    public String position;
    public int experience;
    public String email;


    public Employee(String s, String s1, int parseInt, String s2) {
        this.name=s;
        this.position=s1;
        this.experience=parseInt;
        this.email=s2;
    }

    public String getName(){
        return name;
    }
    public String getPosition(){
        return position;
    }
    public int getExperience(){
        return experience;
    }
    public String getEmail(){
        return email;
    }
}

