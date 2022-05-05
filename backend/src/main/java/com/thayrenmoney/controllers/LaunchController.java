package com.thayrenmoney.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
