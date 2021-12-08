package Controllers.EmployerContollers.EmployerForms;

import java.time.LocalDate;
public class EmployerSearchFormController {
    public static LocalDate checkindate;
    public static LocalDate checkoutdate;
    public static double rating;
    public static double maxprice;
    public static double minprice;
    public static int AdultsCounter;
    public static int CheldrenCounter;
    public static int RoomsCounter;
    public void showData(){
        System.out.println("\n"+checkoutdate+"\n"+rating+"\n"+minprice+"\n"+maxprice+"\n"+AdultsCounter+"\n"+CheldrenCounter+"\n"+RoomsCounter);
    }
}
