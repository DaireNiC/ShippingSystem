package com.ships.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.OrderInfoService;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;
@ControllerAdvice
@Controller
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private ShipService shipService;
	@Autowired
	private ShippingCompanyService shipCompService;

	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String getShips(Model m){

		ArrayList<OrderInfo> ordersInfo = orderInfoService.getOrders();
		m.addAttribute("ordersInfo", ordersInfo);

		return "displayOrdersInfo";
	}

	@RequestMapping(value = "/createOrder", method=RequestMethod.GET)
	public String addShipGET(Model model) {
		// Get List of All Countries
		ArrayList<Ship> ship = (ArrayList<Ship>) shipService.getShip();		
		// Create List of Countries
		Map<Long,String> shipList = new HashMap<Long,String>();
		for (Ship c : ship) {
			if(c.getShippingCompany() == null) {
				shipList.put((long) c.getSid(), c.getName() + ";" + " Cost= " + c.getCost());
			}
		}

		model.addAttribute("shipList", shipList);

		// Get List of All Countries
		ArrayList<ShippingCompany> companies = (ArrayList<ShippingCompany>) shipCompService.getCompany();		
		// Create List of Countries
		Map<Long,String> compList = new HashMap<Long,String>();

		for (ShippingCompany c : companies) {
			compList.put((long) c.getScid(), c.getName() + ";" + " Balance= " +c.getBalance());
		}

		model.addAttribute("compList", compList);

		OrderInfo order = new OrderInfo();
		model.addAttribute("order", order);

		return "createOrder";
	}

	@RequestMapping(value = "/createOrder", method=RequestMethod.POST)
	public String addShipPOST(@Valid @ModelAttribute("order") OrderInfo order, BindingResult result) {
		if(result.hasErrors()) {			
			return "createOrder";
		}
		else{
			orderInfoService.save(order);
			return "redirect:showOrders";
		}
	}
	//handles roll back exceptions 
	@ExceptionHandler(value = RollbackException.class)
	public String handleErr() {
		
		return "Error";
		
	}
	//handles null pointers 
	@ExceptionHandler(value = NullPointerException.class)
	public String handleError(HttpServletRequest req, Exception e) {

		return "ErrorPageForOrder";
	}
	
}
