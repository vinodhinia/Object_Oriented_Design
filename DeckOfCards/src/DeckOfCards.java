import java.util.*;

public class DeckOfCards {
	Card[] cards;
	public static final int NUM_OF_CARDS = 52;
	Suit[] suites;
	Value[] values;
	int currentCount;
	
	DeckOfCards(){
		cards = new Card[NUM_OF_CARDS];
		suites = Suit.values();
		values = Value.values();
		currentCount = 0;
		
		for(int s=0;s<suites.length;s++) {
			for(int v=0; v < values.length;v++) {
				cards[currentCount++] = new Card(suites[s], values[v]);
			}
		}
		currentCount = 0;
	}
	
	public void shuffle(int numOfTimes) {
		Random rand = new Random();
		for(int i=0;i<numOfTimes;i++) {
			int m = rand.nextInt(NUM_OF_CARDS-1);
			int n = rand.nextInt(NUM_OF_CARDS-1);
			
			Card temp = cards[m];
			cards[m] = cards[n];
			cards[n] = temp;
		}
	}
	
	
	public Card deal() {
		if(currentCount < NUM_OF_CARDS) {
			return cards[currentCount++];
		}else {
			System.out.println("We ran out of cards");
			return null;
		}
	}
	
	public String toString() {
		String str = "";
		int k=0;
		
		for(int s = 0;s<suites.length;s++) {
			for(int v=0;v<values.length;v++) {
				str += (cards[k++] +" ");
			}
			str += "\n";
		}
		return str;
	}
	
	/*Printing the stack of cards in format*/ 
    public void printStack(){
        int cardPointer=0;
        for(int i=0;i<suites.length;i++){

            for(int j=0;j<values.length;j++){
                System.out.print(cards[cardPointer].getSuit()+"-" + cards[cardPointer].getValue() +" ");
                cardPointer++;
            }

            System.out.println("\n");
        }

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Reference : http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/10/deck-of-cards.html
		
		DeckOfCards deck = new DeckOfCards();
		
		int n=10; 
		System.out.println("----------------------------  After shuffle -----------------------------------------------\n");
        deck.shuffle(30);
        deck.printStack();
        
        System.out.println("----------------------------  Dealing 10 cards  -----------------------------------------------\n");
        for(int i=0;i<n;i++){
            deck.deal();
        }
		 
	}

}
