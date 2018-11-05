import java.util.Random;
import java.awt.*;

/**
 * Created by Tucker on 2/14/17.
 *
 */
public class Deck {

    private static final int DECK_SIZE = 81;
    private Card[] deck;
    private int cardToDeal;


    /**
     * constructor
     */

    // the constructor initializes the array and then each
    // card in the array
    public Deck () {
        deck = new Card[DECK_SIZE];
        cardToDeal = 0;

        // We maintain arrays of the properties of each card
        // By reusing the same properties, we allow == and != to work
        Color colors[] = {new Color(153,204,255), new Color(0,204,0), new Color(255,192,203)};
        Shading shadings[] = {Filled.getInstance(), Outlined.getInstance(), Striped.getInstance()};
        Symbol symbols[] = {Oval.getInstance(), Diamond.getInstance(), Squiggle.getInstance()};
        Locations locations[] = {OneNum.getInstance(), TwoNum.getInstance(), ThreeNum.getInstance()};

        for (int i=0; i<DECK_SIZE; i++) {
            deck[i] = new Card(colors[(i/27)], shadings[(i/9)%3], locations[i%3], symbols[(i/3)%3]);
        }
    }


    /**
     * reused code from data structures Crazy Eights project
     */




    public void shuffle() {

        Random shuffleIndex = new Random();
        int newIndex;

        //the cardHolder will hold the value of the card object while swapping
        Card cardHolder;

        for (int i = 0; i < DECK_SIZE; i++) {

            //gives new index from random numbers 0-51

            newIndex = shuffleIndex.nextInt(DECK_SIZE);

            //swapping cards

            cardHolder = deck[i];
            deck[i] = deck[newIndex];
            deck[newIndex] = cardHolder;

        }


    }



    /**
     * reused code from data structures Crazy Eights project
     */


    /**
     * returns the index of card to be dealt
     * @return int
     */
    public int getCard() {

        return cardToDeal;
    }

    /**deals a card
     *
     * @return card object
     */
    public Card deal() {
        if (cardToDeal < DECK_SIZE) {

            Card currentCard = deck[cardToDeal];
            cardToDeal++;
            return currentCard;


        } else {


            return null;

        }


    }


    public int getSize(){

        return DECK_SIZE;
    }

    public boolean isEmpty(){
        return cardToDeal==72; //specific to set game
    }

    public void restart(){
        cardToDeal = 0;
    }



}
