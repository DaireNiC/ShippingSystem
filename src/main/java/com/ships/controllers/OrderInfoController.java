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

@Controller
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;

	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String getShips(Model m){

		ArrayList<OrderInfo> ordersInfo = orderInfoService.getOrders();
		m.addAttribute("ordersInfo", ordersInfo);

		return "displayOrdersInfo";
	}

	// this is the get request which directs to the create order page
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String getAddShip(@ModelAttribute("order") OrderInfo order, HttpServletRequest h) {

		return "createOrder";
	}
}
