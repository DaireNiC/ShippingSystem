package com.ships.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
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
}
