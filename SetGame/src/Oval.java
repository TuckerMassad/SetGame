import java.awt.*;

/**
 * Created by Tucker on 2/13/17.
 *
 */
public class Oval extends Symbol {
    // As before, we use the singleton design pattern to enable comparisons
    private Oval() { }


    private static class OvalHolder{
        private static final Symbol INSTANCE = new Oval();

    }

    public static Symbol getInstance() {return OvalHolder.INSTANCE;}
    // the draw method draws an oval
    public void draw (Graphics g, int location, Color color, Color backGround, Shading shading) {

        // Draw the oval
        Graphics2D graphs = (Graphics2D) g;
        graphs.setColor(color);
        graphs.setStroke(new BasicStroke(5.0f));
        graphs.drawOval(40, location, 70, 40);

        // Fill the oval
        graphs.setPaint(shading.getPaint(color, backGround));
        graphs.fillOval(40, location, 70, 40);
    }

}
