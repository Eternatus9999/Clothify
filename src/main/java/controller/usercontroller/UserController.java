package controller.usercontroller;

public class UserController {
    private static UserController instance;



    private UserController(){}

    public static UserController getInstance(){
        return instance==null?instance= new UserController():instance;
    }


}
