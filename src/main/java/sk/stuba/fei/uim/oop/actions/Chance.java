package sk.stuba.fei.uim.oop.actions;

import sk.stuba.fei.uim.oop.Players;
import sk.stuba.fei.uim.oop.chance.*;

public class Chance {
    private int counter = 1;
    public void Chance(Players[] player, int i, Integer[] chanceCardsOrder) {
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
