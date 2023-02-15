package com.busreservation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.busreservation.constant.Role;
import com.busreservation.dto.CustomerFormDto;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Table(
		name="customer",
		uniqueConstraints = {
				@UniqueConstraint (
						columnNames= {"email", "customerNumber"}
		)
	}
)
@Entity
@Getter
@Setter
@ToString
public class Customer {
	
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	//고객 아이디
	
	@Column(name = "email")
	private String email;
	
	private String customerName;	//고객 이름
	
	private String customerPassword;	//고객 비밀번호

	private String customerNumber;	//고객 전화번호
	
	@Enumerated(EnumType.STRING)
	private Role role;	//계정 판정 (user, admin)
	
	public static Customer createCustomer(CustomerFormDto customerFormDto, PasswordEncoder passwordEncoder) {
		Customer customer = new Customer();
		customer.setCustomerName(customerFormDto.getCustomerName());
		customer.setEmail(customerFormDto.getEmail());
		customer.setCustomerNumber(customerFormDto.getCustomerNumber());
		
		String password = passwordEncoder.encode(customerFormDto.getCustomerPassword()); //비밀번호 암호화
		customer.setCustomerPassword(password);
		
		customer.setRole(Role.USER);
		
		return customer;
	}
	
}
