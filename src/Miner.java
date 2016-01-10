/**
 * Created by nick on 09/01/16.
 */
public class Miner extends BaseGameEntity{
    private State currentState;

    private int goldInTheBank;
    private int goldCarried;
    private int fatigue;
    private int thirst;
    private Location location;

    private static final int THIRST_THRESHOLD = 5;
    private static final int TIREDNESS_THRESHOLD = 5;
    private static final int COMFORT_LEVEL = 5;
    private static final int MAX_GOLD_CARRIED = 3;

    public Miner(int id) {
        super(id);
        System.out.println("Creating a miner");
        thirst = 0;
        goldCarried = 0;
        goldInTheBank = 0;
        fatigue = 0;
        location = Location.SHACK;
        currentState = EnterMineAndDigForGold.getInstance();
    }

    public Location currentLocation() {
        return location;
    }

    public void changeLocation(Location l) {
        location = l;
    }

    public int getGoldInTheBank() {
        return goldInTheBank;
    }

    public void setGoldInTheBank(int goldInTheBank) {
        this.goldInTheBank += goldInTheBank;

        if (this.goldInTheBank < 0) {
            this.goldInTheBank = 0;
        }
    }

    public boolean isThirsty() {
        return (thirst >= THIRST_THRESHOLD);
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getGoldCarried() {
        return goldCarried;
    }

    public void setGoldCarried(int goldCarried) {
        this.goldCarried = goldCarried;

        if (this.goldCarried < 0) {
            this.goldCarried = 0;
        }
    }

    public void increaseFatigue() {
        fatigue++;
    }

    public void decreaseFatigue() {
        fatigue--;
    }

    public boolean isFatigued() {
        return (fatigue >= TIREDNESS_THRESHOLD);
    }

    public boolean pocketsFull() {
        return (goldCarried >= MAX_GOLD_CARRIED);
    }

    public void update() {
        thirst++;

        if (currentState != null) {
            currentState.execute(this);
        }
    }

    public void changeState(State newState) {
        assert (currentState != newState);

        currentState.exit(this);
        currentState = newState;
        currentState.enter(this);
    }

    public void buyAndDrinkAWhisky() {
        thirst = 0;
        goldInTheBank -= 2;
    }

    public boolean isComfortable() {
        return (goldInTheBank >= COMFORT_LEVEL);
    }
}
