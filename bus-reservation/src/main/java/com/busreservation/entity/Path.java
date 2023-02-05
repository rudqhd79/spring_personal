package com.busreservation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import bus.busreservation.constant.Role;
import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Table(name="path")
@Entity
@Getter
@Setter
@ToString
public class Path {

	private Long path_id;	//경로 아이디
	
	private Bus bus_id;	//버스 아이디
	
	private String path_start;	//경로 시작점
	
	private String path_end;		//경로 끝지점
	
	private Date path_start_time;	//경로 출발시간
	
	private Date path_start_end;	//경로 도착시간
	
}
