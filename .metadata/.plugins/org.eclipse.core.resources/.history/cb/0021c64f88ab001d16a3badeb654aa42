package com.busreservation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.busreservation.constant.Role;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Table(name="path")
@Entity
@Getter
@Setter
@ToString
public class Path {

	@Id
	@Column(name = "path_id")
	private Long path_id;	//경로 아이디
	
	@JoinColumn(name = "bus_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Bus bus;	//버스 아이디
	
	@Column(name = "path_start")
	private String path_start;	//경로 시작점
	
	@Column(name = "path_end")
	private String path_end;		//경로 끝지점
	
	@Column(name = "path_start_time")
	private String path_start_time;	//경로 출발시간
	
	@Column(name = "path_end_time")
	private String path_end_time;	//경로 도착시간
}
