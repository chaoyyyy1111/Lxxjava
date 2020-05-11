import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card {
public int rank;
public String suit;
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}
public class CardDemo {
    public static final String[] SUITS = {"♥","♠","♦","♣"};
    public static List<Card> buyCard() {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(j,SUITS[i]);
                deck.add(card);
            }
        }
        return deck;
    }
    public static void shuffle(List<Card> deck) {
        for (int i = deck.size()-1; i > 0  ; i--) {
            Random random = new Random();
            int index = random.nextInt(i);
            Card tmp = deck.get(i);
            deck.set(i,deck.get(index));
            deck.set(index,tmp);
        }
    }
    public static void main(String[] args) {
        List<Card> deck = buyCard();
        System.out.println(deck);
        shuffle(deck);
        System.out.println(deck);
        List<List<Card>> hands = new ArrayList<>();
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();
        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 3; j++) {
                hands.get(j).add(deck.remove(0));
            }
        }
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(hand3);
        System.out.println(hands);
    }

}
