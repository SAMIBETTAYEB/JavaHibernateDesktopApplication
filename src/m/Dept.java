package m;

import java.util.Set;

/**
 * Created by Bettayeb on 5/4/2017.
 */
public class Dept {

    private int id;
    private String label;
    Set<Empl> empl;

    public Dept(){}

    public Dept(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<Empl> getEmpl() {
        return empl;
    }

    public void setEmpl(Set<Empl> empl) {
        this.empl = empl;
    }

    @Override
    public String toString() {
        return id+" - "+label;
    }
}
