import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SorterTest {

    static Random rand = new Random();

    public static void main(String[] args) {

        ListSorter ls = new ListSorter();

        int size = rand.nextInt(1000);
        ArrayList<Double> list = new ArrayList<>(size);
        for(int i = 0; i < size; i++)
            list.add(rand.nextDouble()*10);

        double[] toCheck = new double[size];
        for(int i = 0; i < size; i++)
            toCheck[i] = list.get(i);

        Collections.sort(list);
        ls.sort(toCheck);

        boolean flag = true;
        for(int i = 0; i < size; i++) {
            if(list.get(i) != toCheck[i]) {
                System.err.println("BŁĄD");
                System.out.println(list.get(i) + " != " + toCheck[i]);
                i = size;
                flag = false;
            }
        }

        if(flag)
            System.out.println("Test przeszedł pomyślnie!");
    }

}
