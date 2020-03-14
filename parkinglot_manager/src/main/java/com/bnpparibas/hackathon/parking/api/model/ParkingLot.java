package com.bnpparibas.hackathon.parking.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {
	
	private long id;
	private String aliasLotId;
	private int floor;
	private int width;
	private int height;
	private Parking parking;
	private boolean isAvailable;
	
	public ParkingLot() {}
	
	public ParkingLot(String aliasLotId, int floor, int width, int height, Parking parking, boolean isAvailable) {
		this.aliasLotId = aliasLotId;
		this.floor = floor;
		this.width = width;
		this.height = height;
		this.parking = parking;
		this.isAvailable = true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "alias_lot_id", nullable = false, unique=true)
	public String getLotId() {
		return aliasLotId;
	}

	public void setLotId(String aliasLotId) {
		this.aliasLotId = aliasLotId;
	}

	@Column(name = "floor", nullable = false)
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Column(name = "width", nullable = false)
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Column(name = "height", nullable = false)
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY,optional = false)
	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		isAvailable = available;
	}
}
