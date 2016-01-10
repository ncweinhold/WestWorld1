/**
 * Created by nick on 09/01/16.
 */
public class GoHomeAndSleepUntilRested implements State {

    private static GoHomeAndSleepUntilRested instance = null;

    private GoHomeAndSleepUntilRested() {}

    public static GoHomeAndSleepUntilRested getInstance() {
        if (instance == null) {
            instance = new GoHomeAndSleepUntilRested();
        }
        return instance;
    }

    @Override
    public void enter(Miner m) {
        if (m.currentLocation() != Location.SHACK) {
            System.out.println("Walking home");
            m.changeLocation(Location.SHACK);
        }
    }

    @Override
    public void execute(Miner m) {
        if (!m.isFatigued()) {
            System.out.println("Feeling rested, time to mine for more gold");
            m.changeLocation(Location.GOLDMINE);
        } else {
            m.decreaseFatigue();
            System.out.println("ZZZ....");
        }

    }

    @Override
    public void exit(Miner m) {
        System.out.println("Leaving the house");
    }
}
