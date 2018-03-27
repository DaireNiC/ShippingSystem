package com.ships.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.services.ShipService;

@Controller
public class ShipController {
	
	
//	@Autowired
//	private CustomerService custS;
//	
//	
//// List Customers page -------------------------------------------------------------------------------------
//	
//	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
//	public String getCustomers(Model m) {
//
//		// Get all customers from customer service, same them to array
//		ArrayList<Customer> customers = custS.getAll();
//
//		// Add to customer model object
//		m.addAttribute("customers", customers);
//
//		return "showCustomers";
//	}
	
	@Autowired
	private ShipService shipService;
	
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String getShips(Model m){
		
		ArrayList<Ship> ships = shipService.getShip();
		m.addAttribute("ships", ships);
		
		return "displayships";
	}

}
