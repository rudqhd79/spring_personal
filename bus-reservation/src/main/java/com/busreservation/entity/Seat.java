package com.busreservation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
@Table(name = "bus_seat")
@Entity
public class Seat {

	@Id
	@Column(name = "seat_id")
	private Long seat_id;	//좌석 아이디
	
	@JoinColumn(name = "bus_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Bus bus; 	//버스 아이디
	
	public void updateSeat (Long seat_id) {
		this.seat_id = seat_id;
	}

}
