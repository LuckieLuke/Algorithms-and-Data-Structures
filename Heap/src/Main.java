public class Main {
    public static void main(String[] args) {
        double[] list = new double[]{3.5, 8.23, 5.76, 7.74, 12.2222, 6.1534, 14.765, 9.34954};
        ListSorter ls = new ListSorter();
        list = ls.sort(list);

    for(double d: list)
        System.out.println(d);
    }
}
