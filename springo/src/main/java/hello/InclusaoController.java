package hello;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InclusaoController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/inclusao")
    public ModelAndView add(Person person) {
         
        ModelAndView mv = new ModelAndView();
        mv.addObject("person", person);
         
        return mv;
    }
	
	@GetMapping("/")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/listagem");
        mv.addObject("people", personService.findAll());
         
        return mv;
    }
	
	@PostMapping("/incluir")
	public ModelAndView incluir(@Valid Person person) {
		personService.save(person);
		return findAll();
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		personService.delete(id);
		return findAll();
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(personService.findOne(id));
	}

}
