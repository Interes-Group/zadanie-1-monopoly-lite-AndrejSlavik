package sk.stuba.fei.uim.oop;
import java.lang.Math;

public class Game extends Players{
    private final int deckPlacesCount = 24;
    private boolean gameOver = isGameOver();
    private int alivePlayers = 0;

    public Game(String name, int currentMoney, int placeOnDeck, boolean alive, int[] ownership) {
        super(name, currentMoney, placeOnDeck, alive, ownership);
    }


    public void GameStart() {
        System.out.println("Enter number of players: ");
        int playerCount = KeyboardInput.readInt();
        setPlayerCount(playerCount);
        Players[] player= new Players[getPlayerCount()];
        for (int i = 0 ; i < playerCount; i++) {
            System.out.println("Enter name of the " + i + ". player:");
            String name = KeyboardInput.readString();
            player[i] = new Players(name,10000,1,IsAlive(), null);
        }
        clearScreen();
        System.out.println("Hraci: ");
        for (int i = 0; i < getPlayerCount(); i++) {
            System.out.println(getName());
        }
        while (isGameOver() != true){
            for (int i = 0; i < getPlayerCount(); i++) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("It's " + getPlayer().getName() + "'s turn!");
                int dice = dieThrow();
                System.out.println(player[i].getName() + "threw: " + dice);
                System.out.println("Position: " + player[i].getPlaceOnDeck() + " -> " + (getPlaceOnDeck()+dice));
                player[i].setPlaceOnDeck(getPlaceOnDeck()+dice);
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
        return alivePlayers;
    }

    public void setAlivePlayers(int alivePlayers) {
        this.alivePlayers = alivePlayers;
    }
}
