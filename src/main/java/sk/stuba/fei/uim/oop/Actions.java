package sk.stuba.fei.uim.oop;

/*public class Actions extends Game{
    private int[] property = {2,3,5,6,8,9,11,12,14,15,17,18,20,21,23,24};
    private int police = 19;
    private int prison = 7;
    private int taxes = 13;
    private int[] chance = {4,10,16,22};
    private int start = 1;

    public Actions(String name, int currentMoney, int placeOnDeck, boolean alive, int[] ownership) {
        super(name, currentMoney, placeOnDeck, alive, ownership);
    }

    public void Property(int i) {
        int price = 0;
        switch(getPlayers()[i].getPlaceOnDeck()) {
            case 2: case 6: case 14: case 18: case 21: case 24:
                price = 3000;
                break;
            case 3: case 9: case 11: case 15: case 20:
                price = 5000;
                break;
            case 5: case 12: case 23:
                price = 6000;
                break;
            case 8: case 17:
                price = 7000;
                break;

        }

        for (int x = 0; x<getPlayerCount(); x++) {
            for (int number = 2; number!=24; number++) {
                if ((getPlayers()[i].getPlaceOnDeck() == getPlayers()[x].getOwnership()[number]) && (x != i)) {
                    System.out.println("This property is owned by " + getPlayers()[x].getName());
                }
                if ((getPlayers()[i].getPlaceOnDeck() != getPlayers()[x].getOwnership()[number]) && (x == (getPlayerCount() - 1))) {
                    System.out.println("Nobody owns this property. Buy or continue? COST: " + price + " (Type '1' if yes, '0' if continue): ");
                    int buyOrContinue = KeyboardInput.readInt();
                    if (buyOrContinue == '1') {
                        getPlayers()[i].setCurrentMoney(getPlayers()[i].getCurrentMoney() - price);
                        System.out.println(getPlayers()[i].getName() + " now owns this property! BALANCE: " + getPlayers()[i].getCurrentMoney());
                    }
                    if (buyOrContinue == '0') {
                        System.out.println(getPlayers()[i].getName() + " now owns this property! BALANCE: " + getPlayers()[i].getCurrentMoney());
                    }
                }
            }
        }
        System.out.println("");

    }
    public void Prison(int i) {
        System.out.println(getPlayers()[i].getName() + " visited Prison! Continue...");
    }
    public void Police(int i) {
        getPlayers()[i].setPlaceOnDeck(7);
    }
    public void Taxes(int i) {
        if (getPlayers()[i].getCurrentMoney() >= 2000) {
            getPlayers()[i].setCurrentMoney(getCurrentMoney() - 2000);
        }
        else {
            //getPlayers()[i].isAlive() = false;
        }
    }
    public void Chance() {

    }
    public void Start() {

    }
}
*/