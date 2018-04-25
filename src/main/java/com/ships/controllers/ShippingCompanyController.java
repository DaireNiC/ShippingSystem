package com.ships.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.ShippingCompanyService;

@Controller
public class ShippingCompanyController {

	@Autowired
	private ShippingCompanyService shipCompService;

	@RequestMapping(value = "/showShippingCompanies", method=RequestMethod.GET)
	public String getShipsCompanies(Model m){

		ArrayList<ShippingCompany> shippingCompany = shipCompService.getCompany();
		m.addAttribute("shippingCompany", shippingCompany);

		return "displayShippingCompany";
	}

	// this is the get request which directs to the add company page
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String getAddShippingCompany(@ModelAttribute("shipC") ShippingCompany shipC) {

		return "addShippingCompany";
	}

	// This is the post request which saves the shipping company object 
	// then displays the new data on the display page 
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public String postShippingCompanies(@Valid @ModelAttribute("shipC") ShippingCompany shipC,BindingResult result,Model m) {

		if(result.hasErrors()) {			
			return "addShippingCompany";
		}else{
			// Pass the customer to the Customer Service for saving
			shipCompService.save(shipC);

			// this gets all the ships even the new one and then puts it into a arraylist
			ArrayList<ShippingCompany> shippingCompany = shipCompService.getCompany();

			// this adds the Array-list objects to the ships attribute 
			m.addAttribute("shippingCompany", shippingCompany);

			return "displayShippingCompany";
		}
	}
}
