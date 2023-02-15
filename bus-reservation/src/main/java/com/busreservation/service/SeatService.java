package com.busreservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busreservation.dto.SeatDto;
import com.busreservation.entity.Bus;
import com.busreservation.entity.BusSeat;
import com.busreservation.repository.BusSeatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SeatService {

	private final BusSeatRepository seatRepository;
	 
	//좌석 아이디를 entity -> dto 변환
	@Transactional
	public List<SeatDto> getSeats() {
		
		List<BusSeat> seatList = seatRepository.findAll();
		List<SeatDto> seatDtoList = new ArrayList<>();
		
		for (BusSeat seat : seatList) {
			SeatDto seatDto = SeatDto.of(seat);
			seatDtoList.add(seatDto);
		}
		return seatDtoList;
	}
	
	//선택된 좌석 아이디 -> List로 담기
	
}
