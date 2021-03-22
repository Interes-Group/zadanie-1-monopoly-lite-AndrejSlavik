package sk.stuba.fei.uim.oop;
import java.lang.Math;

public class Game extends Players{
    private final int deckPlacesCount = 24;
    private boolean gameOver = isGameOver();
    private int alivePlayers;


    public void GameStart() {
        Players[] player = new Players[getPlayerCount()];
        player = InitializePlayers(player);
        clearScreen();
        System.out.println("Hraci: ");
        for (int i = 0; i < getPlayerCount(); i++) {
            System.out.println(player[i].getName());
        }
        while (isGameOver() != true){
            for (int i = 0; i < getPlayerCount() && IsAlive(i,player)!=false; i++) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("It's " + player[i].getName() + "'s turn!");
                System.out.println("Press ANY KEY to throw die!");
                KeyboardInput.readString();
                int dice = dieThrow();
                System.out.println(player[i].getName() + " threw: " + dice);
                System.out.print("Position: " + player[i].getPlaceOnDeck());
                if ((player[i].getPlaceOnDeck()+dice)>24) {
                    player[i].setPlaceOnDeck(((player[i].getPlaceOnDeck())+dice)%24);
                    Actions action = new Actions();
                    action.Start(i,player);
                    System.out.println(" -> " + (player[i].getPlaceOnDeck()));
                }
                else {
                    System.out.println(" -> " + (player[i].getPlaceOnDeck() + dice));
                }
                System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());
                player[i].setPlaceOnDeck(player[i].getPlaceOnDeck()+dice);

                whichAction(i, player);
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

    public void whichAction(int i, Players[] player) {
        Actions action = new Actions();
        switch (player[i].getPlaceOnDeck()) {
            case 2: case 3: case 5: case 6: case 8: case 9: case 11: case 12: case 14: case 15: case 17: case 18: case 20: case 21: case 23: case 24:
                action = new Actions();
                action.Property(i, player);
                break;
            case 4: case 10: case 16: case 22:
                action = new Actions();
                action.Chance(i, player);
                break;
            case 7:
                action = new Actions();
                action.Prison(i, player);
                break;
            case 13:
                action = new Actions();
                action.Taxes(i, player);
                break;
            case 19:
                action = new Actions();
                action.Police(i, player);
                break;
        }
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
