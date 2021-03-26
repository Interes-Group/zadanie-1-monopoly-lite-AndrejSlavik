package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.actions.*;

public class Players {
    //VARIABLES
    private String name;
    private int currentMoney;
    private int placeOnDeck;
    private boolean alive;
    private int playerCount;
    private int[] ownership;
    private int inPrison;

    public Players(String name, int currentMoney, int placeOnDeck, boolean alive, int[] ownership, int inPrison) {
        this.name = name;
        this.currentMoney = currentMoney;
        this.placeOnDeck = placeOnDeck;
        this.alive = alive;
        this.ownership = ownership;
        this.inPrison = inPrison;
    }


    // PLAYER METHODS

    public Players[] playerInitialize() {
        Players[] player = new Players[getPlayerCount()];
        player = InitializePlayers(player);
        System.out.println("Players: ");
        for (int i = 0; i < getPlayerCount(); i++) {
            System.out.print(player[i].getName() + ", ");
        }
        return player;
    }

    public void IsAlive(int i, Players[] player) {
        if ((player[i].getCurrentMoney() < 0) && player[i].getAlive()) {
            player[i].setOwnership(new int[] {0});
            System.out.println(player[i].getName() + " doesn't have enough money! DEFEATED!");
            player[i].setAlive(false);
        }
    }

    public Players[] InitializePlayers(Players[] player) {
        System.out.println("Enter number of players: ");
        playerCount = KeyboardInput.readInt();
        setPlayerCount(playerCount);
        System.out.println("hraci=" + getPlayerCount());
        player = new Players[getPlayerCount()];
        for (int i = 0 ; i != playerCount; i++) {
            System.out.println("Enter name of the " + (i+1) + ". player:");
            String name = KeyboardInput.readString();
            player[i] = new Players(name,12500,1,true, new int[]{0}, 0);
        }
        return player;
    }

    //SETTERS
    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public void setPlaceOnDeck(int placeOnDeck) {
        this.placeOnDeck = placeOnDeck;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public void setOwnership(int[] ownership) {
        this.ownership = ownership;
    }

    public void setOwnership(int ownership, int i) {
        this.ownership[i] = ownership;
    }

    public void setInPrison(int inPrison) {
        this.inPrison = inPrison;
    }

    //GETTERS
    public int getPlayerCount() {
        return playerCount;
    }

    public String getName() {
        return name;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public int getPlaceOnDeck() {
        return placeOnDeck;
    }

    public int[] getOwnership() {
        return ownership;
    }

    public int getInPrison() {
        return inPrison;
    }

    public boolean getAlive() {
        return alive;
    }

    //CONSTRUCTORS

    public Players() {
    }
}
