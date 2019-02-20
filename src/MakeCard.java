import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

class MakeCard {
    private int numCards;

    MakeCard(int numCards){
        this.numCards = numCards;
    }

    ArrayList<String> randomize(){
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

    void makeGrid(ArrayList<String> list){

        String[][] grid = new String[2][numCards];

        for (int i = 1; i < list.size()-1; i++) {
            grid[0][i-1] = list.get(i);
        }

        IntStream.range(1,numCards+1).forEach(num -> grid[1][num-1] = num + "");

        for (int rows = 0; rows < 2; rows++) {
            for (int col = 0; col < numCards; col++) {
                System.out.printf("%2.5s ",grid[rows][col]);
            }

            System.out.println();
        }

    }

}
