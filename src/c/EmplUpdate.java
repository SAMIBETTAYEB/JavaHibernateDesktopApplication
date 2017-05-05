package c;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import m.Dept;
import m.DeptOperations;
import m.EmplOperations;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Bettayeb on 5/5/2017.
 */
public class EmplUpdate implements Initializable{

    @FXML
    private TextField id;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private ComboBox dept;

    DeptOperations deptO=new DeptOperations();
    EmplOperations emplO=new EmplOperations();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setEditable(false);
        id.setText(Empl.employeeToUpdate.getId()+"");
        fname.setText(Empl.employeeToUpdate.getFname());
        lname.setText(Empl.employeeToUpdate.getLname());
        dept.setValue(Empl.employeeToUpdate.getDept());
        ObservableList data = FXCollections.observableArrayList();

        data.addAll(deptO.getAll());
//        for(Object o:deptO.getAll()){
//            Dept d=(Dept) o;
//            data.add(d.getLabel());
//            System.out.println(d.getLabel());
//        }
        dept.setItems(data);
    }



    public void emplUpdateOkClick(){
//        m.Empl empl=new m.Empl(fname.getText(),lname.getText(),(Dept) dept.getSelectionModel().getSelectedItem());
//        empl.setId(Integer.parseInt(id.getText()));
        Empl.employeeToUpdate.setFname(fname.getText());
        Empl.employeeToUpdate.setLname(lname.getText());
        Empl.employeeToUpdate.setDept((Dept)(dept.getSelectionModel().getSelectedItem()));
        //System.out.println(empl.getId()+" - "+empl.getFname()+" - "+empl.getLname()+" - "+empl.getId_dept());
        emplO.update(Empl.employeeToUpdate);
        ObservableList data = FXCollections.observableArrayList();
        data.addAll(emplO.getAll());
        Empl.emplTv.setItems(data);
        Empl.primaryStage.close();

    }



}