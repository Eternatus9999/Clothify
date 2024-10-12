package controller.maincontroller;

import controller.EmployeeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {

    String forgotemail;

    @FXML
    private TextField adress;

    @FXML
    private TextField checkpassword;

    @FXML
    private TextField contact;

    @FXML
    private TextField email;

    @FXML
    private TextField emaillog;

    @FXML
    private AnchorPane forgotpasswordform;

    @FXML
    private AnchorPane loginform;

    @FXML
    private AnchorPane mainform;

    @FXML
    private TextField name;

    @FXML
    private TextField newpassword;

    @FXML
    private TextField newpasswordcheck;

    @FXML
    private TextField password;

    @FXML
    private TextField passwordlog;

    @FXML
    private AnchorPane registerform;

    @FXML
    void BackOnAction(ActionEvent event) {
        mainform.setVisible(true);
        forgotpasswordform.setVisible(false);
        loginform.setVisible(false);
        registerform.setVisible(false);
    }

    @FXML
    void DoneOnAction(ActionEvent event) {
        mainform.setVisible(false);
        forgotpasswordform.setVisible(false);
        loginform.setVisible(true);
    }

    @FXML
    void LoginOnAction(ActionEvent event) {
        MainController.getInstance().CheckUser(passwordlog.getText(),emaillog.getText());
    }

    @FXML
    void NavForgotPassword(ActionEvent event) {
        forgotemail = emaillog.getText();
        mainform.setVisible(false);
        forgotpasswordform.setVisible(true);
    }

    @FXML
    void NavLoginOnAction(ActionEvent event) {
        mainform.setVisible(false);
        forgotpasswordform.setVisible(false);
        loginform.setVisible(true);
    }

    @FXML
    void NavRegisterOnAction(ActionEvent event) {
        mainform.setVisible(false);
        registerform.setVisible(true);
    }

    @FXML
    void RegisterOnAction(ActionEvent event) {
        EmployeeController.getInstance().addEmployee(name.getText(),email.getText(),adress.getText(),password.getText(),checkpassword.getText(),contact.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainform.setVisible(true);
    }
}
