/**
 * Created by Daria on 2/18/17.
 *
 */
import java.util.*;
public class SetFinder {


    Set test;// not sure about this
    Card[] input;// input from table
    ArrayList<Card[]> validSets;

    int l;

    /**
     *
     * @param dealtCards
     * @param size
     */
    public SetFinder(Card[] dealtCards, int size){
        test = new Set();
        input = dealtCards;
        l = size;
        validSets = new ArrayList<Card[]>();
    }

    /**
     * Gets the ArrayList of valid sets
     * @return ArrayList of valid sets
     */
    public ArrayList<Card[]> getSets (){
        return validSets;
    }

    /**
     * Gets the size of currently dealt cards
     * @return size of currently dealt cards
     */
    public Integer getSize (){
        return l;
    }

    /**
     *
     * @param
     */
   public void findSets(){
       for (int i=0; i<l-2; i++) {
           Card cd = input[i];
           test.add(cd);
           for (int j=i+1; j<l-1; j++) {
               Card cd2 = input[j];
               test.add(cd2);
               for (int k=j+1; k<l; k++) {
                   Card cd3 = input[k];
                   test.add(cd3);
                   if (test.isValidSet()) {
                       Card[] valid = {cd, cd2, cd3};
                       validSets.add(valid);// add to sets
                   }
                   test.remove();
               }
               test.remove();
           }
           test.remove();
       }
   }


}




