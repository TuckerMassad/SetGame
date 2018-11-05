import java.awt.*;

/**
 * Created by Tucker on 2/13/17.
 *
 */
public class Diamond extends Symbol {

    private Diamond(){ }

    private static class DiamondHolder{
        private static final Symbol INSTANCE = new Diamond();

    }

    public static Symbol getInstance() {return DiamondHolder.INSTANCE;}



    // the draw method draws a diamond
    public void draw  (Graphics g, int location, Color color, Color backGround, Shading shading) {

        // Draw the diamond
        Polygon p = new Polygon();
        p.addPoint (75, location);
        p.addPoint (110, location+20);
        p.addPoint (75, location+40);
        p.addPoint (40, location+20);

        // Fill the diamond
        Graphics2D graph = (Graphics2D) g;
        graph.setColor(color);
        graph.setStroke(new BasicStroke(5.0f));
        graph.drawPolygon (p);
        graph.setPaint(shading.getPaint(color, backGround));
        graph.fillPolygon(p);
    }
}
