package com.ships.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.ShippingCompany;
import com.ships.repositories.ShippingCompanyInterface;

@Service
public class ShippingCompanyService {
	
	@Autowired
	private ShippingCompanyInterface shipInterface;
	
	public ArrayList<ShippingCompany> getCompany(){
		
		return (ArrayList<ShippingCompany>) shipInterface.findAll();	
	}
}
