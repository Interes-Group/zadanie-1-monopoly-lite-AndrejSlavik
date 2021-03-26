package sk.stuba.fei.uim.oop.actions;

import sk.stuba.fei.uim.oop.Players;

public class Taxes{
    public void Taxes(Players[] player, int i) {
        System.out.println(player[i].getName() + " must pay 2500 EURO for taxes! ");

        player[i].setCurrentMoney(player[i].getCurrentMoney() - 2500);

        System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());

    }
}
