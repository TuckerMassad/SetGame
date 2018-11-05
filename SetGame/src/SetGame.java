import javafx.scene.control.Tab;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.imageio.*;

/**
 * Created by Tucker on 2/12/17.
 *
 */
public class SetGame extends JApplet {

    private static final long serialVersionUID = 1L;

    private final int APPLET_WIDTH_WELCOME = 500, APPLET_HEIGHT_WELCOME  = 500;
    private final int APPLET_WIDTH = 800, APPLET_HEIGHT = 750;
    private final int DELTA = 160;
    //private JComponent c;
    private Deck deck;
    private Table table;
    private Mode mode;
    Card[] dealt;
    Container cp;
    JPanel cardPanel;
    JPanel buttonPanel;
    JPanel welcome;
    SetFinder finder;
    Set test = new Set();
    int clickCounter;
    JButton tutorialButton;
    JButton solitaireButton;
    private Point pt[] = {
            new Point(10, 10), new Point(10, 220), new Point(10, 430),
            new Point(170, 10), new Point(170, 220), new Point(170, 430),
            new Point(330, 10), new Point(330, 220), new Point(330, 430),
            new Point(490, 10), new Point(490, 220), new Point(490, 430),
            new Point(650, 10), new Point(650, 220), new Point(650, 430),};


    public void init() {
        dealt = new Card[15];
        table = new Table();
        //for game
        JButton quitButton = new JButton("Quit");
        JButton hintButton = new JButton("Show sets");
        hintButton.addActionListener(new ShowSetsButtonListener());

        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(229, 255, 204));

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(hintButton);

        buttonPanel.add(quitButton);
        quitButton.addActionListener(new QuitButtonListener());


        //card display
        cardPanel = new JPanel();
        //c.add(label);


        cardPanel.setLayout(null);
        cardPanel.setBackground(Color.white);
        deck = new Deck();
        deck.shuffle();


        //end card display*/

        //Buttons and Cards will appear in the container
        cp = getContentPane();

        //initializing buttons for modes and adding buttonListeners
        solitaireButton = new JButton("Solitaire");
        solitaireButton.addActionListener(new SolitaireButtonListener());
        tutorialButton = new JButton("Tutorial");
        tutorialButton.addActionListener(new TutorialButtonListener());

        //initializing and displaying welcome message
        JLabel label = new JLabel("Welcome to the Game of Set! Choose game mode:");
        JLabel icon = new JLabel();
        try {
            Image img = ImageIO.read(getClass().getResource("resources/poker.png"));
            icon.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        //initializing panel with the picture
        JPanel pic = new JPanel();
        pic.setBackground(Color.white);
        pic.setLayout(new FlowLayout());
        pic.add(icon);


        //initializing panel with welcome message label
        JPanel greet = new JPanel();
        greet.setBackground((Color.white));
        greet.setLayout(new FlowLayout());
        greet.add(label);





        //initializing panel with mode buttons
        JPanel modePanel = new JPanel();
        modePanel.setBackground(Color.white);
        modePanel.setLayout(new FlowLayout());
        modePanel.add(tutorialButton);
        modePanel.add(solitaireButton);

        //adding elements to the welcome panel
        welcome = new JPanel();
        welcome.setBackground((Color.white));
        welcome.setLayout((new GridLayout(3, 1)));
        welcome.add(greet);
        welcome.add(modePanel);
        welcome.add(pic);

        //cp.add(cardPanel, BorderLayout.CENTER);


        //buttons init




       // cp.add(buttonPanel, BorderLayout.LINE_START);



        cp.setBackground(Color.white);
        //adding welcome panel to the container
        cp.add(welcome, BorderLayout.CENTER);

        setSize(APPLET_WIDTH_WELCOME , APPLET_HEIGHT_WELCOME );


    }


