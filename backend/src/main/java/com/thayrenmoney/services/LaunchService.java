package com.thayrenmoney.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thayrenmoney.entities.Launch;
import com.thayrenmoney.repositories.LaunchRepository;

@Service
public class LaunchService {
	
	@Autowired
	private LaunchRepository repository;
	
	@Transactional(readOnly = true)
	public List<Launch> findAllPaged() {
		List<Launch> list = new ArrayList<>();
		list = repository.findAll();

		return list;
	}

}