package com.busreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busreservation.entity.ReservationSeat;

public interface ReservationSeatRepository extends JpaRepository<ReservationSeat, Long> {

}
