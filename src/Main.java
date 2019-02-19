import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CardFlip c = new CardFlip(10);

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            try {
                c.runGame(sc.nextInt());
            }catch (InputMismatchException e){
                System.out.println("WRONG INPUT!!!");
                sc.next();
            }
        }
    }
}
