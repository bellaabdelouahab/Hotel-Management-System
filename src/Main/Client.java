package Main;

public class Client {
    
    private String Cin;
    private String Firstname;
    private String Lastname;
    private String Natio;
    private String Gender;
    private String Situ;
    private int Age;

    public Client(String Cin , String FirstName , String LastName , String Natio , String Gender , String Situ , int Age){
        this.Cin = Cin;
        this.Firstname = FirstName;
        this.Lastname = LastName;
        this.Natio = Natio;
        this.Gender = Gender ;
        this.Situ = Situ;
        this.Age = Age; 
    }

    public String getCin(){
        return Cin;
    }

    public String getFirstname(){
        return Firstname;
    }

    public String getLastname(){
        return Lastname;
    }

    public String getNatio(){
        return Natio;
    }

    public String getGender(){
        return Gender;
    }

    public String getSitu(){
        return Situ;
    }

    public int getAge(){
        return Age;
    }
    
}
