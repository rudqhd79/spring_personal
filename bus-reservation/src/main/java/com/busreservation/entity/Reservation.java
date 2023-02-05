package com.busreservation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Table(name="reservation")
@Entity
@Getter
@Setter
@ToString
public class Reservation {

	private Long res_id;	//예약 아이디
	
	private Customer customer_id;	//고객 아이디
	
	private Bus bus_id;	//버스 아이디
	
	private int res_people;	//예약 인원
	
	private int res_price;	//예약 금액
	
}
