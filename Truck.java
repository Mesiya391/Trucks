import java.util.*;
import java.lang.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Truck {
    private  static AtomicInteger count = new AtomicInteger(0);
    public final int id;
    public int weight;

    public Truck(int weight) {
        this.weight = weight;
        this.id = count.incrementAndGet();
    }

  public int getId(){
      return id;
  }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}