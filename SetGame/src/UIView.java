/*
import javax.swing.*;
import java.awt.*;

*/
/**
 *
 * Created by Daria on 2/18/17.
 *//*



public class UIView{
    */
/**
     * Maybe should create UIVIew class and update it depending on mode to implement better MVC
     * @param c
     *//*

    Deck deck;

    private Point pt[] = {
            new Point(10, 10),  new Point(10, 220),  new Point(10, 430),
            new Point(170, 10), new Point(170, 220), new Point(170, 430),
            new Point(330, 10), new Point(330, 220), new Point(330, 430),
            new Point(490, 10), new Point(490, 220), new Point(490, 430),
            new Point(650, 10), new Point(650, 220), new Point(650, 430),
            new Point(810, 10), new Point(810, 220), new Point(810, 430),
            new Point(970, 10), new Point(970, 220), new Point(970, 430),
    };
    public UIView(JComponent c) {




        c.setLayout(new BorderLayout());
        c.setBackground(Color.white);

        JButton hintButton = new JButton("Show Sets");
        JButton quitButton = new JButton("Quit");
        JButton solitaireButton = new JButton("Solitaire Mode");
        JButton tutorialButton = new JButton("Tutorial Mode");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.blue);

        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        buttonPanel.add(hintButton);

        //buttonPanel.add(solitaireButton);
        buttonPanel.add(tutorialButton);
        buttonPanel.add(quitButton);

        deck = new Deck();
        deck.shuffle();

        for (int i=0; i<12; i++) {
            Card card = deck.deal();
            c.add(card);
            card.setLocation(pt[i]);

        }

        c.add(buttonPanel, BorderLayout.WEST);
    }
}
*/
