package Labs.Lab6;

import java.util.Arrays;
import java.util.function.Predicate;

public class stringUtils
{
    public static final double getAverageLength(final String[] array)
    {
        return Arrays.stream(array).mapToInt(x -> x.length()).average().getAsDouble();
    }

    public static final String[] getStrings(final String[] array, final Boolean longer)
    {
        final double mid = getAverageLength(array);
        final Predicate<String> predicate = longer ? x -> x.length() > mid : x -> x.length() < mid;
        return Arrays.stream(array).filter(predicate).toArray(String[]::new);
    }
}
