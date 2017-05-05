package c;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import m.Dept;
import m.EmplOperations;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Bettayeb on 5/4/2017.
 */
public class Empl implements Initializable {

    @FXML
    public static TableView emplTv;

    public static m.Empl employeeToUpdate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



//        new Thread(()->{


        System.out.println(getClass().getResource("../v/EmplStyle.css").toExternalForm());
        emplTv.getParent().getStylesheets().add(getClass().getResource("../v/EmplStyle.css").toExternalForm());
        emplTv.setVisible(true);
        Label l=new Label("Loading...");
        l.setFont(new Font("Arial",35.0));
        emplTv.setPlaceholder(l);
        TableColumn cId=new TableColumn("ID");
        TableColumn cFname=new TableColumn("First Name");
        TableColumn cLname=new TableColumn("Last Name");
        TableColumn cIdDept=new TableColumn("Departement");

        emplTv.getColumns().add(cId);
        emplTv.getColumns().add(cFname);
        emplTv.getColumns().add(cLname);
        emplTv.getColumns().add(cIdDept);

        emplTv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(emplTv.getSelectionModel().getSelectedIndex());

                System.out.println(((m.Empl)emplTv.getSelectionModel().getSelectedItem()).getFname());
            }
        });



        ObservableList<m.Empl> data = FXCollections.observableArrayList();
        EmplOperations emplOperations=new EmplOperations();

        data.addAll(emplOperations.getAll());

        for (m.Empl e:emplOperations.getAll()) {
            System.out.println(e.getId());
        }

        cId.setCellValueFactory(new PropertyValueFactory<m.Empl,Integer>("id"));
        cFname.setCellValueFactory(new PropertyValueFactory<m.Empl,String>("fname"));
        cLname.setCellValueFactory(new PropertyValueFactory<m.Empl,String>("lname"));
//        cIdDept.setCellValueFactory(new PropertyValueFactory<m.Empl, Dept>("dept"));

        emplTv.setItems(data);

            TableColumn cIdDeptId=new TableColumn("ID");
            TableColumn cIdDeptLabel=new TableColumn("Label");
            cIdDept.getColumns().addAll(cIdDeptId,cIdDeptLabel);
            cIdDeptId.setCellValueFactory(new PropertyValueFactory<m.Empl, Dept>("id_dept"));
            cIdDeptLabel.setCellValueFactory(new PropertyValueFactory<m.Empl, Dept>("label_dept"));
//        }).start();



    }

    public static Stage primaryStage=new Stage();
    public void btnUpdateEmplClick() throws Exception{
        m.Empl employee = (m.Empl) emplTv.getSelectionModel().getSelectedItem();
        System.out.println("You want to update the employee: ");
        System.out.println("{\n"+employee.getId());
        System.out.println(employee.getFname());
        System.out.println(employee.getLname());
        System.out.println(employee.getDept().getId());
        System.out.println(employee.getDept().getLabel()+"}");
        this.employeeToUpdate=employee;


        Parent root = FXMLLoader.load(getClass().getResource("../v/empl_update.fxml"));
        primaryStage.setTitle("Update the selected employee - Departements Management System");
        //primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();




    }



}
