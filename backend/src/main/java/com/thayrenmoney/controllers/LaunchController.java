package com.thayrenmoney.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thayrenmoney.entities.Launch;
import com.thayrenmoney.services.LaunchService;

@RestController
@RequestMapping(value = "/launches")
public class LaunchController {
	
	@Autowired
	private LaunchService service;
	
	@GetMapping
	public ResponseEntity<List<Launch>> findAll(){
		
		List<Launch> list = new ArrayList<>();
		list = service.findAllPaged();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Launch> findById(@PathVariable Long id){
		Launch Launch = service.findById(id);
		return ResponseEntity.ok().body(Launch);
	}
	
	@PostMapping
	public ResponseEntity<Launch> insert(@RequestBody Launch launch){
		launch = service.insert(launch);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(launch.getId()).toUri();
		return ResponseEntity.created(uri).body(launch);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Launch> update(@PathVariable Long id, @RequestBody Launch launch){
		launch = service.update(id, launch);
		return ResponseEntity.ok().body(launch);
	}
	
}
