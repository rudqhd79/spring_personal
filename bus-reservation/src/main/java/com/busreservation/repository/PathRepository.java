package com.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busreservation.entity.Path;

public interface PathRepository extends JpaRepository<Path, Long> {

}
