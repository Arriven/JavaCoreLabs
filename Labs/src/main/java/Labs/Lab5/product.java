package Labs.Lab5;


public class product
{
    private String name;
    private int amount;
    public product(String name, int amount)
    {
        this.name = name;
        this.amount = amount;
    }
    public final String getName()
    {
        return this.name;
    }
    public final int getAmount()
    {
        return this.amount;
    }
    @Override
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        if (other == this)
        {
            return true;
        }
        if(!(other instanceof product))
        {
            return false;
        }
        return this.name.equals(((product) other).name) &&
                this.amount == ((product) other).amount;
    }
}
