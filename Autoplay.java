
import java.util.Random;
import java.util.Scanner;

public class Autoplay {
        private Card[] deck;
        private String hint;
        private  int NumberOfCards = 52;
        private  final Random Generator = new Random();
        private Card[] cardsRemoved;
        private int removedCardIndex;
        private boolean movefound = false;
        PlayerMoves pm = new PlayerMoves(100);

    public void Autodeck() {
        String rank[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen"};
        String suit[] = {"Hearts", "Spades", "Clubs", "Diamonds"};
        deck = new Card[NumberOfCards];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(rank[i % 13], suit[i / 13]);
        }
        cardsRemoved = new Card[NumberOfCards];
        removedCardIndex = 0;
    }



    public void AutoCard() {
        Autodeck();
        int PlayingCards = 10;
        Card cards[] = new Card[PlayingCards];
        for (int i = 0; i < PlayingCards; i++) {
            int randomIndex = Generator.nextInt(deck.length);
            Card RC = deck[randomIndex];
            cards[i] = RC;
            Card[] newDeck = new Card[deck.length - 1];
            int j = 0;
            for (int k = 0; k < deck.length; k++) {
                if (k == randomIndex) {
                    continue;
                }
                newDeck[j] = deck[k];
                j++;
            }
            deck = newDeck;
            NumberOfCards = NumberOfCards - 1;
        }
        Scanner myObj = new Scanner(System.in);
        boolean play = true;
        System.out.println("*************DEMO**************");

        while (play) {

            boolean validMoveExists = false;
            for (int i = 0; i < cards.length; i++) {
                if(! (cards[i]==null)) {
                    if (cards[i].getRankvalue() == 13) {
                        validMoveExists = true;
                        break;
                    }
                }
                for (int j = 1; j < cards.length; j++) {
                    if (!(cards[i] == null) && !(cards[j] == null)) {
                        if ((cards[i].getRankvalue() + cards[j].getRankvalue()) == 13) {
                            validMoveExists = true;
                            break;
                        } else {
                            validMoveExists = false;
                        }
                    }
                }
                if (validMoveExists) {
                    break;
                }
            }
            if (!validMoveExists) {
                System.out.println("No valid moves left.");
                play = false;
                break;
            }
            System.out.println("The cards are:");
            for (int i=0;i<cards.length;i++){
                System.out.println("Card " + (i+1) + " is " + cards[i]);
            }

            myObj.nextLine();
            if (validMoveExists) {

                for (int i =0; i < cards.length; i++) {
                    movefound=false;
                    if (!(cards[i] == null)) {
                        if (cards[i].getRankvalue() == 13) {
                            cardsRemoved[removedCardIndex] = cards[i];
                            System.out.println(cards[i] + " is removed.");
                            pm.addMove(cards[i] + " was removed");
                            myObj.nextLine();
                            if (deck.length > 0) {
                                Random random = new Random();
                                int randomIndex = random.nextInt(deck.length);
                                Card RC = deck[randomIndex];
                                cards[i] = RC;
                                Card[] newDeck = new Card[deck.length - 1];
                                int j = 0;
                                for (int k = 0; k < deck.length; k++) {
                                    if (k == randomIndex) {
                                        continue;
                                    }
                                    newDeck[j] = deck[k];
                                    j++;
                                }
                                deck = newDeck;
                            } else {
                                cards[i] = null;
                            }
                            removedCardIndex++;
                            System.out.println("Updated cards are:");
                            for ( i=0;i<cards.length;i++){
                                System.out.println("Card " + (i+1) + " is " + cards[i]);
                            }
                            myObj.nextLine();
                             validMoveExists=true;
                             movefound = true;

                        }
                    }
                }
                if (movefound==false){
                    for (int i =0; i < cards.length; i++) {
                        for (int j =1; j<cards.length;j++){
                            if (!(cards[i] == null)&& !(cards[j]==null)) {
                                if (cards[i].getRankvalue() + cards[j].getRankvalue() == 13) {
                                    cardsRemoved[removedCardIndex] = cards[i];
                                    cardsRemoved[removedCardIndex + 1] = cards[j];
                                    System.out.println(cards[i] + " and " + cards[j] + " is removed.");
                                    pm.addMove(cards[i] + " and " + cards[j] + " were removed.");
                                    myObj.nextLine();
                                    if (deck.length > 0) {
                                        Random random = new Random();
                                        int randomIndex = random.nextInt(deck.length);
                                        Card RC = deck[randomIndex];
                                        cards[i] = RC;
                                        Card[] newDeck = new Card[deck.length - 1];
                                        int len = 0;
                                        for (int k = 0; k < deck.length; k++) {
                                            if (k == randomIndex) {
                                                continue;
                                            }
                                            newDeck[len] = deck[k];
                                            len++;
                                        }
                                        deck = newDeck;
                                        if (deck.length > 0) {
                                            randomIndex = random.nextInt(deck.length);
                                            RC = deck[randomIndex];
                                            cards[j] = RC;
                                            newDeck = new Card[deck.length - 1];
                                            len = 0;
                                            for (int k = 0; k < deck.length; k++) {
                                                if (k == randomIndex) {
                                                    continue;
                                                }
                                                newDeck[len] = deck[k];
                                                len++;
                                            }
                                            deck = newDeck;
                                        }
                                    } else {
                                        cards[i] = null;
                                        cards[j] = null;
                                    }
                                   System.out.println("Updated cards are:");
                                    for ( i=0;i<cards.length;i++){
                                        System.out.println("Card " + (i+1) + " is " + cards[i]);
                                    }
                                    myObj.nextLine();
                                    removedCardIndex = removedCardIndex + 2;
                                    validMoveExists = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        boolean victory = true;
        for (int i = 0; i < 10; i++) {
            for (int j =1; j<10;j++){
                if ((cards[i]== null) && (cards[j]== null)){
                    victory = true;
                }else{
                    if (!(cards[i]== null) && !(cards[j]==null)) {
                        if (!((cards[i].getRankvalue()) + (cards[j].getRankvalue()) == 13)) {
                            victory = false;
                        }
                    }else{
                        if( (cards[i]==null) && !(cards[i]==null)){
                            victory=false;
                        }
                    }
                }
            }
        }
        if (victory == true){
            System.out.println("********HURRAY********");
            System.out.println("Game won.");
        }
        if (victory == false){
            System.out.println("********SORRY********");
            System.out.println("Game lost.");
        }

        pm.printMoves();

    }
}
