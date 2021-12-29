package Main;

public class SignUp {
    
    private int id;
    private String First_Name;
    private String Last_Name;
    private String Adresse;
    private String Email;
    private String Natio;
    private String Number;
    private String WorkType;

    public SignUp(int id ,String First_Name , String Last_Name , String Adresse , String Email , String Natio , String Number , String WorkType){

        this.id = id;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.Adresse = Adresse;
        this.Email = Email ;
        this.Natio = Natio;
        this.Number = Number;
        this.WorkType = WorkType;

    }

    public int getId(){
        return id;
    }

    public String getFirst_Name(){
        return First_Name;
    }

    public String getLast_Name(){
        return Last_Name;
    }

    public String getAdresse(){
        return Adresse;
    }

    public String getEmail(){
        return Email;
    }

    public String getNatio(){
        return Natio;
    }

    public String getNumber(){
        return Number;
    }

    public String getWorkType(){
        return WorkType;
    }
}
