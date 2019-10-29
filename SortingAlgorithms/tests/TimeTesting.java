import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class TimeTesting {

    static Random rand = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        SortingAlgorithm merge = new MergeSort();
        SortingAlgorithm insert = new InsertionSort();

        PrintWriter pw = new PrintWriter("wyniki.txt");

        int n = 3000;
        double[] vect;

        long before;
        long after;

        for(int i = 0; i < n; i++) {
            vect = new double[i];

            for (int j = 0; j < i; j++)
                vect[j] = rand.nextDouble();

/*            generateWorstCase(vect, 0, vect.length-1);*/

            before = System.nanoTime();
/*            insert.sort(vect); */
            merge.sort(vect);
            after = System.nanoTime();

            pw.println(after-before);
        }

        pw.close();

    }


    //Generating worst case fot merge sort
    private static void generateWorstCase(double[] arr, int l, int r)
    {
        if (l < r)
        {
            int m = l + (r - l) / 2;

            double[] left = new double[m - l + 1];
            double[] right = new double[r - m];

            split(arr, left, right, l, m, r);

            generateWorstCase(left, l, m);
            generateWorstCase(right, m + 1, r);

            join(arr, left, right, l, m, r);
        }
    }

    private static void join(double[] arr, double[] left, double[] right,
                     int l, int m, int r)
    {
        int i;
        for (i = 0; i <= m - l; i++)
            arr[i] = left[i];

        for(int j = 0; j < r - m; j++)
            arr[i + j] = right[j];
    }

    private static void split(double[] arr, double[] left, double[] right,
                      int l, int m, int r)
    {
        for (int i = 0; i <= m - l; i++)
            left[i] = arr[i * 2];

        for (int i = 0; i < r - m; i++)
            right[i] = arr[i * 2 + 1];
    }
}
