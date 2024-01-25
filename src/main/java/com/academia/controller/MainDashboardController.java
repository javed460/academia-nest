package com.academia.controller;

import com.academia.JavaFxApplication;
import com.academia.model.Student;
import com.academia.service.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class MainDashboardController implements Initializable {

    private StudentService studentsService;
    private ObservableList<Student> studentsDataDisplayList;

    @FXML
    private Button addStu_btn;

    @FXML
    private AnchorPane centerPane;

    @FXML
    private Button dashboard_btn;

    @FXML
    public TableView<Student> studentDetails_tableView;

    @FXML
    private TableColumn<Student, String> stuClass;

    @FXML
    private TableColumn<Student, String> stuDOB;

    @FXML
    private TableColumn<Student, Integer> stuId;

    @FXML
    private TableColumn<Student, String> stuName;

    @FXML
    private AnchorPane topHorizontalPane;

    @FXML
    private Button main_close;

    @FXML
    private Button main_minimize;

    @FXML
    private TextField addStuClass_field;

    @FXML
    private TextField addStuDob_field;

    @FXML
    private TextField addStuname_field;

    @FXML
    private AnchorPane addStudentPane;

    @FXML
    void addStudent(ActionEvent event) {
        centerPane.setVisible(false);
        addStudentPane.setVisible(true);
    }

    @FXML
    void dashboard(ActionEvent event) {
        centerPane.setVisible(true);
        addStudentPane.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        centerPane.setVisible(true);
        addStudentPane.setVisible(false);

        ObservableList<Student> listStudents = FXCollections.observableArrayList();

        studentsService = JavaFxApplication.getContext().getBean(StudentService.class);
        List<Student> allStudents = studentsService.getAllStudents();
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

    public void saveStuButton(ActionEvent actionEvent) {
        Student student = new Student();
        student.setStudentName(addStuname_field.getText());
        student.setStudentClass(addStuClass_field.getText());
        student.setDob(addStuDob_field.getText());

        studentsService.saveOrUpdateStudent(student);
        clearAddStudentFormFields();
        studentsDataDisplayList.add(student);
    }

    private void clearAddStudentFormFields() {
        addStuname_field.setText("");
        addStuClass_field.setText("");
        addStuDob_field.setText("");
    }
}
