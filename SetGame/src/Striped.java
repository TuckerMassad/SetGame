import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Tucker on 2/13/17.
 * @see Shading
 */
public class Striped extends Shading {

    private Striped(){ }

    private static class StripedHolder{
        private static final Shading INSTANCE = new Striped();

    }

    public static Shading getInstance() {return StripedHolder.INSTANCE;}

    public Paint getPaint (Color color, Color backGround) {
        BufferedImage buffImage = new BufferedImage(
                10, 10, BufferedImage.TYPE_INT_RGB );

        Graphics2D gg = buffImage.createGraphics();
        gg.setColor( color );
        gg.fillRect( 0, 0, 10, 5 ); // draw a filled rectangle

        gg.setColor(backGround);
        gg.fillRect( 0, 5, 10, 5 ); // draw a filled rectangle

        // paint buffImage onto the JComponent
        return (new TexturePaint(
                buffImage, new Rectangle( 10, 12 ) ) );
    }
}
