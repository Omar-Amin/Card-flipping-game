import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("How many cards do you want to play with?");
        int numCards = 0;
        while (sc.hasNext()){
            try {
                numCards = sc.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("WRONG INPUT!!!");
                sc.next();
            }
        }

        CardFlip c = new CardFlip(numCards);

        System.out.println("Type 'exit' if you want to leave this game");
        while (sc.hasNext()){
            try {
                c.runGame(sc.nextInt());
            }catch (InputMismatchException e){
                if(sc.next().equals("exit")){
                    break;
                }
                System.out.println("WRONG INPUT!!!");
            }
        }

    }
}
