package com.busreservation.service;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busreservation.dto.PathDto;
import com.busreservation.entity.Path;
import com.busreservation.entity.Terminal;
import com.busreservation.repository.PathRepository;
import com.busreservation.repository.TerminalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PathService {
	
}
