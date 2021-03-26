package sk.stuba.fei.uim.oop.actions;

import sk.stuba.fei.uim.oop.Players;

public class Start {
    public void Start(int i, Players[] player) {
        System.out.println("Start was crossed! +4000 EURO");

        player[i].setCurrentMoney(player[i].getCurrentMoney()+4000);
    }
}
