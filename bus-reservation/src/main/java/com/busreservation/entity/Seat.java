package com.busreservation.entity;

import javax.persistence.Entity;
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

	private Long seat_id;	//좌석 아이디
	
	private Bus bus_id;	//버스 아이디
	
	private int seat_no;	//좌석 번호
	
}
