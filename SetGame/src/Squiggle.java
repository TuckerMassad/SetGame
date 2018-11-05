import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.awt.*;

/**
 * Created by Tucker on 2/13/17.
 * 
 *
 */
public class Squiggle extends Symbol {

    // the singleton design pattern to enable comparisons
    private Squiggle() { }

    private static class SquiggleHolder{
        private static final Symbol INSTANCE = new Squiggle();

    }

    public static Symbol getInstance() {return SquiggleHolder.INSTANCE;}


    // The draw method draws a squiggle
    public void draw  (Graphics g, int location, Color color, Color backGround, Shading shading) {

        // Draw the squiggle
        Polygon p = new Polygon();
        p.addPoint (40, location+30);
        p.addPoint (65, location);
        p.addPoint (85, location+20);
        p.addPoint (110,location+10);
        p.addPoint (85, location+40);
        p.addPoint (65, location+20);

        // Fill the squiggle
        Graphics2D graph = (Graphics2D) g;
        graph.setColor(color);
        graph.setStroke(new BasicStroke(5.0f));
        graph.drawPolygon (p);
        graph.setPaint(shading.getPaint(color, backGround));
        graph.fillPolygon(p);
    }
}
