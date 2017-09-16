package Labs;

import Labs.Lab2.person;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class personEqualsTest
{
    @Test
    public void simpleEqualityTest()
    {
        Assert.assertEquals(new person("John",20,70,180),
                new person("John",20,70,180));
    }

    @Test
    public void jsonSerializationTest()
    {
        final Gson gson = new Gson();
        final person original = new person("John",20,70,180);
        final String serialized = gson.toJson(original);
        final person deserialized = gson.fromJson(serialized, original.getClass());
        Assert.assertEquals(original, deserialized);
    }
}
