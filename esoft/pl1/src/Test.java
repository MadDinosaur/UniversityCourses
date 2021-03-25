import org.junit.Assert;

import static org.junit.Assert.*;

public class Test {

    @org.junit.Test
    public void sortVectorAscNull() {
        int[] data = null;
        int[] expected = null;

        int[] result = Main.sortVectorAsc(data);

        Assert.assertArrayEquals(expected, result);
        }

    public void sortVectorAscEmpty() {
        int[] data = null;
        int[] expected = null;

        int[] result = Main.sortVectorAsc(data);

        Assert.assertArrayEquals(expected, result);
    }
    }
}