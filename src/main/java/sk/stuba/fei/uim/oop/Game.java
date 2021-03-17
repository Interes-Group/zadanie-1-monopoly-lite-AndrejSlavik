package sk.stuba.fei.uim.oop;

public class Game extends Players{
    private int deckPlacesCount = 24;
    private boolean gameOver = isGameOver();
    private int alivePlayers = 0;

    public Game(String name, int currentMoney, int placeOnDeck, boolean alive) {
        super(name, currentMoney, placeOnDeck, alive);
    }

    public boolean isGameOver() {
        for (int i = 0; i < getPlayerCount(); i++) {
            if (isAlive() == true) {
                alivePlayers =+ 1;
                setAlivePlayers(alivePlayers);
            }
        }
        if (alivePlayers == 1) {
            return true;
        }
        return false;
    }

    public int getAlivePlayers() {
        return alivePlayers;
    }

    public void setAlivePlayers(int alivePlayers) {
        this.alivePlayers = alivePlayers;
    }
}
