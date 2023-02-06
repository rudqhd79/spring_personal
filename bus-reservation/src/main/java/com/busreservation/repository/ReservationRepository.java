package com.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busreservation.entity.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
