package com.management.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.management.customer.entity.Customer;
import com.management.customer.service.ICustomerService;

@Controller
@RequestMapping ("/Customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping (method = RequestMethod.POST, path="/add-customer")
	public String add(@RequestParam ("id") Integer id, @RequestParam ("firstName") String firstname, @RequestParam ("lastName") String lastname, @RequestParam ("email") String email) {
		Customer customer = new Customer(firstname, lastname, email);
		customerService.addCustomer(customer);
		return "redirect:show-customers";
	}

	@RequestMapping (method = RequestMethod.GET, path="/show-customers")
	public ModelAndView display(ModelAndView mav) {
		List <Customer> customers= customerService.displayCustomer();
		if (customers.isEmpty()==true) {
			mav.setViewName("empty-customer-info");
			return mav;
		}
		else {
			mav.setViewName("customer-info");
			mav.addObject("customerInfo",customers);
			return mav;
		}		
	}

	@RequestMapping (method = RequestMethod.GET,path = "/show-form")
	public String showCustomerForm() {
		return "customer-form";		
	}

	@RequestMapping(method = RequestMethod.GET, path = "/delete-customer")
	public String delete(@RequestParam("id") Integer id) {
		System.out.println("method called with id is: " + id);
		if (customerService.deleteCustomer(id)) {
			System.out.println("Customer deleted");
		} else {
			System.out.println("Customer not deleted");
		}

		return "redirect:show-customers";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/update-customer")
	public String update(@RequestParam("id") Integer id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email) {
		System.out.println("Update method is called on id: " + id);
		if (customerService.updateCustomer(id, firstName, lastName, email)) {
			System.out.println("Customer detail updated");
		} else {
			System.out.println("Customer detail not updated");
		}

		return "redirect:show-customers";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/open-update-form")
	public ModelAndView updateForm(@RequestParam("id") Integer id, ModelAndView mav) {
		Customer customer = customerService.findCustomer(id);
		if(customer != null) {
			mav.setViewName("update-customer-form");
			mav.addObject("customerInfo", customer);
			return mav;
		} else {
			mav.setViewName("customer-not-found");
			return mav;
		}
	}
}
