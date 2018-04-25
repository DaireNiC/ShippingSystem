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
import com.ships.services.ShipService;

@Controller
public class ShipController {

	@Autowired
	private ShipService shipService;

	//display ships 
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String getShips(Model m){

		ArrayList<Ship> ships = (ArrayList<Ship>) shipService.getShip();

		m.addAttribute("ships", ships);

		return "displayships";
	}

	//add ship
	// this is the get request which directs to the add ship page
	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public String getAddShip(@ModelAttribute("ship") Ship ship, HttpServletRequest h) {

		return "addShip";
	}

	// This is the post request which saves the ship object 
	// then displays the new data on the display page 
	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
	public String postShip(@Valid @ModelAttribute("ship") Ship ship,BindingResult result) {

		if(result.hasFieldErrors()) {			
			return "addShip";
		}else{
			// Pass the customer to the Customer Service for saving
			shipService.save(ship);
			return "redirect:showShips";
		}
		
	}

}
