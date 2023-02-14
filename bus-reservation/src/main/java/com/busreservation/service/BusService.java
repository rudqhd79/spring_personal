package com.busreservation.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busreservation.dto.BusDto;
import com.busreservation.entity.Bus;
import com.busreservation.repository.BusRepository;
import com.busreservation.repository.TerminalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BusService {
	
	BusRepository busRepository;

	
	@Transactional(readOnly = true) //트랜잭션 읽기 전용(변경감지 수행하지 않음) -> 성능향상
	public BusDto getBusInfo(Long busId) {
	
		Bus bus = busRepository.findById(busId).orElseThrow(EntityNotFoundException::new);
		//엔티티 객체 -> dto객체로 변환
		BusDto busDto = BusDto.of(bus);
		
		return busDto;
	}
}
