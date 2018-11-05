import java.awt.*;

/**
 * Created by Tucker on 2/13/17.
 * @see Shading
 *
 */
public class Outlined extends Shading{


    private Outlined(){ }

    private static class OutlinedHolder{
        private static final Shading INSTANCE = new Outlined();

    }

    public static Shading getInstance() {return OutlinedHolder.INSTANCE;}

    public Paint getPaint (Color color, Color backGround) {return backGround;}
}
