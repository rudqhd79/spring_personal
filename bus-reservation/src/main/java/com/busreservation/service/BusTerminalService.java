package com.busreservation.service;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busreservation.dto.TerminalDto;
import com.busreservation.entity.Terminal;
import com.busreservation.repository.TerminalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BusTerminalService {

	private final TerminalRepository terminalRepository;
	
	// 터미널 이름들 가져오기
	@Transactional(readOnly = true)
		public List<TerminalDto> getTerminals() {
			
			List<Terminal> terminalList = terminalRepository.findAll();
			List<TerminalDto> terminalDtoList = new ArrayList<>();
			
			for (Terminal terminal :terminalList) {
				TerminalDto terminalDto = TerminalDto.of(terminal);
				terminalDtoList.add(terminalDto);
			}
			return terminalDtoList;
		}
}
