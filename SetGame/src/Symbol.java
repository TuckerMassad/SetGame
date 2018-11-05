import java.awt.*;

/**
 * Created by Tucker on 2/13/17.
 *
 */
abstract class Symbol {

    public static Symbol getInstance() {
        return null;
    }

    abstract public void draw(Graphics g, int location, Color color, Color background, Shading shading);

}