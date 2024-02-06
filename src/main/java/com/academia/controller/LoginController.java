package com.academia.controller;

import com.academia.model.Users;
import com.academia.service.UsersService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.academia.util.PopupUtil.showLoginErrorPopup;
import static com.academia.util.PopupUtil.showAllFieldsNeededErrorPopup;


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
            loginBtn.getScene().getWindow().hide();
            loadDashboard();
        } else {
            showLoginErrorPopup();
        }
    }

    private void loadDashboard() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/main-dashboard.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        root.setOnMousePressed((MouseEvent event) ->{
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) ->{
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();
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
            showAllFieldsNeededErrorPopup();
            return;
        }

        usersService.saveUser(user);
    }
}
