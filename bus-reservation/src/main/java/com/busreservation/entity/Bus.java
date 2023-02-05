package com.busreservation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import bus.busreservation.constant.Role;
import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Table(name="bus")
@Entity
@Getter
@Setter
@ToString
public class Bus {
	
	private Long bus_id;	//버스 아이디
	
	private String bus_kind;	//버스 종류(버스 회사 종류)
	
	private int bus_total_seat;	//버스 총 좌석

}
