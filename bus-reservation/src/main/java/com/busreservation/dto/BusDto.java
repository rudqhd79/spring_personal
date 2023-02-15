package com.busreservation.dto;

import org.modelmapper.ModelMapper;

import com.busreservation.entity.Bus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusDto {

	private Long id; // 버스 아이디

	private String busKind; // 버스 종류(버스 회사 종류)

	private int busTotalSeat; // 버스 총 좌석
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static BusDto of(Bus bus) {
		return modelMapper.map(bus, BusDto.class);
	}

}
