/**
 * 
 */
package csci4380.finalp.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.cats.jpa.repo.CatRepository;



/**
 * @author berna
 *
 */
@Component
public class InitCatDb implements CommandLineRunner {
	private CatRepository catRepository;


	@Autowired
	public InitCatDb(CatRepository catRepository) {
		super();
		this.catRepository = catRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		Cat catOne = new Cat("Felix", "Persian", "Billy", "17 Rest Way", 1,  true, "4/20/17");
		Cat savedCatOne = catRepository.save(catOne);
		System.out.println("-----> BERNARD ----> Saved catOne");
	}

}
