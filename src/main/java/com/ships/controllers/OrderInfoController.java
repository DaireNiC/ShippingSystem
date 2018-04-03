package com.ships.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.services.OrderInfoService;
import com.ships.services.ShipService;

@Controller
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private ShipService shipService;

	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String getShips(Model m){

		ArrayList<OrderInfo> ordersInfo = orderInfoService.getOrders();
		m.addAttribute("ordersInfo", ordersInfo);

		return "displayOrdersInfo";
	}

	// this is the get request which directs to the create order page
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String getAddShip(Model m, @ModelAttribute("order") OrderInfo order, HttpServletRequest h) {

		ArrayList<Ship> ordersInfo = shipService.getShipWithoutCompany();
		
		ArrayList<Ship> orders = new ArrayList<Ship>();
		
		for (Ship ship : ordersInfo) {
			System.out.println(ship.getShippingCompany());
			if(ship.getShippingCompany() == null) {
				orders.add(ship);
			}
		}
		m.addAttribute("countryList", orders);
		
		return "createOrder";
	}
}
