package com.busreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.busreservation.entity.BusSeat;

public interface BusSeatRepository extends JpaRepository<BusSeat, Long> {

	//선택된 좌석들을 list로 담아준다
	/*
	@Query(value = "select s from Seat s where seat_id = :seat_id")
	List<Seat> selectedSeatId(@Param(value = "seat_id") Long seat_id);
	*/
}