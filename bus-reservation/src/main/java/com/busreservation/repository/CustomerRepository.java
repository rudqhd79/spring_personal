package com.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busreservation.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByEmail(String email); //회원가입시 중복 회원이 있는지 검사하기 위해
}
