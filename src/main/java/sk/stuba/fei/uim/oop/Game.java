package sk.stuba.fei.uim.oop;
import java.lang.Math;

public class Game extends Players{
    private final int deckPlacesCount = 24;
    private int alivePlayers = 0;


    public void GameStart() {
        Players[] player = new Players[getPlayerCount()];
        player = InitializePlayers(player);
        System.out.println("Hraci: ");
        for (int i = 0; i < getPlayerCount(); i++) {
            System.out.print(player[i].getName() + ", ");
        }
        System.out.println();
        System.out.println("GAME STARTS!");

        while (!isGameOver(player)){
            for (int i = 0; i < getPlayerCount(); i++) {
                if (IsAlive(i,player)==true) {
                    if (player[i].getInPrison() == 0) {
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("It's " + player[i].getName() + "'s turn!");
                        System.out.println("Press ENTER to throw die!");
                        KeyboardInput.readString();
                        int dice = dieThrow();
                        System.out.println(player[i].getName() + " threw: " + dice);
                        System.out.print("Position: " + player[i].getPlaceOnDeck());
                        if ((player[i].getPlaceOnDeck() + dice) > 24) {
                            player[i].setPlaceOnDeck(((player[i].getPlaceOnDeck()) + dice) % 24);
                            System.out.println(" -> " + (player[i].getPlaceOnDeck()));
                            Actions action = new Actions();
                            action.Start(i, player);
                        } else {
                            player[i].setPlaceOnDeck(player[i].getPlaceOnDeck() + dice);
                            System.out.println(" -> " + (player[i].getPlaceOnDeck()));
                        }
                        System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());

                        propertyCheck(i,player);

                        whichAction(i, player);
                    }
                    else {
                        player[i].setInPrison(player[i].getInPrison()-1);
                    }
                }
            }
        }
    }

    public void propertyCheck(int i, Players[] player) {
        System.out.print(player[i].getName() + "'s property: [");
        for (int num: player[i].getOwnership()){
            System.out.print(num + ", ");
        }
        System.out.println("]");
    }


    public boolean isGameOver(Players[] player) {
        String victoriousPlayer = "";
        alivePlayers = 0;
        for (int i = 0; i < getPlayerCount(); i++) {
            if (IsAlive(i,player) == true) {

                alivePlayers = alivePlayers + 1;
                victoriousPlayer = player[i].getName();
            }
        }
        setAlivePlayers(alivePlayers);
        if (getAlivePlayers() == 1) {
            System.out.print(victoriousPlayer + "'s VICTORIOUS! GAME OVER!");
            return true;
        }
        return false;
    }

    public void whichAction(int i, Players[] player) {
        int playerCount = getPlayerCount();
        Actions action = new Actions();
        switch (player[i].getPlaceOnDeck()) {
            case 2: case 3: case 5: case 6: case 8: case 9: case 11: case 12: case 14: case 15: case 17: case 18: case 20: case 21: case 23: case 24:
                action = new Actions();
                action.Property(i, player, playerCount);
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
