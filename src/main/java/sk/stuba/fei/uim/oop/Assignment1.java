package sk.stuba.fei.uim.oop;

public class Assignment1 {
    public static void main(String[] args) {
        Players players = new Players(initializePlayers());
        players.initializePlayers();
        clearScreen();

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
