/**
 * Created by Tucker on 2/13/17.
 *
 */


public class TwoNum extends Locations {
    private static Locations instance = new TwoNum();


    private TwoNum() {
        super();
        add(55);
        add(105);
    }

    private static class TwoNumHolder{
        private static final Locations INSTANCE = new TwoNum();
    }

    public static Locations getInstance() {return TwoNumHolder.INSTANCE;}

}
