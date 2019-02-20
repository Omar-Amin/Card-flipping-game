import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Type 'exit' if you want to leave this game");

        Scanner sc = new Scanner(System.in);

        System.out.println("How many cards do you want to play with?");
        int numCards = 0;
        while (sc.hasNext()){
            try {
                numCards = sc.nextInt();
                break;
            }catch (InputMismatchException e){
                if(sc.next().equals("exit")){
                    System.exit(1);
                }
                System.out.println("WRONG INPUT!!!");
            }
        }

        CardFlip c = new CardFlip(numCards);

        System.out.println("The numbers on first row shows if the card is flipped or not.");
        System.out.println("Numbers on second row is the number of the card");
        while (sc.hasNext()){
            try {
                String gameStatus = c.runGame(sc.nextInt());
                if (gameStatus.equals("lost")) {
                    System.out.println("You lost!");
                    break;
                }
                if (gameStatus.equals("won")){
                    System.out.println("Congratulations you won!");
                    break;
                }
            }catch (InputMismatchException e){
                if(sc.next().equals("exit")){
                    break;
                }
                System.out.println("WRONG INPUT!!!");
            }
        }

    }
}
