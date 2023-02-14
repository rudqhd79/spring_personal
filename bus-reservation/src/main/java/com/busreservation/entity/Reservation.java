package com.busreservation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@Id
	@Column(name = "res_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long res_id;	//예약 아이디
	
	@JoinColumn(name = "customer_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Customer customer_id;	//고객 아이디
	
	@JoinColumn(name = "bus_id")
	@OneToMany(fetch = FetchType.LAZY)
	private List<Bus> bus_id = new ArrayList<>();	//버스 아이디
	
	@JoinColumn(name = "seat_id")
	@OneToMany(fetch = FetchType.LAZY)
	private List<Seat> seat = new ArrayList<>();
	
	@Column(name = "res_people")
	private int res_people;	//예약 인원
	
	@Column(name = "res_price")
	private int res_price;	//예약 금액
	
	@Column(name = "res_seat_no")
	private int res_seat_no;
	
}
