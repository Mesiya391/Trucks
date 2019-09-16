import java.util.*;


public class queueManagement {
    private ArrayList<Truck> q1 = new ArrayList<Truck>();
    private ArrayList<Truck> q2 = new ArrayList<Truck>();
    private Queue<Truck> wq = new LinkedList<Truck>(); 
    public int time;

    public queueManagement(ArrayList<Truck> q1, ArrayList<Truck> q2, int time){
        this.q1 = q1;
        this.q2 = q2;
        this.time = time;
    }

    public int waitingTime2 (ArrayList q){
        int t=0;
        if(q.isEmpty()){
            t = 0;
        } else {
            t = q.stream().mapToObj( Truck -> Truck.weight.sum());
        }
    return t;
    }

   public void arrive (int weight){
       Truck t  = new Truck(weight);
       int wt1 = waitingTime2(q1);
       int wt2 = waitingTime2(q2);
       if((q1.size()>=5)&&(q2.size()>=5)){
           wq.add(t);
       }
       else if((q1.isEmpty())&&(q2.isEmpty())){
           q1.add(t);
       } else if(wt1>wt2){
           q2.add(t);
       }
       else {
           q1.add(t);
       }
   }

   public void swap(ArrayList<Truck> q1, ArrayList<Truck> q2,  int index ){
       Truck tt = new Truck(1);
       tt = q1.get(index);
       q1.get(index) = q2.get(index);
       q2.get(index) = tt; 

   }

   public void waitingTime(int ID){
       int tt=0;
       
       Optional<Truck> matched = q1.stream().filter( t -> t::id).equals(ID).findFirst();
       if( matched != null){
       int k = indexOf(matched);
       for(int i=0; i<=k; i++){
         tt+= q1.get(i).getWeight();
       }
    }
       else {
        Optional<Truck> matched2 = q2.stream().
        filter( t -> t.id).equals(ID).findFirst();
        int s = indexOf(matched2);
        for(int j=0; j<=s; j++){
         tt+= q1.get(j).getWeight();
       }
    }
    return tt;
    }

    public void step(){
        time++;
        q1.get(0).getWeight()--;
        q2.get(0).getWeight()--;
        if(q1.get().getWeight()==0){
            int l = q1.size();
            Truck temp = new Truck(1);
            for(int i=1; i<l; i++){
             q1.set(i-1, q1.get(i)) = q1.get(i);
            }
        }
        else if(q2.get().getWeight==0){
            int m = q2.size();
            Truck temp = new Truck(1);
            for(int j=1; i<m; j++){
             q2.set(j-1, q2.get(j)) = q2.get(j);
        }
    }

        if(waitingTime2(q1>q2)){
            ArrayList<Truck> c1 = q1.stream()
            .skip(1)
            .collect(Collectors.toList());
            Truck tt = c1.stream().max(Comparator.comparing(Truck::getWeight)).get();
            int k = q1.indexOf(tt);
            swap(q1, q2, k);    
        }
        else if (q2>q1){
            ArrayList<Truck> c2 = q2.stream()
            .skip(1)
            .collect(Collectors.toList());
            Truck tt2 = c2.stream().max(Comparator.comparing(Truck::getWeight)).get();
            int n = q2.indexOf(tt2);
            swap(q2, q1, n);    
        }
        else{}
    }

    public void status(){
        System.out.printf("%-10s %-10s %-10s\n", "ID", "Weight", "Waiting time");
        for(int i = 0; i<q1.size(); i++){
            System.out.println("%-10s %-10s %-10s\n", q1.get(i).getId(i), q1.get().getWeight(), waitingTime(q1.get(i).getId()));
    }

    System.out.println("-----------------------------------------------------");

    System.out.printf("%-10s %-10s %-10s\n", "ID", "Weight", "Waiting time");
    for(int j = 0; i<q2.size(); j++){
        System.out.println("%-10s %-10s %-10s\n", q2.get(j).getId(), q2.get(j).getWeight(), waitingTime(q2.get(j).getId()));
}
    }
      

}