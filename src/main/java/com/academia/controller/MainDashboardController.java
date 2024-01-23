package com.academia.controller;

import com.academia.JavaFxApplication;
import com.academia.model.Students;
import com.academia.service.StudentsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class MainDashboardController implements Initializable {

    private StudentsService studentsService;

    @FXML
    private Button addStu_btn;

    @FXML
    private AnchorPane centerPane;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane leftPane;

    @FXML
    public TableView<Students> studentDetails_tableView;

    @FXML
    private TableColumn<Students, String> stuClass;

    @FXML
    private TableColumn<Students, String> stuDOB;

    @FXML
    private TableColumn<Students, Integer> stuId;

    @FXML
    private TableColumn<Students, String> stuName;

    @FXML
    private AnchorPane topHorizontalPane;

    @FXML
    private Button main_close;

    @FXML
    private Button main_minimize;

    @FXML
    void addStudent(ActionEvent event) {

    }

    @FXML
    void dashboard(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void minimize(ActionEvent event) {

    }
}
