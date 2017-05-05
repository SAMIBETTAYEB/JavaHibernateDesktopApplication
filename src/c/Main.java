package c;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Bettayeb on 5/5/2017.
 */
public class Main {

    public void btnEmpClick() throws Exception{
        System.out.println("BtnEmplClick");
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../v/empl.fxml"));
        primaryStage.setTitle("Employees - Departements Management System");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void btnDeptClick(){
        System.out.println("btnDeptClick");
    }

}
