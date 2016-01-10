/**
 * Created by nick on 09/01/16.
 */
public class Driver {
    public static void main(String [] args) {
        System.out.println("West World Example!");
        Miner bob = new Miner(1);

        for (int i = 0; i < 20; i++) {
            bob.update();
        }
    }
}
