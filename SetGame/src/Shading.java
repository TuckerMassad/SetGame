import java.awt.*;
/**
 * Created by Tucker on 2/13/17.
 *
 */
abstract class Shading {

    public static Shading getInstance() {
        return null;
    }

    abstract public Paint getPaint(Color color, Color filling);
}