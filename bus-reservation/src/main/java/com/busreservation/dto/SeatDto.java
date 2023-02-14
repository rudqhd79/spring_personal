package com.busreservation.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.busreservation.entity.Bus;
import com.busreservation.entity.Seat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatDto {

	private Long seat_id;	//좌석 아이디
	
	private Bus bus;	//버스 아이디
	
	private int seat_no;	//좌석 번호
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static SeatDto of(Seat seat) {
		return modelMapper.map(seat, SeatDto.class);
	}
	
}
