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
import com.ships.services.ShipService;

@Controller
public class ShipController {
	
	@Autowired
	private ShipService shipService;
	
	//display ships 
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String getShips(Model m){
		
		ArrayList<Ship> ships = shipService.getShip();
		
		m.addAttribute("ships", ships);
		
		return "displayships";
	}
	
	//add ship
	// Get the page
	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public String getProduct(@ModelAttribute("ship") Ship ship, HttpServletRequest h) {
		
		return "addShip";
	}

}
