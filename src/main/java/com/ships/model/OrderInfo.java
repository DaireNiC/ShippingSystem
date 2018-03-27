package com.ships.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderInfo {
	
	@Id
	@GeneratedValue
	private int oid;
	@ManyToOne
	@JoinColumn(name="scid")
	private ShippingCompany shippingCompany;
	@OneToOne
	@JoinColumn(name="sid")
	private Ship ship;
	private String date;

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public ShippingCompany getShippingCompany() {
		return shippingCompany;
	}
	public void setShippingCompany(ShippingCompany shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "OrderInfo [oid=" + oid + ", shippingCompany=" + shippingCompany + ", ship=" + ship + ", date=" + date
				+ "]";
	}
}
