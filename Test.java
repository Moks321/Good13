import java.util.Scanner;
public class Test {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        boolean endGame=false;
        System.out.println("******WELCOME*****");
        System.out.println("******THE GOOD THIRTEEN*****");
        while (endGame == false) {
            System.out.println(" ");
            System.out.println("Please choose the option you want to operate:");
            System.out.println("1.See how to play game");
            System.out.println("2. Start the game");
            System.out.println("3. See the demo");
            System.out.println("4. End game.");
            int choice;
            choice = myObj.nextInt();
            if (choice ==1 ){
                System.out.println("You chose to see how to play game.");
                System.out.println(" ");
                System.out.println("10 cards will be displayed on screen. ");
                System.out.println("You can choose the position of cards to be removed in numerical values. ");
                System.out.println("You can choose the combination of two cards which makes the sum of thirteen.");
                System.out.println("                     OR");
                System.out.println("You can choose any 1 card which is equivalent to thirteen");
            }else{
                if (choice == 2) {
                    System.out.println("You chose to start the game.");
                    System.out.println(" ");
                    Deck d = new Deck();
                    d.PlayingCard();
                }else{
                    if (choice == 3) {
                        System.out.println("You chose to see demo of the game.");
                        System.out.println("You should press enter after each step.");
                        System.out.println(" ");
                        Autoplay ap = new Autoplay();
                        ap.AutoCard();
                    }else{
                        if (choice == 4) {
                            System.out.println("You chose to end the game.");
                            System.out.println(" ");
                            System.out.println("***********The game has ended**************");
                            endGame = true;
                        }else {
                            System.out.println("Please choose the valid option.");
                            System.out.println("You can enter 1, 2, 3 or 4");
                        }
                    }
                }

            }
        }
    }
}
