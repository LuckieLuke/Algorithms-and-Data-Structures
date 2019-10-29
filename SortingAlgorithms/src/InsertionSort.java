public class InsertionSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {

        for(int i = 0; i < unsortedVector.length; i++) {
            double value = unsortedVector[i];
            int j = i-1;

            while(j >= 0 && unsortedVector[j] > value) {
                unsortedVector[j+1] = unsortedVector[j];
                j--;
            }
            unsortedVector[j+1] = value;
        }

        return unsortedVector;
    }
}
