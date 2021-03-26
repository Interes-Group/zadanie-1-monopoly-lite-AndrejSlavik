package sk.stuba.fei.uim.oop.actions;

import sk.stuba.fei.uim.oop.Players;

public class Police {
    public void Police(Players[] player, int i) {
        player[i].setInPrison((int)(Math.random()*(3)+1));
        System.out.println(player[i].getName() + " was sent to Prison by Police for " + player[i].getInPrison() + " round(s)!");
        System.out.print(player[i].getName() + "'s position: " + player[i].getPlaceOnDeck());

        player[i].setPlaceOnDeck(7);
        System.out.println(" -> " + player[i].getPlaceOnDeck());
    }
}
