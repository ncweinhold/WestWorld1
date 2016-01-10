/**
 * Created by nick on 09/01/16.
 */
public interface State {
    public void enter(Miner m);
    public void execute(Miner m);
    public void exit(Miner m);
}
