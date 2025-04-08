import java.util.*;

public class MinimalLibrary {
    private HashMap<String, Boolean> b = new HashMap<>();

    public static void main(String[] args) {
        MinimalLibrary m = new MinimalLibrary();
        m.b.put("The Kite Runner", true);
        m.b.put("1984", true);
        m.b.put("The Hunger Games", false);

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1-Add 2-Borrow 3-Return 4-List 5-Exit");
            int c = sc.nextInt(); 
            sc.nextLine(); 
            if(c==1){
                String t = sc.nextLine();
                m.b.put(t,true);
            } else if(c==2){
                String t = sc.nextLine();
                if(m.b.containsKey(t) && m.b.get(t)){
                    m.b.put(t,false);
                    System.out.println("Borrowed.");
                } else {
                    System.out.println("Not available.");
                }
            } else if(c==3){
                String t = sc.nextLine();
                if(m.b.containsKey(t)){
                    m.b.put(t,true);
                    System.out.println("Returned.");
                } else {
                    System.out.println("Not found.");
                }
            } else if(c==4){
                for(String t : m.b.keySet()){
                    System.out.println(t + " - " + (m.b.get(t) ? "Available" : "Checked Out"));
                }
            } else if(c==5){
                break;
            }
        }
        sc.close();
    }
}