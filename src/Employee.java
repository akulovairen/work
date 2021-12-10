public class Employee {
    public String name;
    public String position;
    public int experience;
    public String email;


    public Employee(String name, String position, int experience, String email) {
        this.name = name;
        this.position = position;
        this.experience = experience;
        this.email = email;
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

