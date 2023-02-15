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
import javax.persistence.ManyToOne;
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
	@Column(name = "reservation_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	//예약 아이디
	
	@JoinColumn(name = "customer_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;	//고객 아이디
	
	@JoinColumn(name = "bus_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Bus bus;	//버스 아이디
	
	private int reservationPeople;	//예약 인원
	
	private int reservationPrice;	//예약 금액
	
}
