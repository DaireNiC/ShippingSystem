package com.ships.services;

import java.math.MathContext;
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

	@Autowired
	private OrderInfoInterface orderInfoInterface;

	@Autowired
	private ShippingCompanyInterface SC;

	@Autowired
	private ShipInterface SI;

	private Ship ship;
	private ShippingCompany shipC;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();

	public ArrayList<OrderInfo> getOrders(){

		return (ArrayList<OrderInfo>) orderInfoInterface.findAll();	
	}
	
	public OrderInfo save(OrderInfo order) {
		
		order.setDate(dateFormat.format(date));	
		ship =SI.findOne(order.getShip().getSid());
		shipC = SC.findOne(order.getShippingCompany().getScid());
		
		ship.setShippingCompany(shipC);

		shipC.setBalance(shipC.getBalance().subtract(ship.getCost()));
		
		return orderInfoInterface.save(order);
	}

}
