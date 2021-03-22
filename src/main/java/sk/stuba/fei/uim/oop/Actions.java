package sk.stuba.fei.uim.oop;

public class Actions extends Game {
    private int[] property = {2,3,5,6,8,9,11,12,14,15,17,18,20,21,23,24};
    private int police = 19;
    private int prison = 7;
    private int taxes = 13;
    private int[] chance = {4,10,16,22};

    public void Property(int i, Players[] player) {
        int price = 0;
        switch(player[i].getPlaceOnDeck()) {
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
                if ((player[i].getPlaceOnDeck() == player[x].getOwnership()[number]) && (x != i)) {
                    System.out.println("This property is owned by " + player[x].getName());
                }
                if ((player[i].getPlaceOnDeck() != player[x].getOwnership()[number]) && (x == (getPlayerCount() - 1))) {
                    System.out.println("Nobody owns this property. Buy or continue? COST: " + price + " (Type '1' if yes, '0' if continue): ");
                    int buyOrContinue = KeyboardInput.readInt();
                    if (buyOrContinue == '1') {
                        player[i].setCurrentMoney(player[i].getCurrentMoney() - price);
                        System.out.println(player[i].getName() + " now owns this property! BALANCE: " + player[i].getCurrentMoney());
                    }
                    if (buyOrContinue == '0') {
                        System.out.println(player[i].getName() + " now owns this property! BALANCE: " + player[i].getCurrentMoney());
                    }
                }
            }
        }
    }
    public void Prison(int i, Players[] player) {
        System.out.println(player[i].getName() + " visited Prison! Continue...");
    }
    public void Police(int i, Players[] player) {
        System.out.println(player[i].getName() + " was sent to Prison by Police!");
        player[i].setPlaceOnDeck(7);
        System.out.println(player[i].getName() + "'s position: " + player[i].getPlaceOnDeck());
    }
    public void Taxes(int i, Players[] player) {
        System.out.println(player[i].getName() + " must pay 2000 EURO for taxes! ");
        player[i].setCurrentMoney(getCurrentMoney() - 2000);
        if (player[i].getCurrentMoney() >= 2000) {
            System.out.println(player[i].getName() + "'s balance: " + player[i].getCurrentMoney());
        }
        else {
            System.out.println(player[i].getName() + " doesn't have enough money!");
            IsAlive(i,player);
        }
    }
    public void Chance(int i, Players[] player) {

    }
    public void Start(int i, Players[] player) {
        player[i].setCurrentMoney(player[i].getCurrentMoney()+5000);
    }
}
