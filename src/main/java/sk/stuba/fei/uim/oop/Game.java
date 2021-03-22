package sk.stuba.fei.uim.oop;
import java.lang.Math;

public class Game extends Players{
    private final int deckPlacesCount = 24;
    private boolean gameOver = isGameOver();
    private int alivePlayers;


    public void GameStart() {
        Players[] player = new Players[getPlayerCount()];
        player = initializePlayers(player);
        clearScreen();
        System.out.println("Hraci: ");
        for (int i = 0; i < getPlayerCount(); i++) {
            System.out.println(player[i].getName());
        }
        while (isGameOver() != true){
            for (int i = 0; i < getPlayerCount(); i++) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("It's " + player[i].getName() + "'s turn!");
                System.out.println("Press ANY KEY to throw die!");
                KeyboardInput.readString();
                int dice = dieThrow();
                System.out.println(player[i].getName() + " threw: " + dice);
                System.out.println("Position: " + player[i].getPlaceOnDeck() + " -> " + (player[i].getPlaceOnDeck()+dice));
                player[i].setPlaceOnDeck(player[i].getPlaceOnDeck()+dice);
            }
        }
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean isGameOver() {
        for (int i = 0; i < getPlayerCount(); i++) {
            if (isAlive() == true) {
                alivePlayers =+ 1;
                setAlivePlayers(alivePlayers);
            }
        }
        if (alivePlayers == 1) {
            return true;
        }
        return false;
    }



    public int dieThrow() {
        return (int)((Math.random()*(6))+1);
    }

    public int getAlivePlayers() {
        return this.alivePlayers = alivePlayers;
    }

    public void setAlivePlayers(int alivePlayers) {
        this.alivePlayers = alivePlayers;
    }
}
