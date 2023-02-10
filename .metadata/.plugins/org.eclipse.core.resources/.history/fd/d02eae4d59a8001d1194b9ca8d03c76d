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
	
//	경범님
//	빈순환 참조 문제 입니다.
//	빈 순환 참조는 생성자를 통해서 빈을 주입했을 때, Bean A -> Bean B -> Bean A … 계속해서 순환 참조하는 것을 말한다.

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
