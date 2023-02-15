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

	private Long id;
	
	private String terminalName;
	
	@QueryProjection
	public TerminalDto(Long id, String terminalName) {
		this.id = id;
		this.terminalName = terminalName;
	}
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static TerminalDto of(Terminal terminal) {
		return modelMapper.map(terminal, TerminalDto.class);
	}
}
