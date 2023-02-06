package com.busreservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import com.busreservation.constant.Role;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Table(name="bus")
@Entity
@Getter
@Setter
@ToString
public class Bus {
	
	@Id
	@Column(name = "bus_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bus_id;	//버스 아이디
	
	@Column(name = "bus_kind")
	private String bus_kind;	//버스 종류(버스 회사 종류)
	
	@Column(name = "bus_total_seat")
	private int bus_total_seat;	//버스 총 좌석

}
