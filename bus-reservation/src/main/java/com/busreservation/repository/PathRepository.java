package com.busreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.busreservation.entity.Path;
import com.busreservation.entity.Terminal;

public interface PathRepository extends JpaRepository<Path, Long> {
	
	//출발점, 도착점과 겹치는 경로 가져오기
	@Query(value = "select * from Path p, Bus b where p.bus_id = b.bus_id and p.path_start = :path_start and p.path_end = :path_end", nativeQuery = true)
	List<Path> findByPath(@Param("path_start") String start, @Param("path_end") String end);
	
}
