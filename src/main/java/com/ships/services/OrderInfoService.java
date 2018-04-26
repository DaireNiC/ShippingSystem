package com.ships.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.OrderInfoInterface;
import com.ships.repositories.ShipInterface;
import com.ships.repositories.ShippingCompanyInterface;

@Service
public class OrderInfoService {

	//theses are the interfaces
	@Autowired
	private OrderInfoInterface orderInfoInterface;

	@Autowired
	private ShippingCompanyInterface SC;

	@Autowired
	private ShipInterface SI;

	//these are the models 
	private Ship ship;
	private ShippingCompany shipC;

	//get the current date 
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();

	// this gets all the orders from mysql
	public ArrayList<OrderInfo> getOrders(){
		return (ArrayList<OrderInfo>) orderInfoInterface.findAll();	
	}
	
	public OrderInfo save(OrderInfo order) {
		//this sets the date as the current date in the database
		order.setDate(dateFormat.format(date));	
		//search the ship and shipping company from the ids 
		ship =SI.findOne(order.getShip().getSid());
		shipC = SC.findOne(order.getShippingCompany().getScid());
		
		//set the ship scid value to the shipc scid gotten from select  
		ship.setShippingCompany(shipC);
		//update the balance of the shipping company to the 
		//new balance = old balance - cost of the ship 
		shipC.setBalance(shipC.getBalance().subtract(ship.getCost()));
		
		//save the changes made 
		return orderInfoInterface.save(order);
	}
}
