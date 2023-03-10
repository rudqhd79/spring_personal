package com.busreservation.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busreservation.entity.Customer;
import com.busreservation.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service //service 클래스의 역할
@Transactional //서비스 클래서에서 로직을 처리하다가 에러가 발생하면 로직을 수행하기 이전 상태로 되돌려 준다. 
@RequiredArgsConstructor
public class CustomerService implements UserDetailsService {	//UserDetailsService: 로그인시 request에서 넘어온 사용자 정보를 받음
	
	private final CustomerRepository customerRepository;	//의존성주입
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Customer customer = customerRepository.findByEmail(email);
		
		if(customer == null) {
			throw new UsernameNotFoundException(email);
		}
		
		//userDetails의 객체를 반환
		return User.builder()
				.username(customer.getEmail())
				.password(customer.getCustomerPassword())
				.roles(customer.getRole().toString())
				.build();
	}
	
	public Customer saveCustomer(Customer member) {
		validateDuplicateCustomer(member);
		return customerRepository.save(member);
	}

	private void validateDuplicateCustomer(Customer member) {
		Customer findMember = customerRepository.findByEmail(member.getEmail());
		if (findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
}
