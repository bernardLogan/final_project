/**
 * 
 */
package csci4380.finalp.dogs.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import csci4380.finalp.dogs.mongodb.model.Dog;
import csci4380.finalp.dogs.mongodb.repo.DogRepository;



/**
 * @author berna
 *
 */
@RestController
@RequestMapping("rest/v1/dogs")
public class DogRestController {
private DogRepository dogRepository;



public DogRestController(DogRepository dogRepository) {
	this.dogRepository = dogRepository;
}


@GetMapping("/echoMessage")
public String echoMessage(@RequestParam(value="msg", defaultValue="Hi Bernard") String message) {
	return "echoMessage echoes: " + message;
}


@GetMapping("")
public Page<Dog> findAll(@RequestParam(defaultValue="0") int page, @RequestParam(value="rowsPerPage", defaultValue="3") int size) {
	Page<Dog> dogsPage = dogRepository.findAll(new PageRequest(page, size));
	return dogsPage;
}

@GetMapping("/all")
public  List<Dog> findAll() {
	List<Dog> dogs = dogRepository.findAll();
	return dogs;
}

@GetMapping("/{id}")
public  Optional<Dog> findById(@PathVariable String id) {
	Optional<Dog> dog = dogRepository.findById(id);
	return dog;
}
//curl -i http://localhost:8888/rest/v1/dogs/petId/1
@GetMapping("/petId/{petId}")
public  Optional<List<Dog>> findByDogId(@PathVariable Integer petId) {
	Optional<List<Dog>> dogs = dogRepository.findByPetId(petId);
	return dogs;
}

@PutMapping("")
public  Dog insert(@RequestBody final Dog dog) {
	Dog insertedDog = dogRepository.insert(dog);
	return insertedDog;
}

@PostMapping("")
public  Optional<Dog> save(@RequestBody final Dog dog) {
	Dog savedDog = dogRepository.save(dog);
	return dogRepository.findById(savedDog.getId());
}

@DeleteMapping("/{id}")
public  void delete(@PathVariable("id") String id) {
	dogRepository.deleteById(id);
}

@DeleteMapping("/petId/{petId}")
public  void deleteBypetId(@PathVariable String petId) {
	dogRepository.deleteByPetId(petId);
}

@GetMapping("/byNameOrOwnerName/{name}/{ownerName}")
public Dog findByOwnerNameOrName(String name, String ownerName)
{
	Dog dog = dogRepository.findByNameOrOwnerName(name, ownerName);
	return dog;
}

@GetMapping("/byTypeIgnoreCase/{type}")
public Dog findByTypeIgnoreCase(@PathVariable String type)
{
  Dog dog = dogRepository.findByTypeIgnoreCase(type);
  return dog;
 
	
}

}
