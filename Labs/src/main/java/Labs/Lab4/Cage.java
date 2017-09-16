package Labs.Lab4;

import Labs.Lab4.Animals.Animal;

import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Cage<T extends Animal>
{
    private List<Animal> animals;
    private final Class<T> animalType;
    private int maxAmount;
    public Cage(final int maxAmount, Class<T> tClass)
    {
        this.animals = new ArrayList<>();
        this.maxAmount = maxAmount;
        this.animalType = tClass;
    }

    public void AddAnimal(T animal) throws OutOfMemoryError, InvalidParameterException
    {
        if(!animalType.isAssignableFrom(animal.getClass()))
        {
            throw new InvalidParameterException("Wrong animal provided");
        }
        if(animals.size() == maxAmount)
        {
            throw new OutOfMemoryError("No more place");
        }
        animals.add(animal);
    }

    public void RemoveAnimal(T animal) throws InvalidKeyException, InvalidParameterException
    {
        if(!animals.contains(animal))
        {
            throw new InvalidKeyException("Cage has no such animal");
        }
        animals.remove(animal);
    }

    public final int GetAmountOfAnimals()
    {
        return animals.size();
    }

    public Class<T> GetAnimalType() {
        return animalType;
    }
}
