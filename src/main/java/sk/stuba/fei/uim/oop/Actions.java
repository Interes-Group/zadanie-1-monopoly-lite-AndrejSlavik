package sk.stuba.fei.uim.oop;

public class Actions extends Game{
    private int[] property = {2,3,5,6,8,9,11,12,14,15,17,18,20,21,23,24};
    private int police = 19;
    private int prison = 7;
    private int taxes = 13;
    private int[] chance = {4,10,16,22};
    private int start = 1;

    public Actions(String name, int currentMoney, int placeOnDeck, boolean alive, int[] ownership) {
        super(name, currentMoney, placeOnDeck, alive, ownership);
    }

    public void Property() {
        int price = 0;
        switch(player[i].getPlaceOnDeck()) {
            case 2,6,14,18,21,24:
                price = 3000;
                break;
            case 3,9,11,15,20:
                price = 5000;
                break;
            case 5,12,23:
                price = 6000;
                break;
            case 8,17:
                price = 7000;
                break;

        }
        for (int x = 0; x<getPlayerCount(); x++) {
            if (player[i].getPlaceOnDeck() == player[x].getOwnership()) {
                System.out.println("This property is owned by " + player[x].getName());
            }
            if ((player[i].getPlaceOnDeck() != player[x].getOwnership()) && (x == (getPlayerCount()-1))) {
                System.out.println("Nobody owns this property. Buy or continue? COST: " + price +  " (Type '1' if yes, '0' if continue): ");
                int buyOrContinue = KeyboardInput.readInt();
                if (buyOrContinue == '1') {
                    player[i].setCurrentMoney(player[i].getCurrentMoney()-price);
                    System.out.println(player[i].getName() + " now owns this property! BALANCE: " + player[i].getCurrentMoney());
                }
                if (buyOrContinue == '0') {
                    System.out.println(player[i].getName() + " now owns this property! BALANCE: " + player[i].getCurrentMoney());
                }

            }
        }
        System.out.println("");

    }
    public void Prison() {
        System.out.println(player[i].getName() + " visited Prison! Continue...");
    }
    public void Police() {
        player[i].setPlaceOnDeck(7);
    }
    public void Taxes() {
        if (player[i].getCurrentMoney() >= 2000) {
            player[i].setCurrentMoney(getCurrentMoney() - 2000);
        }
        else {
            player[i].isAlive() = false;
        }
    }
    public void Chance() {

    }
    public void Start() {

    }
}
