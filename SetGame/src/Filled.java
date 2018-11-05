import java.awt.*;

/**
 * Created by Tucker on 2/13/17.
 *
 */
class Filled extends Shading {

    // We have exactly one instance of the filled class


    // The private constructor keeps outsiders from making instances
    private Filled(){ }

    // getInstance returns the only instance of this class
    private static class FilledHolder{
        private static final Shading INSTANCE = new Filled();

    }

    public static Shading getInstance() {return FilledHolder.INSTANCE;}

    // filled uses the foreground color to fill the card
    public Paint getPaint (Color color, Color backGround) {return color;}
}
