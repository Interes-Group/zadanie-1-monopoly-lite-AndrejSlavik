package sk.stuba.fei.uim.oop.chance;

import sk.stuba.fei.uim.oop.Players;

public class Lottery {
    public void Lottery(Players[] player, int i) {
        int prize = (int)((Math.random()*(3))+1);
        int money = 0;
        switch(prize){
            case 1:
                money = 4000;
                break;
            case 2:
                money = 2000;
                break;
            case 3:
                money = 1500;
                break;
        }
        System.out.println("You've won the " + prize + ". prize in the lottery! Money won: " + money);
        player[i].setCurrentMoney(player[i].getCurrentMoney() + money);
        System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());

    }
}
