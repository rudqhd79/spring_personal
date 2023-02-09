package com.busreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.busreservation.entity.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal, Long> {
	
	//터미널에서 출발, 도착 지점 select box에서 보여주는 쿼리
}
