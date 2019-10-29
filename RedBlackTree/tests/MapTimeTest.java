import java.util.Random;

public class MapTimeTest {

    static Random rand = new Random();

    public static void main(String[] args) {

        Map<Integer, Integer> map = new Map<>();

        int n = 50;

        long now;
        long after;

        //setValue test
        for(int i = 0; i < n; i++) {
            now = System.nanoTime();

            map.setValue(rand.nextInt(), rand.nextInt());

            after = System.nanoTime();
            System.out.println(after-now);

        }

        //getValue test
        /*int j;
        for(int i = 1; i < n; i++) {
            for(j = n; j > i; j--) {
                map.setValue(i, i);
            }
            now = System.nanoTime();
            map.getValue(rand.nextInt(n-i) + (i+1));
            after = System.nanoTime();
            System.out.println(after-now);
            map.clear();
        }*/
    }
}
