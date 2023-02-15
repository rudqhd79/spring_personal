package com.busreservation.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.busreservation.entity.Bus;
import com.busreservation.entity.BusSeat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatDto {

	private Long id;	//좌석 아이디
	
	//private Bus bus;	//버스 아이디
	
	//private int seatNo;	//좌석 번호
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static SeatDto of(BusSeat seat) {
		return modelMapper.map(seat, SeatDto.class);
	}
	
}
