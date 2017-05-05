package m;

/**
 * Created by Bettayeb on 5/4/2017.
 */
public class Empl {

    private int id;
    private String fname;
    private String lname;
    private Dept dept;
    private int id_dept;
    private String label_dept;


    public Empl(){}

    public Empl(String fname, String lname, Dept dept) {
        this.fname = fname;
        this.lname = lname;
        this.dept = dept;
        this.id_dept=dept.getId();
        this.label_dept=dept.getLabel();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
        this.id_dept=dept.getId();
        this.label_dept=dept.getLabel();
    }

    public int getId_dept() {
        return id_dept;
    }

    public void setId_dept(int id_dept) {
        this.id_dept = id_dept;
    }

    public String getLabel_dept() {
        return label_dept;
    }

    public void setLabel_dept(String label_dept) {
        this.label_dept = label_dept;
    }
}
