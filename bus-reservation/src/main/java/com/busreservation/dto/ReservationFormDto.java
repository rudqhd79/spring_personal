package com.busreservation.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.busreservation.constant.SeatReservationStatus;
import com.busreservation.entity.Bus;
import com.busreservation.entity.Customer;
import com.busreservation.entity.Reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationFormDto {
	
	private Long id;	//예약 아이디
	
	private int reservationPeople;	//예약 인원
	
	private int reservationPrice;	//예약 금액
	
	private List<Long> busSeatIds = new ArrayList<>();		//좌석의 아이디(어떤 좌석인지)를 저장
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Reservation createReservation() {
		return modelMapper.map(this, Reservation.class);
	}

	public static ReservationFormDto of(Reservation reservation) {
		return modelMapper.map(reservation, ReservationFormDto.class);
	}
}
