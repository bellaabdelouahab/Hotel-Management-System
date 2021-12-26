package Main;

public class Amount {

    private String Date;
    private int Amount;

    public Amount(String Date , int Amount){
        this.Date = Date;
        this.Amount = Amount;
    }
    
    public String getDate(){
        return Date;
    }
    public int getAmount(){
        return Amount;
    }

}
