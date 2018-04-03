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
	
	//this method gets all the ships from the database
	public ArrayList<Ship> getShip(){
		
		return (ArrayList<Ship>) shipInterface.findAll();	
	}
	
	//here this method will save the new ship details
	public Ship save(Ship ship) {

		//Passes ship object
		//to be saved by the shipInterface
		return shipInterface.save(ship);
	}
}
