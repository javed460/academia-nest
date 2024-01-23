package com.academia.controller;

import com.academia.model.Users;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import lombok.Getter;

import static javafx.scene.control.ButtonBar.ButtonData.OK_DONE;

@Getter
public class SignUpController {
    private Dialog<Users> dialog = new Dialog<>();

    public void showSignUpDialog() {
        dialog.setTitle("Sign Up");
        dialog.setResizable(true);

        Label label1 = new Label("Username: ");
        Label label2 = new Label("Password: ");
        TextField username = new TextField();
        PasswordField  password = new PasswordField ();

        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(username, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(password, 2, 2);
        dialog.getDialogPane().setContent(grid);

        ButtonType saveButton = new ButtonType("Save", OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(saveButton);

        dialog.setResultConverter(button -> {
            if (button == saveButton) {
                return new Users(null, username.getText(), password.getText());
            }
            return null;
        });

        dialog.showAndWait();
    }
}
