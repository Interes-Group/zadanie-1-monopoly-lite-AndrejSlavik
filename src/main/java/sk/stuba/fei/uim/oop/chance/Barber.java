package sk.stuba.fei.uim.oop.chance;

import sk.stuba.fei.uim.oop.Players;

public class Barber {
    public void Barber(Players[] player, int i) {
        System.out.println("The barber today cost a bit more than usual, pay him 500€!");
        player[i].setCurrentMoney(player[i].getCurrentMoney()-500);
        System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());
    }
}
