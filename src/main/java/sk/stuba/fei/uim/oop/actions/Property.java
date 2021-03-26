package sk.stuba.fei.uim.oop.actions;


import sk.stuba.fei.uim.oop.KeyboardInput;
import sk.stuba.fei.uim.oop.Players;
import sk.stuba.fei.uim.oop.Game;

import java.util.Arrays;

public class Property extends Game{
    private int price = 0;
    private boolean block = false;

    public void Property(Players[] player, int i, int playerCount) {
        setPlayerCount(playerCount);

        switch (player[i].getPlaceOnDeck()) {
            case 2:
            case 6:
            case 14:
            case 18:
            case 21:
            case 24:
                setPrice(2000);
                break;
            case 3:
            case 9:
            case 11:
            case 15:
            case 20:
                setPrice(3500);
                break;
            case 5:
            case 12:
            case 23:
                setPrice(4500);
                break;
            case 8:
            case 17:
                setPrice(6000);
                break;
        }


        for (int x = 0; x < getPlayerCount(); x++) {
            playerOwnership(player, x, i);
            enemyOwnership(player, x, i);
            noOwnership(player, x, i);
        }
    }

    public void playerOwnership(Players[] player, int x, int i) {
        for (int number : player[x].getOwnership()) {
            if ((player[i].getPlaceOnDeck() == number) && (x == i) && (!isBlock())) {
                System.out.println("You visited your own property! Continuing...");

                setBlock(true);
            }
        }
    }

    public void enemyOwnership(Players[] player, int x, int i) {
        for (int number : player[x].getOwnership()) {
            if ((player[i].getPlaceOnDeck() == number) && (x != i) && (!isBlock())) {
                System.out.println("This property is owned by " + player[x].getName());
                System.out.println("You must pay 1/3 price of property for visiting! Price:" + (getPrice() / 3));

                player[i].setCurrentMoney(player[i].getCurrentMoney() - (getPrice()  / 3));
                player[x].setCurrentMoney(player[x].getCurrentMoney() + (getPrice()  / 3));

                System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());

                IsAlive(i, player);

                setBlock(true);
            }
        }
    }

    public void noOwnership(Players[] player, int x, int i) {
        for (int number : player[x].getOwnership()) {
            if ((player[i].getPlaceOnDeck() != number) && (x == (getPlayerCount() - 1)) && (!isBlock())) {
                System.out.println("Nobody owns this property. Buy or continue? COST: " + getPrice()  + " (Type '1' if yes, '0' if continue): ");

                int buyOrContinue = KeyboardInput.readInt();
                if (buyOrContinue == 1) {
                    if ((player[i].getCurrentMoney() - getPrice() ) >= 0) {
                        player[i].setCurrentMoney(player[i].getCurrentMoney() - getPrice() );
                        player[i].setOwnership(Arrays.copyOf(player[i].getOwnership(), player[i].getOwnership().length + 1));
                        player[i].setOwnership(player[i].getPlaceOnDeck(), player[i].getOwnership().length - 1);

                        System.out.println(player[i].getName() + " now owns this property! BALANCE: " + player[i].getCurrentMoney());
                    } else {
                        System.out.println("You don't have enough money to buy this property! Continuing... ");
                    }
                }
                if (buyOrContinue == 0) {
                    System.out.println("Continuing... ");
                }
                propertyCheck(i, player);

                setBlock(true);
            }
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
}
