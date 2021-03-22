package sk.stuba.fei.uim.oop;

public class Players {
    //VARIABLES
    private Players[] player;
    private String name;
    private int currentMoney;
    private int placeOnDeck;
    private boolean alive;
    private int playerCount;
    private int[] ownership;

    public Players(String name, int currentMoney, int placeOnDeck, boolean alive, int[] ownership) {
        this.name = name;
        this.currentMoney = currentMoney;
        this.placeOnDeck = placeOnDeck;
        this.alive = alive;
        this.ownership = ownership;
    }


    // PLAYER METHODS
    public boolean IsAlive(int i, Players[] player) {
        if (player[i].getCurrentMoney() < 0) {
            player[i].setOwnership(null);
            System.out.println(player[i].getName() + " doesn't have enough money! DEFEATED!");
            return false;
        }
        return true;
    }

    public Players[] InitializePlayers(Players[] player) {
        System.out.println("Enter number of players: ");
        setPlayerCount(KeyboardInput.readInt());
        player = new Players[getPlayerCount()];
        for (int i = 0 ; i != playerCount; i++) {
            System.out.println("Enter name of the " + (i+1) + ". player:");
            String name = KeyboardInput.readString();
            player[i] = new Players(name,10000,1,true, null);
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public void setOwnership(int[] ownership) {
        this.ownership = ownership;
    }

    //GETTERS
    public int getPlayerCount() {
        return playerCount;
    }

    public boolean isAlive() {
        return alive;
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

    //CONSTRUCTORS

    public Players() {
    }
}
