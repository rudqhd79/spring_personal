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

	@QueryProjection	//쿼리 dsl로 결과 조회시 MainItemDto 객체로 바로 받아올 수 있다
	public PathDto (Long path_id, Bus bus, String path_start, String path_end, String path_start_time, String path_end_time) {
		this.path_id = path_id;
		this.bus = bus;
		this.path_start = path_start;
		this.path_end = path_end;
		this.path_start_time = path_start_time;
		this.path_end_time = path_end_time;
	}
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static PathDto of(Path path) {
		return modelMapper.map(path, PathDto.class);
	}
	
	
}
