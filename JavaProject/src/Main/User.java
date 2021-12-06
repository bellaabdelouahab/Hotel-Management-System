package Main;

public class User {
    private int Id;
    private String Name;
    private String Last_name;
    private String Adresse;
    private int Salary;
    private int Commission;

    public User(int id , String Name , String Last_name , String Adresse , int Salary , int Commission){
        this.Id = id;
        this.Name = Name;
        this.Last_name = Last_name;
        this.Adresse = Adresse;
        this.Salary = Salary;
        this.Commission = Commission;
    }
    
    public int getId(){
        return Id;
    }
    public String getName(){
        return Name;
    }
    public String getLastName(){
        return Last_name;
    }
    public String getAdresse(){
        return Adresse;
    }
    public int getSalary(){
        return Salary;
    }
    public int getCommission(){
        return Commission;
    }
}
