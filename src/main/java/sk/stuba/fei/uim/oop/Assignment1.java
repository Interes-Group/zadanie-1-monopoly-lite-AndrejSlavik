package sk.stuba.fei.uim.oop;

public class Assignment1 {
    public static void main(String[] args) {
        System.out.println("Enter number of players: ");
        int playerCount = KeyboardInput.readInt();
        Players player = new Players();
        for (int i = 0 ; i<playerCount; i++) {
            System.out.println("Enter name of the " + i + ". player:");
            player.name = KeyboardInput.readString();
        }
    }
}
