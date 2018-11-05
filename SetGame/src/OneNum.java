/**
 * Created by Tucker on 2/13/17.
 * @see Locations
 */
class OneNum extends Locations {
    private static Locations instance = new OneNum();


    private OneNum() {
        super();
        add(80);
    }

    private static class OneNumHolder{
        private static final Locations INSTANCE = new OneNum();
    }

    public static Locations getInstance() {return OneNumHolder.INSTANCE;}

}
