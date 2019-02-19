import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CardFlip {

    private int numCards;

    public CardFlip(int numCards){
        this.numCards = numCards;
        makeCard();
    }

    public void runGame(int respond){

        System.out.println(respond);

    }

    private List<String> makeCard(){
        ArrayList<String> listOfCards = new ArrayList<>();
        Random randomBit = new Random();

        IntStream.range(0,numCards).forEach(n -> listOfCards.add( randomBit.nextInt(2) + "" )); //makes random cards

        int count = 0;
        for (String elm: listOfCards) {
            if (elm.equals("1")){
                count++;
            }
        }

        if(count%2 == 0){   //number of 1's can't be equal
            if (count < numCards/2) {
                for (int i = 0; i < numCards; i++) {
                    if (listOfCards.get(i).equals("1")) {
                        listOfCards.set(i, "0");
                        break;
                    }
                }
                Collections.shuffle(listOfCards);
            }else {
                for (int i = 0; i < numCards; i++) {
                    if (listOfCards.get(i).equals("0")) {
                        listOfCards.set(i, "1");
                        break;
                    }
                }
                Collections.shuffle(listOfCards);
            }
        }

        listOfCards.add(0,"");
        listOfCards.add("");

        return listOfCards;
    }

}
