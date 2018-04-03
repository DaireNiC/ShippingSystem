package com.ships.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.ShippingCompanyService;

@Controller
public class ShippingCompanyController {

	@Autowired
	private ShippingCompanyService shipService;

	@RequestMapping(value = "/showShippingCompanies", method=RequestMethod.GET)
	public String getShips(Model m){

		ArrayList<ShippingCompany> shippingCompany = shipService.getCompany();
		m.addAttribute("shippingCompany", shippingCompany);

		return "displayShippingCompany";
	}

	// this is the get request which directs to the add company page
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String getAddShip(@ModelAttribute("ship") Ship ship, HttpServletRequest h) {

		return "addShippingCompany";
	}

}
