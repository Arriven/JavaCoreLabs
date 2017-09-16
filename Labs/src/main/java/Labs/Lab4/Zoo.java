package Labs.Lab4;

import java.util.ArrayList;
import java.util.List;

public class Zoo
{
    private List<Cage> cages;
    public Zoo()
    {
        cages = new ArrayList<>();
    }
    public final int GetAmountOfAnimals()
    {
        return cages.stream().mapToInt(Cage::GetAmountOfAnimals).sum();
    }
    public void AddCage(Cage cage)
    {
        cages.add(cage);
    }

    public List<Cage> getCages() {
        return cages;
    }
}
