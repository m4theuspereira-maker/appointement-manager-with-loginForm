package com.webencyclop.demo.controller;

import javax.validation.Valid;

import com.webencyclop.demo.model.User;
import com.webencyclop.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AuthenticationController {

    @Autowired
    UserService userService; 


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView(); 
        
        modelAndView.setViewName("login");
        return modelAndView; 
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView(); 
        User user = new User(); 
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView; 
    }    
  

    @RequestMapping(value = "/register", method= RequestMethod.POST)
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
            ModelAndView modelAndView = new ModelAndView();

            if(bindingResult.hasErrors()){
                modelAndView.addObject("successMessage", "Please correct the erros in form");
                modelMap.addAttribute("bindingResult", bindingResult);
            }else if(userService.isUserAlreadyPresent(user)) {
                modelAndView.addObject("successMessage", "user already exists!"); 
            }else {
                userService.saveUser(user);
                modelAndView.addObject("sucessMessage", "User is registered successfully!");
            }
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("register");
        return modelAndView;
    }    
}