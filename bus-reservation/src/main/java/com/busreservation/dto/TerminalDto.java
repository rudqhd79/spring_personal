package com.busreservation.dto;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Query;

import com.busreservation.entity.Terminal;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TerminalDto {

	private Long terminalId;
	
	private String terminalName;
	
	@QueryProjection
	public TerminalDto(Long terminal_id, String terminalName) {
		this.terminalId = terminal_id;
		this.terminalName = terminalName;
	}
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static TerminalDto of(Terminal terminal) {
		return modelMapper.map(terminal, TerminalDto.class);
	}
}
