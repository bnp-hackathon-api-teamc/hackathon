package com.bnpparibas.hackathon.parking.api.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parking")
public class Parking {

	private long id;
	private String building;
	private String name;
	private List<ParkingLot> parkingLot;
	
	public Parking() {}
	
	public Parking(String building, String name, List<ParkingLot> parkingLot) {
		this.building=building;
		this.name=name;
		this.parkingLot=parkingLot;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "building", nullable = false)
	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public List<ParkingLot> getParkingLot() {
		return parkingLot;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public List<ParkingLot> getAvailableParkingLot() {
		return parkingLot.stream()
				.filter(parkingLot1 -> parkingLot1.isAvailable())
				.collect(Collectors.toList());
	}

	public void setParkingLot(List<ParkingLot> parkingLot) {
		this.parkingLot = parkingLot;
	}

	@Override
	public String toString() {
		return "Building [id=" + id + ", building=" + building + ", name=" + name + ", parkingLot=" + parkingLot.toString()
				+ "]";
	}
	
}
