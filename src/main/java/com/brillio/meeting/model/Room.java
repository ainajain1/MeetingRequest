package com.brillio.meeting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue
	int id;

	@Column(name = "name")
	String name;

	@Column(name = "type")
	MeetingType type;

	@ManyToOne
	@JoinColumn(name = "floor_id", nullable = false)
	Floor floor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MeetingType getType() {
		return type;
	}

	public void setType(MeetingType type) {
		this.type = type;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public String getRoomDetail() {
		return "Building: " + floor.getBuilding().getName() + " Floor: " + floor.getId() + " Room ID & Name: " + name
				+ " " + id;
	}

}
