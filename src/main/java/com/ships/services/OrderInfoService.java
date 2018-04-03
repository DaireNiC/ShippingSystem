package com.ships.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.repositories.OrderInfoInterface;
import com.ships.repositories.ShipInterface;

@Service
public class OrderInfoService {
	
	@Autowired
	private OrderInfoInterface orderInfoInterface;
	@Autowired
	private ShipInterface shipInfoInterface;
	
	public ArrayList<OrderInfo> getOrders(){
		
		return (ArrayList<OrderInfo>) orderInfoInterface.findAll();	
	}

}
