package com.busreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.busreservation.entity.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	//myshop에서 item을 참조하여 작성한다
	
	//insert into select로 select에 포함된 값들을 reservation에 넣어준다
	
}
