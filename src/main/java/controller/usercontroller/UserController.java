package controller.usercontroller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class UserController {
    private static UserController instance;

    private UserController(){}

    public static UserController getInstance(){
        return instance==null?instance= new UserController():instance;
    }

    public LocalDate getDate(){
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return LocalDate.parse(f.format(date));
    }

}
