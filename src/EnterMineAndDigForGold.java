/**
 * Created by nick on 09/01/16.
 */
public class EnterMineAndDigForGold implements State {

    private static EnterMineAndDigForGold instance = null;

    private EnterMineAndDigForGold() {}

    public static EnterMineAndDigForGold getInstance() {
        if (instance == null) {
            instance = new EnterMineAndDigForGold();
        }
        return instance;
    }

    @Override
    public void enter(Miner m) {
        System.out.println("Entering the mine to dig for gold");
        if (m.currentLocation() != Location.GOLDMINE) {
            System.out.println("Walking to the gold mine");
            m.changeLocation(Location.GOLDMINE);
        }

    }

    @Override
    public void execute(Miner m) {
        m.setGoldCarried(m.getGoldCarried()+1);
        m.increaseFatigue();
        System.out.println("Mining for gold");
        System.out.println("I have: " + m.getGoldCarried() + " pieces of gold in my pocket");
        if (m.pocketsFull()) {
            m.changeState(VisitBankAndDepositGold.getInstance());
        }
        if (m.isThirsty()) {
            m.changeState(QuenchThirst.getInstance());
        }

    }

    @Override
    public void exit(Miner m) {
        System.out.println("Exiting the mine now");
    }
}
