/**
 * 
 */
package csci4380.finalp.dogs.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author berna
 *
 */
@Document(collection = "Dogs")
public class Dog {
	@Id
	private String id;
	private Integer petId;
	@Indexed(direction=IndexDirection.ASCENDING)
	private String name;
	private String type;
	private String ownerName;
	private String address;
	private Integer age;
	private Boolean isSpayed;
	private String birthdate;
	
	
	
	
	public Dog() {
		super();
	}




	public Dog(Integer petId, String name, String type, String ownerName, String address, Integer age, Boolean isSpayed,
			String birthdate) {
		super();
		this.petId = petId;
		this.name = name;
		this.type = type;
		this.ownerName = ownerName;
		this.address = address;
		this.age = age;
		this.isSpayed = isSpayed;
		this.birthdate = birthdate;
	}
	public void setId(String id) {
		this.id = id;
	}




	public void setPetId(Integer petId) {
		this.petId = petId;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void setType(String type) {
		this.type = type;
	}




	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public void setAge(Integer age) {
		this.age = age;
	}




	public void setIsSpayed(Boolean isSpayed) {
		this.isSpayed = isSpayed;
	}




	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}




	public String getId() {
		return id;
	}




	public Integer getPetId() {
		return petId;
	}




	public String getName() {
		return name;
	}




	public String getType() {
		return type;
	}




	public String getOwnerName() {
		return ownerName;
	}




	public String getAddress() {
		return address;
	}




	public Integer getAge() {
		return age;
	}




	public Boolean getIsSpayed() {
		return isSpayed;
	}




	public String getBirthdate() {
		return birthdate;
	}




	









	

}
