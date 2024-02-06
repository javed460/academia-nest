package com.academia.util;

import javafx.scene.control.Alert;

import static javafx.scene.control.Alert.AlertType.ERROR;

public final class PopupUtil {

    public static void showLoginErrorPopup() {
        Alert alert = new Alert(ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Invalid Username/Password");
        alert.showAndWait();
    }

    public static void showAllFieldsNeededErrorPopup() {
        Alert alert = new Alert(ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Please fill all fields");
        alert.showAndWait();
    }

}
