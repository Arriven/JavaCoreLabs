package Labs.Lab2;

public class person
{
    public String name;
    public int age;
    public int weight;
    public int height;
    public person(String name, int age, int weight, int height)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
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
        if(!(other instanceof person))
        {
            return false;
        }
        return this.name.equals(((person) other).name) &&
                this.age == ((person) other).age &&
                this.height == ((person) other).height &&
                this.weight == ((person) other).weight;
    }
}
