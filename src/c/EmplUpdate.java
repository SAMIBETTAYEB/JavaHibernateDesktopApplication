package c;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private Label idLabel;

    DeptOperations deptO=new DeptOperations();
    EmplOperations emplO=new EmplOperations();

    private m.Empl previous_empl=Empl.employeeToUpdate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        id.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                char ar[] = event.getCharacter().toCharArray();
//                char ch = ar[event.getCharacter().toCharArray().length - 1];
//                if (!(ch >= '0' && ch <= '9')) {
//                    System.out.println("The char you entered is not a number");
//                    event.consume();
//                }
//            }
//        });

        if(Empl.addOrEdit.equalsIgnoreCase("ADD")){
            idLabel.setVisible(false);
            id.setVisible(false);
        }else if(Empl.addOrEdit.equalsIgnoreCase("EDIT")){
            idLabel.setVisible(true);
            id.setVisible(true);
        id.setEditable(false);
        id.setText(Empl.employeeToUpdate.getId()+"");
        fname.setText(Empl.employeeToUpdate.getFname());
        lname.setText(Empl.employeeToUpdate.getLname());
        dept.setValue(Empl.employeeToUpdate.getDept());
            }
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
        if(Empl.addOrEdit.equalsIgnoreCase("EDIT")){

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
        }else if(Empl.addOrEdit.equalsIgnoreCase("ADD")){
            m.Empl empl=new m.Empl(fname.getText().toString(),lname.getText().toString(),(Dept)dept.getSelectionModel().getSelectedItem());
            emplO.add(empl);
            ObservableList data = FXCollections.observableArrayList();
            data.addAll(emplO.getAll());
            Empl.emplTv.setItems(data);
            Empl.primaryStage.close();
        }

    }

    public void emplUpdateResetClick(){
        id.setText(previous_empl.getId()+"");
        fname.setText(previous_empl.getFname());
        lname.setText(previous_empl.getLname());
        dept.setValue(previous_empl.getDept());
    }

    public void emplUpdateCancelClick(){
        Empl.primaryStage.close();
    }


}
