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
	private Long id;	//경로 아이디
	
	@JoinColumn(name = "bus_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Bus bus;	//버스 아이디
	
	private String pathStart;	//경로 시작점
	
	private String pathEnd;		//경로 끝지점
	
	private String pathStartTime;	//경로 출발시간
	
	private String pathEndTime;	//경로 도착시간
}