    private class CardButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
                Card c = (Card) event.getSource();
                c.choose();
                repaint();
        }
    }

    private class TutorialButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //mode = new Tutorial(table, deck);
            setSize(APPLET_WIDTH , APPLET_HEIGHT);
            cp.remove(welcome);
            cp.add(cardPanel, BorderLayout.CENTER);
            cp.add(buttonPanel, BorderLayout.LINE_START);
            cardPanel.remove(tutorialButton);
            cardPanel.revalidate();
            cardPanel.repaint();
            deck.restart();//singleton
            for (int i = 0; i < 12; i++) { //method?
                Card card = deck.deal();
                card.setLocation(pt[i]);
                dealt[i] = card;
                cardPanel.add(card);//method end
                //card.addActionListener(new CardButtonListener());


            }

            finder = new SetFinder(dealt, 12);
            finder.findSets();
            clickCounter=0;
        }


    }

    private class SolitaireButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //mode = new Tutorial(table, deck);
            setSize(APPLET_WIDTH , APPLET_HEIGHT);
            cp.remove(welcome);
            cp.add(cardPanel, BorderLayout.CENTER);
            cp.add(buttonPanel, BorderLayout.LINE_START);
            cardPanel.remove(solitaireButton);
            cardPanel.revalidate();
            cardPanel.repaint();
            deck.restart();//singleton
            for (int i = 0; i < 12; i++) { //method?
                Card card = deck.deal();
                card.setLocation(pt[i]);
                dealt[i] = card;
                cardPanel.add(card);//method end
                //card.addActionListener(new CardButtonListener());


            }

            finder = new SetFinder(dealt, 12);
            finder.findSets();
            clickCounter=0;
        }


    }

    private class ShowSetsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (!deck.isEmpty()) {
                finder = new SetFinder(dealt, 12);
                finder.findSets();
                ArrayList<Card[]> validSets = finder.getSets();
                int stop = validSets.size();
                System.out.println(stop + "size");//debug
                System.out.println(clickCounter + "click counter");

                if (clickCounter > 0) {//unhighlight previously highlighted cards
                    for (int a = 0; a < 3; a++) {
                        finder.getSets().get(clickCounter - 1)[a].choose();
                    }
                }

                if (clickCounter == stop) {

                    for (int x = 0; x < 12; x++) {
                        cardPanel.remove(dealt[x]);
                        cardPanel.revalidate();
                        cardPanel.repaint();
                        dealt[x] = null;
                        Card card = deck.deal();
                        card.setLocation(pt[x]);
                        dealt[x] = card;
                        cardPanel.add(card);

                    }
                    clickCounter = -1;
                } else if (!finder.getSets().isEmpty()) {
                    for (int a = 0; a < 3; a++) {
                        finder.getSets().get(clickCounter)[a].choose();
                    }

                }

                clickCounter++;
            }else {
                for (int x = 0; x < 12; x++) {
                    cardPanel.remove(dealt[x]);
                    cardPanel.revalidate();

                    dealt[x]= null;
                }

                cardPanel.add(tutorialButton);
                cardPanel.repaint();
            }}}


            /*int stop = finder.getSets().size();
            System.out.println(stop + "size");
            if(clickCounter>0) {
                for (int a = 0; a < 3; a++) {
                    finder.getSets().get(clickCounter-1)[a].choose();
                }
            }

            if (clickCounter == stop){

                for (int x = 0; x < 12; x++) {
                    cardPanel.remove(dealt[x]);
                    cardPanel.revalidate();
                    cardPanel.repaint();
                    dealt[x]= null;

                }
                for (int x = 0; x < 12; x++) {
                    Card card = deck.deal();
                    card.setLocation(pt[x]);
                    dealt[x] = card;
                    cardPanel.add(card);
                    //card.addActionListener(new CardButtonListener());


                }
                finder = new SetFinder(dealt, 12);
                finder.findSets();
                clickCounter = 0;
            }
            if(clickCounter!=stop && !finder.getSets().isEmpty()) {
                for (int a = 0; a < 3; a++) {
                    finder.getSets().get(clickCounter)[a].choose();
                }
            }


            clickCounter++;
            System.out.println(clickCounter);
            }else {
                for (int x = 0; x < 12; x++) {
                    cardPanel.remove(dealt[x]);
                    cardPanel.revalidate();

                    dealt[x]= null;
                }

                cardPanel.add(tutorialButton);
                cardPanel.repaint();
            }*/
       // }
   // }

    private class QuitButtonListener implements ActionListener { //used to debug
        public void actionPerformed(ActionEvent event) {
            for (int x = 0; x < 12; x++) {
                cardPanel.remove(dealt[x]);
                cardPanel.revalidate();

                dealt[x]= null;
            }
            cardPanel.repaint();


        }
    }






}
