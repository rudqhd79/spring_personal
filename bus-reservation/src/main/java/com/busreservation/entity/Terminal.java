package com.busreservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Table(name="terminal")
@Entity
@Getter
@Setter
@ToString
public class Terminal {
	
	@Id
	@Column(name = "terminal_id")
	private Long id;

	private String terminalName;
}
