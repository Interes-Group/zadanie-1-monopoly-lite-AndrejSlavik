package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.actions.*;

import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game extends Players{
    private int alivePlayers = 0;
    private Integer[] chanceCardsOrder = {1,2,3,4,5};
    private int counter = 0;
    private boolean endGame = false;


    public void GameStart() {
        Players[] player = playerInitialize();
        randomChanceOrder();
        System.out.println();
        System.out.println("GAME STARTS!");

        while (!isGameOver(player)){
            for (int i = 0; i < getPlayerCount(); i++) {
                if (player[i].getAlive()) {
                    gameLoop(player, i);
                }
                if (isEndGame()) {
                    break;
                }
            }
        }
    }

    public void gameLoop(Players[] player, int i) {
        if (player[i].getInPrison() == 0) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("It's " + player[i].getName() + "'s turn!");
            System.out.println("Press ENTER to throw die!");
            KeyboardInput.readString();
            int dice = dieThrow();
            System.out.println(player[i].getName() + " threw: " + dice);
            System.out.print("Position: " + player[i].getPlaceOnDeck());

            throughStart(player, i, dice);

            System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());

            propertyCheck(i,player);

            whichAction(i, player);
        }
        else {
            player[i].setInPrison(player[i].getInPrison()-1);
        }
    }

    public void throughStart(Players[] player, int i, int dice) {
        if ((player[i].getPlaceOnDeck() + dice) > 24) {
            player[i].setPlaceOnDeck(((player[i].getPlaceOnDeck()) + dice) % 24);
            System.out.println(" -> " + (player[i].getPlaceOnDeck()));
            Start start = new Start();
            start.Start(i, player);
        } else {
            player[i].setPlaceOnDeck(player[i].getPlaceOnDeck() + dice);
            System.out.println(" -> " + (player[i].getPlaceOnDeck()));
        }
    }

    public void randomChanceOrder() {
        List<Integer> intListChanceOrder = Arrays.asList(chanceCardsOrder);
        Collections.shuffle(intListChanceOrder);
        intListChanceOrder.toArray(chanceCardsOrder);
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
        setAlivePlayers(0);
        for (int i = 0; i < getPlayerCount(); i++) {
            if (player[i].getAlive()) {
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
        switch (player[i].getPlaceOnDeck()) {
            case 2: case 3: case 5: case 6: case 8: case 9: case 11: case 12: case 14: case 15: case 17: case 18: case 20: case 21: case 23: case 24:
                Property property = new Property();
                property.Property(player, i, getPlayerCount());
                IsAlive(i,player);
                if (isGameOver(player)) {
                    setEndGame(true);
                }
                break;
            case 4: case 10: case 16: case 22:
                Chance chance = new Chance();
                        chance.Chance(player, i, chanceCardsOrder, counter);
                if(getCounter() < 4 ) {
                    setCounter(getCounter() + 1);
                }
                else {
                    setCounter(0);
                }
                IsAlive(i,player);
                if (isGameOver(player)) {
                    setEndGame(true);
                }
                break;
            case 7:
                Prison prison = new Prison();
                prison.Prison(player, i);
                break;
            case 13:
                Taxes taxes = new Taxes();
                taxes.Taxes(player, i);
                IsAlive(i,player);
                if (isGameOver(player)) {
                    setEndGame(true);
                }
                break;
            case 19:
                Police police = new Police();
                police.Police(player, i);
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }
}
