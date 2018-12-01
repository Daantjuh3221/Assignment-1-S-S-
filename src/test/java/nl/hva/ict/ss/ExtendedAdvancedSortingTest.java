package nl.hva.ict.ss;


import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Put your tests that show you implemented the code correctly in this class.
 * Any test placed at a different class will be ignored!
 * Failing to add tests here will result in failing the assignment!
 */
public class ExtendedAdvancedSortingTest extends AdvancedSortingTest {

    final static int NUMBER_OF_PLAYERS = 100;

    @Test
    public void testSortingArray(){
        Player[] players = getSubList(unsortedPlayers, NUMBER_OF_PLAYERS).toArray(new Player[NUMBER_OF_PLAYERS]);
        AdvancedSorts.quickSort(players);
        boolean sorted = true;
        for(int i = 0; i < players.length - 1; i++){
            if(players[i].compareTo(players[i+1]) >= 1){
                sorted = false;
                break;
            }
        }
        Assert.assertEquals(true, sorted);
    }

    @Test
    public void testSortingLinkedList(){
        LinkedList<Player> players = getSubList(unsortedPlayers, NUMBER_OF_PLAYERS);
        AdvancedSorts.quickSort(players);
        boolean sorted = true;
        for(int i = 0; i < players.size() - 1; i++){
            Player currentPlayer = players.get(i);
            Player nextPlayer = players.get(i+1);
            if(currentPlayer.compareTo(nextPlayer) >= 1){
                sorted = false;
                break;
            }
        }
        Assert.assertEquals(true, sorted);
    }

    @Test
    public void testCompareToOfPlayerHighscore(){
        Player playerOne = new Player("Johan","Derksen",900);
        Player playerTwo = new Player("Wilfred","Genee",1000);

        int compareValue = playerOne.compareTo(playerTwo);
        Assert.assertEquals(true, compareValue < 0);

        int secondCompareValue = playerTwo.compareTo(playerOne);
        Assert.assertEquals(true, secondCompareValue > 0);
    }

    @Test
    public void testCompareToOfPlayerLastname(){
        Player playerOne = new Player("Johan","Derksen",0);
        Player playerTwo = new Player("Wilfred","Genee",0);

        int compareValue = playerOne.compareTo(playerTwo);
        Assert.assertEquals(true, compareValue < 0);

        int secondCompareValue = playerTwo.compareTo(playerOne);
        Assert.assertEquals(true, secondCompareValue > 0);
    }

    @Test
    public void testCompareToOfPlayerFirstname(){
        Player playerOne = new Player("Johan","Derksen",0);
        Player playerTwo = new Player("Wilfred","Derksen",0);

        int compareValue = playerOne.compareTo(playerTwo);
        Assert.assertEquals(true, compareValue < 0);

        int secondCompareValue = playerTwo.compareTo(playerOne);
        Assert.assertEquals(true, secondCompareValue > 0);
    }
}
