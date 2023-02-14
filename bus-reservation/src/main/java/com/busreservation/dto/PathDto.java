package com.busreservation.dto;


import org.modelmapper.ModelMapper;

import com.busreservation.entity.Bus;
import com.busreservation.entity.Path;
import com.busreservation.entity.Terminal;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PathDto {
	
	private Long path_id;	//경로 아이디
	
	private Bus bus;	//버스 아이디
	
	private String path_start;	//경로 시작점
	
	private String path_end;		//경로 끝지점
	
	private String path_start_time;	//경로 출발시간
	
	private String path_end_time;	//경로 도착시간
	
	private Terminal terminal_id;

	private static ModelMapper modelMapper = new ModelMapper();
	
	public static PathDto of(Path path) {
		return modelMapper.map(path, PathDto.class);
	}
	
	
}
