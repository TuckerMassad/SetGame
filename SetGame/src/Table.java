import javax.swing.*;
import java.awt.*;

/**
 * Created by Tucker on 2/14/17.
 *
 */
public class Table {

    private Card[] dealtCards;
    private int numCards;
    // private SetFinder finder;
    // private Deck deck;

    private Point pt[] = {
            new Point(10, 10), new Point(10, 220), new Point(10, 430),
            new Point(170, 10), new Point(170, 220), new Point(170, 430),
            new Point(330, 10), new Point(330, 220), new Point(330, 430),
            new Point(490, 10), new Point(490, 220), new Point(490, 430),
            new Point(650, 10), new Point(650, 220), new Point(650, 430)};
    /**
     *
     */

    public Table() {

        dealtCards = new Card[15];
        numCards = 12;

    }

    public void display(JPanel p){
        for(int i = 0; i< numCards; i++){
            dealtCards[i].setLocation(pt[i]);
            p.add(dealtCards[i]);
        }

    }

    /**
     *
     * @param c
     */

    public void add(Card c) {
        int i = 0;
        while (i< 15 && dealtCards[i]!=null){
            i++;
        }
        dealtCards[i] = c;
        numCards++;
    }

    /**
     *
     * @param c
     */

    public void remove(Card c) {
        int i = 0;
        while (i< 15 && dealtCards[i]!=c){
            i++;
        }
        dealtCards[i] = null;
        numCards--;
    }


    public void remove(){
        for(int i =0; i<12; i++){
            dealtCards[i] = null;
        }
    }



    public int getSize(){
        return numCards;
    }

    public Card[] getTable(){
        return dealtCards;
    }




}
