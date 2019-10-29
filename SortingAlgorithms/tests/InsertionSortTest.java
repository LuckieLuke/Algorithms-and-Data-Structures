import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void sort() {
        double[] check = new double[]{0.5, 4.3, 2.65, 4.21, 18.0001, 13.33, 5.32, 8.21};

        double[] sorted = Arrays.copyOf(check, check.length);
        Arrays.sort(sorted);

        MergeSort merge = new MergeSort();
        check = merge.sort(check);

        boolean flag = true;

        for(int i = 0; i < check.length; i++)
            if(sorted[i] != check[i])
                flag = false;

        Assert.assertTrue(flag);
    }
}