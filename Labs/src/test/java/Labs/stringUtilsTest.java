package Labs;

import Labs.Lab6.stringUtils;
import org.junit.Assert;
import org.junit.Test;


public class stringUtilsTest
{
    @Test
    public void averageLengthTest()
    {
        final String[] array = {"12345","abcde","00101"};
        Assert.assertEquals(5, stringUtils.getAverageLength(array),0.01);
    }

    @Test
    public void getStringsTest()
    {
        final String[] array = {"123", "abcdefg", "00101001"};
        final int longerAmount = stringUtils.getStrings(array, true).length;
        final int shorterAmount = stringUtils.getStrings(array, false).length;
        Assert.assertEquals(2,longerAmount);
        Assert.assertEquals(1, shorterAmount);
    }
}
