
import java.util.Random;
import java.util.Scanner;

public class Deck {
    private Card[] deck;
    private String hint;
    private  int NumberOfCards = 52;
    private  final Random Generator = new Random();
    private Card[] cardsRemoved;
    private int removedCardIndex;
    PlayerMoves pm = new PlayerMoves(100);

    public Deck() {
        String rank[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen"};
        String suit[] = {"Hearts", "Spades", "Clubs", "Diamonds"};
        deck = new Card[NumberOfCards];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(rank[i % 13], suit[i / 13]);
        }
        cardsRemoved = new Card[NumberOfCards];
        removedCardIndex = 0;
    }




    public void PlayingCard() {
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

        boolean play = true;
        while (play) {
            boolean validMoveExists = false;
            for (int i = 0; i < cards.length; i++) {
                for (int j = 1; j < cards.length; j++) {
                    if (!(cards[i] == null) && !(cards[j] == null)) {
                        if ((cards[i].getRankvalue() + cards[j].getRankvalue()) == 13) {
                            validMoveExists = true;
                            break;
                        }
                        if (cards[i].getRankvalue() == 13) {
                            validMoveExists = true;
                            break;
                        } else {
                            validMoveExists = false;
                        }
                    }
                }if (validMoveExists) {
                    break;
                }
            }
            if (!validMoveExists) {
                System.out.println("No valid moves left.");
                play = false;
                break;
            }
            Scanner myObj = new Scanner(System.in);
            if (validMoveExists) {
                System.out.println("Your cards are:");
                for (int i = 0; i < 10; i++) {
                    System.out.println("Card " + (i + 1) + " is " + cards[i]);
                }
                System.out.println("Do you want hints?");
                hint = myObj.nextLine();
                myObj.nextLine();
                if (hint.equals ("Yes")){
                    boolean hintFound = false;
                    for (int i = 0; i < cards.length; i++) {
                        for (int j = 1; j < cards.length; j++) {
                            if ((!(cards[i]==null))&& (!(cards[j]==null) )){
                                if ((cards[i].getRankvalue() + cards[j].getRankvalue()) == 13) {
                                    System.out.println("Card " + (i + 1) + " and Card " + (j + 1) + " makes the sum of 13");
                                    hintFound = true;
                                    break;
                                }
                                if ((!hintFound) && ((cards[i].getRankvalue()) == 13)) {
                                    System.out.println("Card " + (i + 1) + "has value 13.");
                                    hintFound = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (!hintFound) {
                        System.out.println("No hints available.");
                    }
                }


                System.out.println("You want to remove 1 card or 2 cards to make total value equivalent to 13");
                int noofcards = myObj.nextInt();
                myObj.nextLine();
                if (noofcards == 1) {
                    System.out.println(" Please choose the position of card");
                    int position = myObj.nextInt();
                    if (position > 0 && position < 11) {
                        if (!(cards[position - 1] == null)) {
                            if (cards[position - 1].getRankvalue() == 13) {
                                System.out.println(cards[position - 1] + " is removed");
                                pm.addMove("You pressed " + position + " which removed " + cards[position-1]);
                                cardsRemoved[removedCardIndex] = cards[position - 1];
                                if (deck.length > 0) {
                                    Random random = new Random();
                                    int randomIndex = random.nextInt(deck.length);
                                    Card RC = deck[randomIndex];
                                    cards[position - 1] = RC;
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
                                    cards[position - 1] = null;
                                }
                                removedCardIndex++;
                            } else {
                                pm.addMove("You pressed " + position + " which was not equivalent to thirteen " );
                                System.out.println("It is not equivalent to thirteen.");
                            }
                        } else {
                            pm.addMove("You pressed " + position + " and in this position there was no card. " );
                            System.out.println("There is no card in this position");
                        }
                    } else {
                        pm.addMove("You pressed " + position + " which was not a valid input " );
                        System.out.println("Please enter the valid input");
                    }
                } else {
                    if (noofcards == 2) {
                        System.out.println(" Please choose the position of first card");
                        int position1 = myObj.nextInt();
                        System.out.println(" Please choose the position of second card");
                        int position2 = myObj.nextInt();
                        if ((position1 > 0 && position1 < 11) && (position2 > 0 && position2 < 11)) {
                            if (!(cards[position1 - 1] == null) && !(cards[position2 - 1] == null)) {
                                if ((cards[position1 - 1].getRankvalue() + cards[position2 - 1].getRankvalue()) == 13) {
                                    System.out.println(cards[position1 - 1] + " is removed");
                                    System.out.println(cards[position2 - 1] + " is removed");
                                    pm.addMove("You pressed " + position1 + " and " + position2 + " which removed " + cards[position1-1] + " and " + cards[position2 -1]);
                                    cardsRemoved[removedCardIndex] = cards[position1 - 1];
                                    cardsRemoved[removedCardIndex + 1] = cards[position2 - 1];
                                    if (deck.length > 0) {
                                        Random random = new Random();
                                        int randomIndex = random.nextInt(deck.length);
                                        Card RC = deck[randomIndex];
                                        cards[position1 - 1] = RC;
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
                                        if (deck.length>0) {
                                            randomIndex = random.nextInt(deck.length);
                                            RC = deck[randomIndex];
                                            cards[position2 - 1] = RC;
                                            newDeck = new Card[deck.length - 1];
                                            j = 0;
                                            for (int k = 0; k < deck.length; k++) {
                                                if (k == randomIndex) {
                                                    continue;
                                                }
                                                newDeck[j] = deck[k];
                                                j++;
                                            }
                                            deck = newDeck;
                                        }
                                    } else {
                                        cards[position1 - 1] = null;
                                        cards[position2 - 1] = null;
                                    }
                                    removedCardIndex = removedCardIndex + 2;
                                } else {
                                    pm.addMove("You pressed " + position1 + " and " + position2 + " which didn't make sum of thirteen.");
                                    System.out.println("It is not equivalent to thirteen.");
                                }
                            } else {
                                pm.addMove("You pressed " + position1 + " and " + position2 + ". There was no card in one or both of those positions. ");
                                System.out.println("There is no card in this position.");
                            }
                        } else {
                            pm.addMove("You pressed " + position1 + " and " + position2 + ". The input was invalid.");
                            System.out.println("Please put valid input.");
                        }
                    } else {

                        System.out.println("You can remove either 1 or 2 cards");
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
            System.out.println("You have won.");
        }
        if (victory == false){
            System.out.println("********SORRY********");
            System.out.println("You have lost.");
        }

        pm.printMoves();


    }
}









