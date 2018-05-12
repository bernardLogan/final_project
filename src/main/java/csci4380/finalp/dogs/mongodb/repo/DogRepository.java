/**
 * 
 */
package csci4380.finalp.dogs.mongodb.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.dogs.mongodb.model.Dog;

/**
 * @author berna
 *
 */
public interface DogRepository extends MongoRepository<Dog, String> {
public Optional<List<Dog>> findByPetId(Integer petId);
public Dog findByNameOrOwnerName(String name, String ownerName);
@Query("{'type': {$toLower $type}}") //Native Query Method
public Dog findByTypeIgnoreCase(@Param("type") String type);
public void deleteByPetId(String petId);


}
