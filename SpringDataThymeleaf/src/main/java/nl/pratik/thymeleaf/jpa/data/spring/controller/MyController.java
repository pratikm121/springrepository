package nl.pratik.thymeleaf.jpa.data.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nl.pratik.thymeleaf.jpa.data.spring.dao.CustomerJPARepository;
import nl.pratik.thymeleaf.jpa.data.spring.model.Customer;

@Controller
@RequestMapping("/customer")
public class MyController {
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Autowired
	private CustomerJPARepository myrepo;
	
	@GetMapping("/list")
	public String welcome(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute("customers", myrepo.findAllByOrderByFirstNameAsc());
		System.out.println("List = "+ myrepo.findAllByOrderByFirstNameAsc().size());
		return "welcome";
	}
	
	@GetMapping("/showCustomerForm")
	public String showCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		System.out.println("Got the call");
		return "customer/addCustomerForm";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println("Customer = " + customer.toString());
		myrepo.save(customer);
		System.out.println("Saved the customer");
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showCustomerFormForUpdate")
	public String showCustomerFormForUpdate(@RequestParam("customerId") int customerId, Model model) {
		Optional<Customer> customerData = myrepo.findById(customerId);
		model.addAttribute("customer", customerData);
		System.out.println("Got the update ");
		return "customer/addCustomerForm";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int customerId, Model model) {
		myrepo.deleteById(customerId);
		System.out.println("Deleted the customer");
		return "redirect:/customer/list";
	}

}
