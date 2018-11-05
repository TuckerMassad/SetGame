/**
 *
 * @author garrettfitzgerald /2/18/17
 * Project 2 SET
 *
 * Set class. Returns True if passed a valid set.
 * Main logic of Set game.
 *
 */
public class Set {


	private Card[] cards;


	int i;

	public Set(){

		cards = new Card[3];

		i = 0;
	}
	public void add(Card c){
		cards[i] = c;
		i++;
	}

	public void remove(){
		i--;
		cards[i] = null;

	}


	/**
	 *
	 * @return
	 */
	public boolean isValidSet(){

		return isShapeSet() && isShadingSet() && isNumberSet() && isColorSet();


	}



	/**
	 * Highlights cards
	 */
	public void displaySet(){


	}

	/**
	 * If 3 cards are same shape || 3 cards different shape
	 * @return
	 */
	private boolean isShapeSet(){

		return (cards[0].getSymbol() == cards[1].getSymbol() && cards[1].getSymbol() == cards[2].getSymbol())
				||
				(cards[0].getSymbol() != cards[1].getSymbol() && cards[1].getSymbol() != cards[2].getSymbol() && cards[0].getSymbol()!=cards[2].getSymbol())
				;
	}

	/**
	 * If 3 cards are same shade || 3 cards different shade
	 * @return
	 */
	private boolean isShadingSet(){
		return (cards[0].getShading() == cards[1].getShading() && cards[1].getShading() == cards[2].getShading())
				||
				(cards[0].getShading() != cards[1].getShading() && cards[1].getShading() != cards[2].getShading() && cards[0].getShading()!=cards[2].getShading())
				;

	}

	/**
	 * If 3 cards are same number || 3 cards different number
	 * @return
	 */
	private boolean isNumberSet(){
		return (cards[0].getNumber() == cards[1].getNumber() && cards[1].getNumber() == cards[2].getNumber())
				||
				(cards[0].getNumber() != cards[1].getNumber() && cards[1].getNumber() != cards[2].getNumber() && cards[0].getNumber()!=cards[2].getNumber())
				;

	}

	/**
	 * If 3 cards are same color || 3 cards different color
	 * @return
	 */
	private boolean isColorSet(){
		return (cards[0].getColor() == cards[1].getColor() && cards[1].getColor() == cards[2].getColor())
				||
				(cards[0].getColor() != cards[1].getColor() && cards[1].getColor() != cards[2].getColor() && cards[0].getColor()!=cards[2].getColor())
				;

	}



}
