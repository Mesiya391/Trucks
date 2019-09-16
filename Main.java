
import java.util.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<Truck> q1 = new ArrayList<Truck>();
        ArrayList<Truck> q2 = new ArrayList<Truck>();

        queueManagement qm = new queueManagement(q1, q2, 0);

        qm.arrive(3);
        qm.arrive(2);
        qm.arrive(5);
        qm.arrive(2);
        qm.arrive(7);
        qm.arrive(1);
        qm.arrive(4);

        qm.status();

        qm.step();

        qm.waitingTime(4);
        
    }
}