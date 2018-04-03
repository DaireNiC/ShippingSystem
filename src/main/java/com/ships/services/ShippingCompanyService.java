package com.ships.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.ShippingCompanyInterface;

@Service
public class ShippingCompanyService {

	@Autowired
	private ShippingCompanyInterface shipCompInterface;

	//this method gets all the shipping companies from the database
	public ArrayList<ShippingCompany> getCompany(){

		return (ArrayList<ShippingCompany>) shipCompInterface.findAll();	
	}

	//here this method will save the new ship details
	public ShippingCompany save(ShippingCompany shipC) {

		//Passes shipping Company object
		//to be saved by the shipCompInterface
		return shipCompInterface.save(shipC);
	}
}
