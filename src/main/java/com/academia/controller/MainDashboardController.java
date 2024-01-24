package com.academia.controller;

import com.academia.JavaFxApplication;
import com.academia.model.Students;
import com.academia.service.StudentsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class MainDashboardController implements Initializable {

    private StudentsService studentsService;
    private ObservableList<Students> studentsDataDisplayList;


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
        ObservableList<Students> listStudents = FXCollections.observableArrayList();

        studentsService = JavaFxApplication.getContext().getBean(StudentsService.class);
        List<Students> allStudents = studentsService.getAllStudents();
        listStudents.addAll(allStudents);
        this.studentsDataDisplayList = listStudents;

        addDataToStudentsTableView();
    }

    private void addDataToStudentsTableView() {
        stuId.setCellValueFactory(new PropertyValueFactory<>("id"));
        stuName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        stuClass.setCellValueFactory(new PropertyValueFactory<>("studentClass"));
        stuDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        studentDetails_tableView.setItems(studentsDataDisplayList);
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void minimize(ActionEvent event) {

    }
}
