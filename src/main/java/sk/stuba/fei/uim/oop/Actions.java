package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.chance.*;
import sk.stuba.fei.uim.oop.actions.*;

import java.util.Arrays;

public class Actions extends Game {
    private int[] property = {2,3,5,6,8,9,11,12,14,15,17,18,20,21,23,24};
    private final int police = 19;
    private final int prison = 7;
    private final int taxes = 13;
    private final int start = 1;
    private final int[] chance = {4,10,16,22};
    private int counter = 1;


    public void Property(int i, Players[] player, int playerCount) {
        int price = 0;

        switch(player[i].getPlaceOnDeck()) {
            case 2: case 6: case 14: case 18: case 21: case 24:
                price = 2000;
                break;
            case 3: case 9: case 11: case 15: case 20:
                price = 3500;
                break;
            case 5: case 12: case 23:
                price = 4500;
                break;
            case 8: case 17:
                price = 6000;
                break;
        }

        boolean block = false;

        for (int x = 0; x < playerCount; x++) {
            for (int number: player[x].getOwnership()) {
                if ((player[i].getPlaceOnDeck() == number) && (x == i) && (!block)) {
                    System.out.println("You visited your own property! Continuing...");

                    block = true;
                }
            }
            for (int number: player[x].getOwnership()) {
                if ((player[i].getPlaceOnDeck() == number) && (x != i) && (!block)) {
                    System.out.println("This property is owned by " + player[x].getName());
                    System.out.println("You must pay 1/3 price of property for visiting! Price:" + (price / 3));

                    player[i].setCurrentMoney(player[i].getCurrentMoney() - (price / 3));
                    player[x].setCurrentMoney(player[x].getCurrentMoney() + (price / 3));

                    System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());

                    IsAlive(i, player);
                    block = true;
                }
            }
            for (int number: player[x].getOwnership()) {
                if ((player[i].getPlaceOnDeck() != number) && (x == (playerCount - 1)) && (!block)) {
                    System.out.println("Nobody owns this property. Buy or continue? COST: " + price + " (Type '1' if yes, '0' if continue): ");

                    int buyOrContinue = KeyboardInput.readInt();
                    if (buyOrContinue == 1) {
                        if ((player[i].getCurrentMoney() - price) >= 0) {
                            player[i].setCurrentMoney(player[i].getCurrentMoney() - price);
                            player[i].setOwnership(Arrays.copyOf(player[i].getOwnership(), player[i].getOwnership().length + 1));
                            player[i].setOwnership(player[i].getPlaceOnDeck(), player[i].getOwnership().length - 1);

                            System.out.println(player[i].getName() + " now owns this property! BALANCE: " + player[i].getCurrentMoney());
                        }
                        else {
                            System.out.println("You don't have enough money to buy this property! Continuing... ");
                        }
                    }
                    if (buyOrContinue == 0) {
                        System.out.println("Continuing... ");
                    }
                    propertyCheck(i,player);
                    block = true;
                }
            }
        }
    }

    public void Prison(int i, Players[] player) {
        System.out.println(player[i].getName() + " visited Prison! Continue...");
    }

    public void Police(int i, Players[] player) {
        player[i].setInPrison((int)(Math.random()*(3)+1));
        System.out.println(player[i].getName() + " was sent to Prison by Police for " + player[i].getInPrison() + " round(s)!");
        System.out.print(player[i].getName() + "'s position: " + player[i].getPlaceOnDeck());

        player[i].setPlaceOnDeck(7);
        System.out.println(" -> " + player[i].getPlaceOnDeck());
    }

    public void Taxes(int i, Players[] player) {
        System.out.println(player[i].getName() + " must pay 2500 EURO for taxes! ");

        player[i].setCurrentMoney(player[i].getCurrentMoney() - 2500);

        System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());

        IsAlive(i,player);

    }

    public void Chance(int i, Players[] player, Integer[] chanceCardsOrder) {
        switch (chanceCardsOrder[getCounter()]){
            case 1:
                Barber barber = new Barber();
                barber.Barber(player, i);
                break;
            case 2:
                Lottery lottery = new Lottery();
                lottery.Lottery(player, i);
                break;
            case 3:
                Luck luck = new Luck();
                luck.Luck(player, i);
                break;
            case 4:
                Scam scam = new Scam();
                scam.Scam(player, i);
                break;
            case 5:
                Weather weather = new Weather();
                weather.Weather(player, i);
                break;
        }
        if(getCounter() != 5 ) {
            setCounter(getCounter()+1);
        }
        else {
            setCounter(1);
        }
    }
    public void Start(int i, Players[] player) {
        System.out.println("Start was crossed! +4000 EURO");

        player[i].setCurrentMoney(player[i].getCurrentMoney()+4000);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
