package com.thayrenmoney.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	@Transactional(readOnly = true)
	public Launch findById(Long id) {
		Optional<Launch> obj = repository.findById(id);
		Launch entity = obj.get();
		return entity;
	}
	
	@Transactional
	public Launch insert(Launch launch) {
		Launch entity = new Launch();
		entity.setDescription(launch.getDescription());
		entity.setDueDate(launch.getDueDate());
		entity.setPayDate(launch.getPayDate());
		entity.setValue(launch.getValue());
		entity.setObservation(launch.getObservation());
		entity = repository.save(entity);
		return entity;
	}
	
	@Transactional
	public Launch update(Long id, Launch launch) {
		Launch entity = repository.getOne(id);
		entity.setDescription(launch.getDescription());
		entity.setDueDate(launch.getDueDate());
		entity.setPayDate(launch.getPayDate());
		entity.setValue(launch.getValue());
		entity.setObservation(launch.getObservation());
		entity = repository.save(entity);
		return entity;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
