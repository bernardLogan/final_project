/**
 * 
 */
package csci4380.finalp.cats.rest;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.cats.jpa.repo.CatRepository;



/**
 * @author berna
 *
 */
@RestController
@RequestMapping("rest/v1/cats")
public class CatRestController {
	
	@Autowired CatRepository catRepository;
	
	@RequestMapping("/echoMessage")
	@ResponseBody
	public String echoMessage(@RequestParam(value="msg", defaultValue="Bernard") String message) {
		return "echoMessage echoes: " + message;
	}
	
	
	@GetMapping("")
	public Page<Cat> findAll(@RequestParam(defaultValue="0") int page, @RequestParam(value="rowsPerPage", defaultValue="3") int size) {
		Page<Cat> catsPage = catRepository.findAll(new PageRequest(page, size));
		return catsPage;
	}

	
	@GetMapping("/all")
	public List <Cat> findAll(){
		List <Cat> cats = catRepository.findAll();
		return cats;
	}
	
	@GetMapping("/petId/{petId}")
	public  Optional<Cat> findById(@PathVariable Integer petId) {
		//Optional<Cat> cat = catRepository.findById(id);
		// cat;
		return this.catRepository.findById(petId);
		
	}
	
	@GetMapping("/byNameOrOwnerName/{name}/{ownerName}")
	public Optional<Cat>findByNameOrOwnerName(String name, String ownerName)
	{
		return this.catRepository.findByNameOrOwnerName(name, ownerName);
	}
	
	@GetMapping("/byTypeIgnoreCase/{type}")
	public Cat findByTypeIgnoreCase(@PathVariable String type)
	{
	  Cat cat = catRepository.findByTypeIgnoreCase(type);
	  return cat;
     
		
	}
	
	@PostMapping("")
	public  Optional<Cat> save(@RequestBody final Cat cat) {
		Cat savedCat = catRepository.save(cat);
		return catRepository.findById(savedCat.getPetId());
	}
	
	@PutMapping("/petId/{petId}")
	public ResponseEntity<Object> update(@RequestBody Cat cat, Integer petId)
	{
		Optional<Cat> catOptional = catRepository.findById(petId);
	
		cat.setPetId(petId);
		catRepository.save(cat);
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/petId/{petId}")
	public void deleteById(@PathVariable Integer petId)
	{
		catRepository.deleteById(petId);
	}
	
	
	
	

}
