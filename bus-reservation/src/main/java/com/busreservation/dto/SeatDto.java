package com.busreservation.dto;

import org.modelmapper.ModelMapper;

import com.busreservation.constant.SeatReservationStatus;
import com.busreservation.entity.Bus;
import com.busreservation.entity.Seat;

public class SeatDto {

	private Long seat_id;	//좌석 아이디
	
	private Bus bus_id;	//버스 아이디
	
	private int seat_no;	//좌석 번호
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static SeatDto of(Seat seat) {
		return modelMapper.map(seat, SeatDto.class);
	}
	
}
