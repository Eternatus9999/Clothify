package controller.maincontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private static MainController instance;
    public static Stage stage = new Stage();
    private MainController(){}
    public static MainController getInstance(){
        return instance==null?instance=new MainController():instance;
    }
    public void NavigatetoUserInterface(){
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../view/user_form.fxml"))));
            stage.setFullScreen(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
