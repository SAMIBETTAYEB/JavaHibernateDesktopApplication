import m.Dept;
import m.DeptOperations;
import m.Empl;
import m.EmplOperations;

/**
 * Created by Bettayeb on 5/4/2017.
 */
public class Main {

    public static void main(String[] args){
        DeptOperations deptOperations=new DeptOperations();
        Dept dept1,dept2,dept3,dept4;
        deptOperations.add(dept1=new Dept("Dept1"));
        deptOperations.add(dept2=new Dept("Dept2"));
        deptOperations.add(dept3=new Dept("Dept3"));
        deptOperations.add(dept4=new Dept("Dept4"));

        EmplOperations emplOperations=new EmplOperations();
        emplOperations.add(new Empl("Fname1","Lname1",dept1));
        emplOperations.add(new Empl("Fname1","Lname1",dept2));
        emplOperations.add(new Empl("Fname1","Lname1",dept3));
        emplOperations.add(new Empl("Fname1","Lname1",dept4));


        emplOperations.add(new Empl("Fname2","Lname2",dept1));
        emplOperations.add(new Empl("Fname2","Lname2",dept2));
        emplOperations.add(new Empl("Fname2","Lname2",dept3));
        emplOperations.add(new Empl("Fname2","Lname2",dept4));


        emplOperations.add(new Empl("Fname3","Lname3",dept1));
        emplOperations.add(new Empl("Fname3","Lname3",dept2));
        emplOperations.add(new Empl("Fname3","Lname3",dept3));
        emplOperations.add(new Empl("Fname3","Lname3",dept4));


        emplOperations.add(new Empl("Fname4","Lname4",dept1));
        emplOperations.add(new Empl("Fname4","Lname4",dept2));
        emplOperations.add(new Empl("Fname4","Lname4",dept3));
        emplOperations.add(new Empl("Fname4","Lname4",dept4));

    }

}
