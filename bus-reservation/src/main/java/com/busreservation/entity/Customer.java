package com.busreservation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.transaction.Transactional;

import bus.busreservation.constant.Role;
import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Table(name="customer")
@Entity
@Getter
@Setter
@ToString
public class Customer {
	
	private Long customer_id;	//고객 아이디
	
	private Bus bus_id;	//버스 아이디
	
	private String customer_name;	//고객 이름
	
	private String customer_password;	//고객 비밀번호
	
	private int customer_number;	//고객 전화번호
	
	private Role role;	//계정 판정 (user, admin)
	
}
