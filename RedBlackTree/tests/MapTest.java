import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MapTest {

    ArrayList<Integer> list = new ArrayList<>();

    @Test
    public void setValue() { //coloring check
        Map<Integer, String> map = new Map<>();
        map.setValue(5, "Koparka");
        map.setValue(4, "Parasol");
        map.setValue(3, "Firanka");
        map.setValue(2, "Enter");
        map.setValue(1, "Kubek");

        boolean colors = false;

        //check if all red-to-be nodes are actually red
        if(map.getNode(1).getColor() && map.getNode(3).getColor())
            colors = true;

        //check if any of the black-to-be nodes is red
        if(map.getNode(2).getColor() || map.getNode(4).getColor() || map.getNode(5).getColor())
            colors = false;

        assertTrue(colors);
    }

    @Test
    public void getValue() {
        Map<Double, Integer> map = new Map<>();
        map.setValue(2.5, 5);
        map.setValue(6.7, 1);
        map.setValue(5.2, 97);

        Integer expectedOutput = map.getValue(6.7);
        Integer rightOutput = 1;

        assertEquals(expectedOutput, rightOutput);
    }

}