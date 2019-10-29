import java.util.ArrayList;
import java.util.Collections;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private ArrayList<T> vect = new ArrayList<>();

    @Override
    public void put(T item) {
        vect.add(item);
        update();
    }

    public T pop() {
        if(vect.size() == 0)
            return null;

        T maxValue = vect.get(0);
        Collections.swap(vect, 0, vect.size()-1);
        vect.remove(vect.size()-1);
        update();
        return maxValue;
    }

    private void update() {
        if(vect.size() == 1)
            return;

        boolean changed = false;
        int num = vect.size()-1;

        while(changed || num > 0) {
            if(changed) {
                num = vect.size() - 1;
                changed = false;
            }

            T parent = vect.get((num-1) / 2);
            T kid = vect.get(num);

            if (kid.compareTo(parent) > 0) {
                Collections.swap(vect, (num - 1) / 2, num);
                changed = true;
            }

            num--;
        }
    }

    public T getValue(int i) {
        return vect.get(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < vect.size(); i++)
            sb.append(i + ": " + vect.get(i)).append('\n');
        return sb.toString();
    }
}
