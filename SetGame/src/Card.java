import java.awt.*;
import javax.swing.*;
/**
 * Created by Tucker on 2/13/17.
 *
 */

public class Card extends JButton{

    private final static int width = 150;
    private final static int height = 200;
    private Locations number;
    private Shading shading;
    private Symbol symbol;
    private Color color;
    private Color background;
    private boolean highlighted;

    public Card (Color color, Shading shading, Locations number, Symbol symbol) {
        this.color = color;
        this.background = Color.white;
        this.shading = shading;
        this.number = number;
        this.symbol = symbol;
        highlighted = false;
        setSize(width, height);
    }


    public void paint(Graphics page){
        Graphics2D graph=(Graphics2D) page;   // the 2D graphics context

        Dimension d = getSize();

        graph.setColor(background);
        graph.fillRoundRect(1, 1, (int)d.getWidth()-2, (int)d.getHeight()-2, 20, 20);


        // We loop through this cards location drawing the symbol
        for (int i=0; i<number.getSize(); i++) {
            symbol.draw(graph, number.getLoc(i), color, background, shading);
        }
        graph.setPaint(Color.black);
        graph.setStroke(new BasicStroke(2.0f));
        graph.drawRoundRect(1, 1, (int)d.getWidth()-2, (int)d.getHeight()-2, 20, 20);



    }





    public void invalidChoose(){
        background = (new Color (255, 142, 142));
        repaint();
    }

    //highlights the card
    public void choose(){
        if(background == Color.white){
            background = (new Color (155, 253, 155));
        }else {
            background = Color.white;
        }
        repaint();
    }




    // the following methods are defined to keep layout managers and others from
    // changing the size of the card.  Note that the location can still be set
    // using either setBounds or setLocation
    public void setSize (int width, int height) {super.setSize(width, height);}
    public void setSize (Dimension d) {super.setSize(width, height);}
    public void setBounds (int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
    }
    public void setBounds (Rectangle r) {
        super.setBounds ((int)r.getX(), (int)r.getY(), width, height);
    }


    public Shading getShading(){
        return shading;
    }

    public Symbol getSymbol(){
        return symbol;
    }

    public Locations getNumber(){
        return number;
    }

    public Color getColor(){
        return color;
    }



}
