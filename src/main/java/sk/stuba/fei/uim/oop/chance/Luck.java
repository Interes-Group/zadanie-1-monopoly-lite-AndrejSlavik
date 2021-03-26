package sk.stuba.fei.uim.oop.chance;

import sk.stuba.fei.uim.oop.Players;

public class Luck {
    public void Luck(Players[] player, int i) {
        System.out.println("As you past the street you find a 500€ on a sidewalk. Woah! What a lucky day!");
        player[i].setCurrentMoney(player[i].getCurrentMoney()+500);
        System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());
    }
}
