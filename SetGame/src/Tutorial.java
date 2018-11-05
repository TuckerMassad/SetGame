import java.util.ArrayList;

/**
 * Created by Tucker on 2/20/17.
 * Last modified by Catherine on 2/20/17
 */
public class Tutorial extends Mode {


    private SetFinder setFinder;
    private int size;
    private Card[] currentSet;
    Table t;
    Deck d;
    int i;
    /**
     *
     * @param table
     * @param deck
     */


    public Tutorial(Table table, Deck deck){
        this.t = table;
        this.d = deck;
        d.shuffle();
        size = table.getSize();
        setFinder = new SetFinder(table.getTable(),size);
        i = 0;
    }



    public void runGame(){
        //display 12 cards
        if(!setFinder.getSets().isEmpty() && i< setFinder.getSets().size()){
            currentSet = setFinder.getSets().get(i);
            for(int x = 0; x<3; x++){
                currentSet[i].choose();
            }
            i++;
        }else{
            t.remove();
            for (int i = 0; i<12; i++){
                t.add(d.deal());
            }
        }




    }
}


