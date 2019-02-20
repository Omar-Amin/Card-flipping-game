import java.util.ArrayList;

class CardFlip {

    private ArrayList<String> listOfCards;
    private MakeCard makecard;

    CardFlip(int numCards){
        this.makecard = new MakeCard(numCards);
        this.listOfCards = makecard.randomize();
        makecard.makeGrid(listOfCards);

    }

    String runGame(int respond){

        if (listOfCards.get(respond).equals("1")){
            String left = listOfCards.get(respond-1);
            String right = listOfCards.get(respond+1);

            if (!left.equals("") && !left.equals("R")){ //In order to prevent crashes
                left = "" + (Integer.parseInt(left) ^ 1);
                listOfCards.set(respond-1, left);
            }
            if (!right.equals("") && !right.equals("R")){
                right = "" + (Integer.parseInt(right) ^ 1); // xor int, easy way to flip
                listOfCards.set(respond+1,"" + right);
            }
            listOfCards.set(respond,"R");
            makecard.makeGrid(listOfCards);
            return checkGame();
        }else {
            System.out.println("You can only pick cards that are 1");
            return "";
        }

    }

    private String checkGame(){

        for (String elm:listOfCards) {
            if (elm.equals("1")){
                return "still";
            }
        }

        for (String elm: listOfCards){
            if (elm.equals("0")){
                return "lost";
            }
        }

        return "won";
    }


}
