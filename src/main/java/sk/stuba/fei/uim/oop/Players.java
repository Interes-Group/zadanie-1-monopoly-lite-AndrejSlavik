package sk.stuba.fei.uim.oop;

public class Players {
    //VARIABLES
    private String name;
    private int currentMoney;
    private int placeOnDeck;
    private boolean alive;
    private int playerCount;

    public Players(String name, int currentMoney, int placeOnDeck, boolean alive) {
        this.name = name;
        this.currentMoney = currentMoney;
        this.placeOnDeck = placeOnDeck;
        this.alive = alive;
    }
    // PLAYER METHODS
    private boolean IsAlive() {
    if (this.currentMoney < 0) {
            return false;
        }
        return true;
    }

    public void initializePlayers() {
        System.out.println("Enter number of players: ");
        playerCount = KeyboardInput.readInt();
        Players[] player= new Players[getPlayerCount()];
        for (int i = 0 ; i < playerCount; i++) {
            System.out.println("Enter name of the " + i + ". player:");
            String name = KeyboardInput.readString();
            player[i] = new Players(name,10000,1,IsAlive());
        }
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

    //GETTERS
    public int getPlayerCount() {
        return playerCount;
    }

    public boolean isAlive() {
        return alive;
    }

    //CONSTRUCTORS

}
