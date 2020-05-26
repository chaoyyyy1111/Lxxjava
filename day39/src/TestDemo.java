class Card  {
    public String suit;
    public int rank;
    public Card(String suit,int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || !(obj instanceof Card)) {
            return false;
        }
        if(this.suit == ((Card) obj).suit &&
                this.rank == ((Card) obj).rank ) {
            return true;
        }
        return false;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Card card1 = new Card("♥",5);
        Card card2 = new Card("♠",6);
        System.out.println(card1.equals(card2));
    }

}
