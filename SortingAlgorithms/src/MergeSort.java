public class MergeSort implements SortingAlgorithm {

    private double[] v;

    @Override
    public double[] sort(double[] unsortedVector) {
        v = unsortedVector;
        mergeSort(0, unsortedVector.length-1);
        return unsortedVector;
    }

    private void mergeSort(int p, int k) {
        if(p < k) {
            int mid = (p + k) / 2;
            mergeSort(p, mid);
            mergeSort(mid+1, k);
            merge(p, mid, k);
        }
    }

    private void merge(int p, int mid, int k) {
        double[] tmp = new double[v.length];
        int p1 = p;
        int p2 = mid+1;

        int i = p1;
        while((p1 <= mid) && (p2 <= k)) {
            if(v[p1] < v[p2]) {
                tmp[i] = v[p1];
                p1++;
            }
            else {
                tmp[i] = v[p2];
                p2++;
            }
            i++;
            }

        while(p1 <= mid) {
            tmp[i] = v[p1];
            p1++;
            i++;
        }
        while(p2 <= k) {
            tmp[i] = v[p2];
            p2++;
            i++;
        }

        for(i = p; i <= k; i++)
            v[i] = tmp[i];
    }
}

