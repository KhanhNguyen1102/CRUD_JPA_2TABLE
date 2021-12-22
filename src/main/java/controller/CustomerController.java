package controller;

import model.Customer;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.customer.ICustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView creat(Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        return modelAndView;
    }
}
