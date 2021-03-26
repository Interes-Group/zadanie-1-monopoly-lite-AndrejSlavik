package sk.stuba.fei.uim.oop.chance;

import sk.stuba.fei.uim.oop.Players;

public class Weather{
    public void Weather(Players[] player, int i) {
        System.out.println("The weather today is really chilly and rainy! You should wait 1 ROUND here in local coffee shop until it gets better!");
        player[i].setInPrison(1);
    }
}
