package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
     
    @Autowired
    private PersonRepository repository;
     
    public List<Person> findAll() {
        return repository.findAll();
    }
     
    public Person findOne(Long id) {
        return repository.findOne(id);
    }
     
    public Person save(Person person) {
        return repository.save(person);
    }
     
    public void delete(Long id) {
        repository.delete(id);
    }
}
