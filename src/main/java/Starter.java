import controller.modelcontroller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage = MainController.stage;
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/main_form.fxml"))));
        stage.setResizable(false);
        stage.setX(0);
        stage.setY(0);
        stage.show();
    }
}
