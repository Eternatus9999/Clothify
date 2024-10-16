package controller.admincontroller;

public class AdminController {
    private static AdminController instance;
    private AdminController(){}
    public static AdminController getInstance(){
        return instance==null?instance = new AdminController():instance;
    }
}
