package com.example.JayminPatel_ORMandSpringMVCAssignmentSolution.controllers;

import com.example.JayminPatel_ORMandSpringMVCAssignmentSolution.entities.Customer;
import com.example.JayminPatel_ORMandSpringMVCAssignmentSolution.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public String home(Model model) {
        List<Customer> list = customerRepository.findAll();
        model.addAttribute("customers", list);
        return "index";
    }

    @GetMapping("/add")
    public String add_form() {
        return "add";
    }

    @GetMapping("/edit/{id}")
    public String edit_form(@PathVariable(value = "id") long id, Model model) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        Customer customer = customerOptional.get();
        model.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer, HttpSession session) {
        customerRepository.save(customer);
        session.setAttribute("msg", "Customer added successfully...");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer, HttpSession session) {
        customerRepository.save(customer);
        session.setAttribute("msg", "Customer updated successfully...");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id, HttpSession session) {
        customerRepository.deleteById(id);
        session.setAttribute("msg", "Customer deleted successfully...");
        return "redirect:/";
    }
}
