package Labs;

import Labs.Lab4.Animals.Animal;
import Labs.Lab4.Animals.Bird;
import Labs.Lab4.Animals.Predator;
import Labs.Lab4.Cage;
import Labs.Lab4.Animals.Mammal;
import org.junit.Test;

import java.security.InvalidKeyException;
import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ZooTest
{
    @Test
    public void simpleTest()
    {
        Cage cage = new Cage<>(2, Animal.class);
        cage.AddAnimal(new Mammal());
    }

    @Test
    public void invalidAnimalTest()
    {
        Cage cage = new Cage(2, Mammal.class);
        cage.AddAnimal(new Predator());
        assertThatThrownBy(()->cage.AddAnimal(new Animal())).isInstanceOf(InvalidParameterException.class);
        assertThatThrownBy(()->cage.AddAnimal(new Bird())).isInstanceOf(InvalidParameterException.class);
    }

    @Test
    public void erasionOfMissingAnimalTest()
    {
        Cage cage = new Cage(2, Mammal.class);
        cage.AddAnimal(new Predator());
        assertThatThrownBy(()->cage.RemoveAnimal(new Predator())).isInstanceOf(InvalidKeyException.class);
    }

    @Test
    public void tooMuchAnimalsTest()
    {
        Cage cage = new Cage(2, Mammal.class);
        cage.AddAnimal(new Predator());
        cage.AddAnimal(new Mammal());
        assertThatThrownBy(()->cage.AddAnimal(new Predator())).isInstanceOf(OutOfMemoryError.class);
    }
}
