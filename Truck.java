import java.util.*;
import java.lang.*;

public class Truck {
    public static  AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private int weight;

    public Truck(int weight) {
        this.weight = weight;
        this.id = count.incrementAndGet();
    }

  public void getId(){
      return id;
  }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}