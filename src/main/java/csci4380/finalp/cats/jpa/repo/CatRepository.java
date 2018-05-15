/**
 * 
 */
package csci4380.finalp.cats.jpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import csci4380.finalp.cats.jpa.model.Cat;



/**
 * @author berna
 *
 */
public interface CatRepository extends JpaRepository<Cat, Integer> {
	
	public Optional<Cat> findByNameOrOwnerName(String name, String ownerName);  //public  findByNameOrOwnerName(String name, String ownerName);// Query Method
	
	@Query("SELECT c FROM CAT c WHERE c.lower(c.type) = lower(:type)") //Native Query Method
	public Cat findByTypeIgnoreCase(@Param("type") String type);
	
}
