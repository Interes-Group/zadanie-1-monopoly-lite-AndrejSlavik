package sk.stuba.fei.uim.oop.chance;

import sk.stuba.fei.uim.oop.Players;

public class Scam {
    public void Scam(Players[] player, int i) {
        System.out.println("The email you replied to with financial help for you cousin was a scam! You just sent 1000€ to a stranger!");
        player[i].setCurrentMoney(player[i].getCurrentMoney()-1000);
        System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());
    }
}
