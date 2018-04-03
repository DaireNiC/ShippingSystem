package com.ships.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipInterface;

@Service
public class ShipService {
	
	@Autowired
	private ShipInterface shipInterface;
	
	public ArrayList<Ship> getShip(){
		
		return (ArrayList<Ship>) shipInterface.findAll();	
	}
	
}
