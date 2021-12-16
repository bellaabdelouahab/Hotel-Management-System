package Main;

public class User {
    private int Id;
    private String FullName;
    private String Adresse;
    private String Email;
    private int Salary;
    private int Commission;
    private String Work_Type;

    public User(int id, String Full_Name, String Adresse , String Email, int Salary, int Commission , String Work_Type) {
        this.Id = id;
        this.FullName = Full_Name;
        this.Adresse = Adresse;
        this.Email = Email;
        this.Salary = Salary;
        this.Commission = Commission;
        this.Work_Type = Work_Type;
    }
    
    public int getId(){
        return Id;
    }
    public String getFullName(){
        return FullName;
    }
    public String getAdresse(){
        return Adresse;
    }
    public String getEmail(){
        return Email;
    }
    public int getSalary(){
        return Salary;
    }
    public int getCommission(){
        return Commission;
    }
    public String getWorkType(){
        return Work_Type;
    }
}

