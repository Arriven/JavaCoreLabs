package Labs;

import Labs.Lab5.product;
import Labs.Lab5.productProcessor;
import org.junit.Assert;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;

public class productProcessorTest
{
    @Test
    public void simpleReceiptTest()
    {
        final product[] array = {new product("apple",2), new product("apple",3)};
        Assert.assertEquals(1, productProcessor.calculateReceipt(array).length);
        Assert.assertEquals(5, productProcessor.calculateReceipt(array)[0].getAmount());
    }

    @Test
    public void makeProductListTest() throws Exception
    {
        final String[] names = {"apple","watermelon","orange"};
        final int[] amounts = {10,2,5};
        final product[] products = {
                new product("apple",10),
                new product("watermelon",2),
                new product("orange",5)
        };
        final product[] result = productProcessor.makeProductList(names,amounts);
        Assert.assertEquals(3,result.length);
        for (int i = 0; i < 3; i++)
        {
            Assert.assertEquals(products[i], result[i]);
        }
    }

    @Test
    public void makeProductListWithWrongDataTest()
    {
        final int[] amounts1 = {};
        final int[] amounts2 = {1,2,3};
        final String[] names = {"apple"};
        assertThatThrownBy(() ->productProcessor.makeProductList(names,amounts1)).isInstanceOf(Exception.class);
        assertThatThrownBy(() ->productProcessor.makeProductList(names,amounts2)).isInstanceOf(Exception.class);
    }
}
