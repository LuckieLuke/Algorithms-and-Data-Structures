import java.util.Random;

public class HeapTest<T extends Comparable<T>> {

    private static Heap<Double> h = new Heap<>();
    private static Random rand = new Random();
    private static int n = rand.nextInt(1000);

    public static void main(String[] args) {

        int num = n;
        for(int i = 0; i < n; i++) {
            h.put(rand.nextDouble() * 10);
            if(i % 3 == 0) {
                h.pop();
                num--;
            }
        }
        n = num;

        System.out.println(test() ? "Test przeszedł pomyślnie!" : "BŁĄD");

    }

    private static boolean test() {
        boolean flag = true;

        for(int i = n-1; i >= 1; i--) {
            if (h.getValue(i).compareTo(h.getValue((i - 1) / 2)) > 0) {
                System.out.println(h.getValue(i) + " > " + h.getValue((i - 1) / 2));
                flag = false;
            }
        }

        return flag;
    }
}
