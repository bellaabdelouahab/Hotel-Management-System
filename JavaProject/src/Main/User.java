package Main;

public class User {
    private int Id;
    private String Name;
    private String Last;
    private String Adresse;
    private int Salary;
    private int Commission;

    public User(int id, String Name, String Last, String Adresse, int Salary, int Commission) {
        this.Id = id;
        this.Name = Name;
        this.Last = Last;
        this.Adresse = Adresse;
        this.Salary = Salary;
        this.Commission = Commission;
    }
}

