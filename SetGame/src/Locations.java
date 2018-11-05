import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Tucker on 2/13/17.
 *
 */
abstract class Locations {
    private ArrayList<Integer> l;
    public Locations() {l = new ArrayList<Integer>();}
    public static Locations getInstance() {return null;}
    public int getSize() {return l.size();}
    public int getLoc(int i) {return l.get(i);}
    protected boolean add(int i) {return l.add(i);}

}
