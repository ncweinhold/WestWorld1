/**
 * Created by nick on 09/01/16.
 */
public class QuenchThirst implements State {

    private static QuenchThirst instance = null;

    private QuenchThirst() {}

    public static QuenchThirst getInstance() {
        if (instance == null) {
            instance = new QuenchThirst();
        }
        return instance;
    }

    @Override
    public void enter(Miner m) {
        if (m.currentLocation() != Location.SALOON) {
            System.out.println("Walking to the saloon");
            m.changeLocation(Location.SALOON);
        }
    }

    @Override
    public void execute(Miner m) {
        if (m.isThirsty()) {
            m.buyAndDrinkAWhisky();
            System.out.println("Burp! That was some fine whisky");
            m.changeState(EnterMineAndDigForGold.getInstance());
        }
        else {
            System.out.println("Error. Miner is not thirsty");
        }
    }

    @Override
    public void exit(Miner m) {
        System.out.println("The miner is about to exit the thirsty state");
    }
}
