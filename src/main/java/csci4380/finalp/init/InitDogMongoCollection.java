/**
 * 
 */
package csci4380.finalp.init;

import java.util.Arrays;
import java.util.List;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import csci4380.finalp.dogs.mongodb.model.Dog;
import csci4380.finalp.dogs.mongodb.repo.DogRepository;
;

/**
 * @author berna
 *
 */
@Component
public class InitDogMongoCollection implements CommandLineRunner {

	private DogRepository dogRepository;
	
	
	public InitDogMongoCollection(DogRepository dogRepository) {
		this.dogRepository = dogRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		Dog d1 = new Dog(1, "ilker", "tabby", "John", "84 Jones Street", 7, false, "2/4/2011");
		Dog d2 = new Dog(2, "Khaleel", "tabby", "John", "276 Able Street", 10, true, "10/4/2007");
		Dog d3 = new Dog(3, "Bobby", "siamese", "John", "84 Jones Street", 8, false, "3/6/2010");
		Dog d4 = new Dog(4, "Keke", "black", "Hiram", "94 Juniper Avenue", 7, true, "2/4/2011");
		Dog d5 = new Dog(5, "David", "lynx", "Bernard", "276 Able Street", 10, true, "10/4/2007");
		Dog d6 = new Dog(6, "Goku", "tabby", "Rolf", "500 Rivervale Drive", 5, false, "3/6/2013");
		Dog d7 = new Dog(7, "Lucy", "Persian", "Samantha", "39 Hackensack Street", 6, true, "4/15/2012");
		
		List<Dog> dogs = Arrays.asList(d1,d2,d3,d4,d5,d6,d7);
		
		dogRepository.saveAll(dogs);
		System.out.println("---->PRINTED Dogs d1-d7");
	}

}
