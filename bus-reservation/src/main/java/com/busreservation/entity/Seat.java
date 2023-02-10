package com.busreservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seat_id;	//좌석 아이디
	
	@JoinColumn(name = "bus_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Bus bus_id;	//버스 아이디
	
	@Column(name = "seat_no")
	private int seat_no;	//좌석 번호
	
	
}
