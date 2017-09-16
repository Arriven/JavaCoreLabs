package Labs.Lab5;

import java.util.*;


public class productProcessor
{
    public static final product[] makeProductList(final String[] names, final int[] amounts) throws Exception
    {
        if(names.length != amounts.length)
        {
            throw new Exception("Should provide same amounts of names and amounts");
        }
        product[] products = new product[names.length];
        for (int i = 0; i < products.length; i++) {
            products[i] = new product(names[i],amounts[i]);
        }
        return products;
    }

    public static final product[] calculateReceipt(final product[] array)
    {
        Map<String, Integer> products = new HashMap<String, Integer>();
        for (product item : array)
        {
            if (products.containsKey(item.getName()))
            {
                products.put(item.getName(), products.get(item.getName()) + item.getAmount());
            }
            else
            {
                products.put(item.getName(), item.getAmount());
            }
        }
        List<product> receipt = new ArrayList<product>();
        for(Map.Entry<String,Integer> entry : products.entrySet())
        {
            receipt.add(new product(entry.getKey(),entry.getValue()));
        }
        receipt.sort(Comparator.comparing(product::getName));
        return receipt.toArray(new product[receipt.size()]);
    }
}
