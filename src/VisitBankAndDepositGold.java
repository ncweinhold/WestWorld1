/**
 * Created by nick on 09/01/16.
 */
public class VisitBankAndDepositGold implements State {

    private static VisitBankAndDepositGold instance = null;

    private VisitBankAndDepositGold() {}

    public static VisitBankAndDepositGold getInstance() {
        if (instance == null) {
            instance = new VisitBankAndDepositGold();
        }
        return instance;
    }

    @Override
    public void enter(Miner m) {
        if (m.currentLocation() != Location.BANK) {
            System.out.println("Walking to the bank");
            m.changeLocation(Location.BANK);
        }
    }

    @Override
    public void execute(Miner m) {
        System.out.println("Gold carried is: " + m.getGoldCarried());
        m.setGoldInTheBank(m.getGoldCarried());
        m.setGoldCarried(0);
        System.out.println("Total savings are now: " + m.getGoldInTheBank());

        if (m.isComfortable()) {
            System.out.println("Time for a well earned rest");
            m.changeState(GoHomeAndSleepUntilRested.getInstance());
        } else {
            System.out.println("I need to earn more gold");
            m.changeState(EnterMineAndDigForGold.getInstance());
        }
    }

    @Override
    public void exit(Miner m) {
        System.out.println("Leaving the bank");
    }
}
