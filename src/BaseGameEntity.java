/**
 * Created by nick on 09/01/16.
 */
public abstract class BaseGameEntity {
    private static int nextValidID = 0;
    private int id;

    private void setID(int val) {
        assert (val >= nextValidID);
        id = val;
        nextValidID = id + 1;
    }

    public BaseGameEntity(int val) {
        this.setID(val);
    }

    public abstract void update();

    public int getID() {
        return id;
    }

}
