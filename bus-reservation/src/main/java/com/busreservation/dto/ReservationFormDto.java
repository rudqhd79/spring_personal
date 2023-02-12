package com.busreservation.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.busreservation.constant.SeatReservationStatus;
import com.busreservation.entity.Bus;
import com.busreservation.entity.Customer;
import com.busreservation.entity.Reservation;

public class ReservationFormDto {
	
	private Long res_id;	//예약 아이디
	
	private Customer customer_id;	//고객 아이디
	
	private Bus bus_id;	//버스 아이디
	
	private int res_people;	//예약 인원
	
	private int res_price;	//예약 금액
	
	SeatReservationStatus seatReservationStatus;	//좌석 예매 상태 (예매 가능, 불가능)
	
	private List<Long> seatIds = new ArrayList<>();		//좌석의 아이디(어떤 좌석인지)를 저장
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Reservation createReservation() {
		return modelMapper.map(this, Reservation.class);
	}

	public static ReservationFormDto of(Reservation reservation) {
		return modelMapper.map(reservation, ReservationFormDto.class);
	}
}
