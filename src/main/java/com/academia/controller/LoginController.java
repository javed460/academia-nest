package com.academia.controller;

import com.academia.model.Users;
import com.academia.service.UsersService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


@Controller
@RequiredArgsConstructor
public class LoginController implements Initializable {

    private final UsersService usersService;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginBtn;

    @FXML
    public Button signUpBtn;

    @FXML
    private Button close;

    private double x = 0;
    private double y = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginAdmin(ActionEvent actionEvent) {
        Optional<Users> user = usersService.getUser(username.getText(), password.getText());
        if (user.isPresent()) {
            System.out.println("User exists");
        } else {
            showLoginErrorPopup();
        }
    }


    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void signUp(ActionEvent actionEvent) {
        SignUpController signUpController = new SignUpController();
        signUpController.showSignUpDialog();

        Users user = signUpController.getDialog().getResult();

        if (user == null) {
            return;
        }

        if (user.username().isEmpty() || user.password().isEmpty()) {
            showSignUpErrorPopup();
            return;
        }

        usersService.saveUser(user);
    }
}
