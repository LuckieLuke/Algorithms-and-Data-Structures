public class ListSorter implements ListSorterAlgorithm {

    private Heap h;

    @Override
    public double[] sort(double[] unsortedVector) {
        h = new Heap<Double>();

        for(double d: unsortedVector)
            h.put(d);

        for(int i = 0; i < unsortedVector.length; i++)
            unsortedVector[unsortedVector.length-i-1] = (double)h.pop();

        return unsortedVector;
    }
}
