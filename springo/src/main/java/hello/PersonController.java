package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
//	@RequestMapping("/create")
	@ResponseBody
	public String create(String firstName, String lastName) {
		Person person = null;
		try {
			person = new Person(firstName, lastName);
			personRepository.save(person);
		} catch (Exception ex) {
			return "Error creating the person: " + ex.toString();
		}
		return "Person succesfully created! (nome = " + person.getFirstName() + ")";
	}

//	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Person person = new Person(id);
			personRepository.delete(person);
		} catch (Exception ex) {
			return "Error deleting the person: " + ex.toString();
		}
		return "Person succesfully deleted!";
	}
	
//	@RequestMapping("/update")
	@ResponseBody
	public String update(long id, String firstName, String lastName) {
		try {
			Person person = new Person(id, firstName, lastName);
			personRepository.save(person);
		} catch (Exception ex) {
			return "Error updating the person: " + ex.toString();
		}
		return "Person succesfully updated!";
	}
}
